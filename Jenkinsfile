pipeline {
    agent any

    stages {
        stage('Checkstyle & PMD') {
            steps {
                echo 'Checkstyle & PMD..'
            }
        }
        stage('Build') {
            steps {
                echo 'Building..'
                sh 'pwd'
                sh './mvnw clean build'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                sh 'whoami'
                sh 'mvn test'
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