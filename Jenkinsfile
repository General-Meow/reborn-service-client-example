/**
*/
node {
  docker.image('generalmeow/jenkins-tools:1.2-arm')
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
      sh 'mvn install'
    }
    stage('Deploy jar to artifactory') {
      echo 'Deploying Jar to Artifactory....'
      sh 'mvn deploy'
    }
    stage('Build Docker') {
      echo 'Building docker image....'
    }
    stage('Push Docker Image') {
      echo 'Pushing Docker Image....'
    }
    stage('Deploy Docker Image') {
      echo 'Deploying Docker Image....'
    }
  }
}