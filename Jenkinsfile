pipeline {

    agent any

    environment {

        IMAGE_NAME = "vamsi0497/java-app"
        TAG = "${BUILD_NUMBER}"
    }

    stages {

        stage('Checkout') {

            steps {

                git branch: 'main',
                url: 'git@github.com:teluguvamsi/java-app.git'
            }
        }

        stage('Build') {

            steps {

                sh 'mvn clean package'
            }
        }

        stage('Test') {

            steps {

                sh 'mvn test'
            }
        }

        stage('Build Docker Image') {

            steps {

                sh 'docker build -t $IMAGE_NAME:$TAG .'
            }
        }

        stage('Push Docker Image') {

            steps {

                withCredentials([usernamePassword(
                    credentialsId: 'dockerhub',
                    usernameVariable: 'USER',
                    passwordVariable: 'PASS'
                )]) {

                    sh 'echo $PASS | docker login -u $USER --password-stdin'

                    sh 'docker push $IMAGE_NAME:$TAG'
                }
            }
        }
    }
}
