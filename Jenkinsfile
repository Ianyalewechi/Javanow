pipeline {
    agent any

    tools {
        maven "3.8.5"
    }

    stages {
        stage('Build the application') {
            steps {
                sh "mvn clean package"
            }
        }

        stage('Build the Docker Image') {
            steps {
                sh "sudo docker build -t ikedi/Javanow:${BUILD_NUMBER} ."
            }
        }

        stage('Login to Docker ECR') {
            steps {
                withCredentials([string(credentialsId: 'IDS', variable: 'Dockerpwd')]) {
                    sh "sudo docker login -u ikedi -p ${Dockerpwd}"
                }
            }
        }

        stage('Push the Docker Image to Docker ECR') {
            steps {
                sh "sudo docker push ikedi/Javanow:${BUILD_NUMBER}"
            }
        }

        stage('Run the Application') {
            steps {
                // Kill any process occupying port 8090
                //sh "sudo kill -9 \$(sudo lsof -t -i:9000)"
                // Run the Docker container
                sh "sudo docker run -itd -p 9000:8080 ikedi/Javanow:${BUILD_NUMBER}"
            }
        }

        stage('Completion') {
            steps {
                echo "done deploying application"
            }
        }
    }
}