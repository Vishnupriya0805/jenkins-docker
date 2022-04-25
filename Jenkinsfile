pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
               echo 'building.....'
            }
        }
         stage('Build Docker Image') {
            steps {
                script {
                  bat 'docker build -t Vishnupriya0805/jenkins-docker .'
                }
            }
         }
    }
}
