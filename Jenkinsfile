/**
*/
pipeline {
    agent any
      /*
      tools {
        maven 'Maven 3.5.2'
        jdk 'jdk8'
      }
      */
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
            agent {
                docker { image 'generalmeow/jenkins-tools:1.1-arm' }
            }
            steps {
                echo 'Building..'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            agent {
                docker { image 'generalmeow/jenkins-tools:1.1-arm' }
            }
            steps {
                echo 'Testing..'
                sh 'mvn test'
            }
        }
        stage('Maven Install') {
            agent {
                docker { image 'generalmeow/jenkins-tools:1.1-arm' }
            }
            steps {
                echo 'Installing artifact locally'
                sh 'mvn install'
            }
        }
        stage('Deploy jar to artifactory') {
            agent {
                docker { image 'generalmeow/jenkins-tools:1.1-arm' }
            }
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