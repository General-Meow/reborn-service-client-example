/**
*/
node {
  echo sh(script: 'env|sort', returnStdout: true)
  checkout scm
  docker.image('generalmeow/jenkins-tools:1.3-arm')
        .inside('-v /home/paul/work/docker/docker-maven-repo:/root/.m2/repository') {

    stage ('Initialize') {
      sh '''
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
      pom = readMavenPom file: 'pom.xml'

      def server = Artifactory.newServer url: 'http://tinker.paulhoang.com:8081/artifactory', credentialsId: 'artifactory'
      def downloadSpec = """{
       "files": [
        {
            "pattern": libs-release-local/com/paulhoang/reborn-service-client-example/${pom.version}/reborn-service-client-example-0.0.1.jar",
            "target": "downloads/app.jar"
          }
       ]
      }"""
      sh 'mkdir ./downloads'
      sh 'ls'
      sh 'cd downloads'

      server.download(downloadSpec)
      sh 'echo listing files'
      sh 'ech pwd'
      sh 'ls'
      echo 'Download comeplete'

      echo 'Building docker image....'
      def customImage = docker.build("rebord-service-client-example:${env.BUILD_ID}")

      echo 'Pushing Docker Image....'
    }
    stage('Deploy Docker Image') {
      echo 'Deploying Docker Image....'
    }
  }
}