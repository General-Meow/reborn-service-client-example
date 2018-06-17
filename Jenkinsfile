/**
*/
node {
  docker.image('generalmeow/jenkins-tools:1.3-arm')
        .inside('-v /home/paul/work/docker/docker-maven-repo:/root/.m2/repository') {

    stage ('Initialize') {
      sh '''
      echo "PATH = ${PATH}"
      echo "M2_HOME = ${M2_HOME}"
      '''
    }
    stage('Checkstyle & PMD') {
      echo 'Checkstyle & PMD..'
    }
    stage('Build') {
      echo 'Building..'
      sh 'mvn clean compile'
    }
    stage('Test') {
      echo 'Testing..'
      sh 'mvn test'
    }
    stage('Maven Install') {
      echo 'Installing artifact locally'
      sh 'mvn install -DskipTests'
    }
    stage('Deploy jar to artifactory') {
      echo 'Deploying Jar to Artifactory....'
      sh 'mvn deploy -DskipTests'
    }
    stage('Build Docker') {
      echo 'downloading artifacts from artifactory....'
      def server = Artifactory.newServer url: 'http://tinker.paulhoang.com:8081/artifactory', credentialsId: 'artifactory'
      def downloadSpec = """{
       "files": [
        {
            "pattern": "reborn-service-client-example/*.jar",
            "target": "downloads/"
          }
       ]
      }"""
      server.download(downloadSpec)
      echo 'Download comeplete'

      echo 'Building docker image....'
      def customImage = docker.build("rebord-service-client-example-:${env.BUILD_ID}")

      echo 'Pushing Docker Image....'
    }
    stage('Deploy Docker Image') {
      echo 'Deploying Docker Image....'
    }
  }
}