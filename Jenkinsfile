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
                docker { image 'generalmeow/jenkins-tools:1.0-arm' }
            }
            steps {
                echo 'Building..'
                sh 'mvn clean compile'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'whoami'
                sh './mvnw test'
            }
        }
        stage('mvn Install') {
            steps {
                echo 'mvn install....'
            }
        }
        stage('Deploy artifact to artifactory') {
            steps {
                echo 'Deploying....'
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