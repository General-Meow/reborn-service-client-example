/**
*/
pipeline {
    agent {
      /**
      Global docker build tools
      **/
      docker {
          image 'generalmeow/jenkins-tools:1.2-arm'
          args '-v /home/paul/work/docker/docker-maven-repo:/root/.m2/repository'
      }
    }
    stages {
      stage ('Initialize') {
        steps {
          sh '''
          echo "PATH = ${PATH}"
          echo "M2_HOME = ${M2_HOME}"
          '''
        }
      }
      stage('Checkstyle & PMD') {
          steps {
              echo 'Checkstyle & PMD..'
          }
      }
      stage('Build') {
          steps {
              echo 'Building..'
              sh 'mvn clean compile'
          }
      }
      stage('Test') {
          steps {
              echo 'Testing..'
              sh 'mvn test'
          }
      }
      stage('Maven Install') {
          steps {
              echo 'Installing artifact locally'
              sh 'mvn install'
          }
      }
      stage('Deploy jar to artifactory') {
          steps {
              echo 'Deploying Jar to Artifactory....'
              sh 'mvn deploy'
          }
      }
      stage('Build Docker') {
          steps {
              echo 'Building docker image....'
          }
      }
      stage('Push Docker Image') {
          steps {
              echo 'Pushing Docker Image....'
          }
      }
      stage('Deploy Docker Image') {
          steps {
              echo 'Deploying Docker Image....'
          }
      }

  }
}