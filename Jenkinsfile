pipeline {
    agent any
    environment {
        DOCKER_COMMON_CREDS = credentials('Dockerhub-technical-user-for-Malachite')

        stages {
            stage('Build') {
                steps {
                    sh './gradlew bootJar'
                }
            }
            stage('Test') {
                steps {
                    echo 'Running tests'
                }
            }
            stage('Deliver for development') {
                when {
                    branch 'dev'
                }
                steps {
                    sh './gradlew bootJar'
                    sh 'docker build -t redditimage:$GIT_COMMIT .'
                    sh 'sudo docker login -u $DOCKER_COMMON_CREDS_USR -p DOCKER_COMMON_CREDS_PSW'
                    sh 'docker tag redditimage foxyfox/pityu-reddit'
                    sh 'docker push foxyfox/pityu-reddit'
                }
            }
            stage('Deploy for production') {
                when {
                    branch 'master'
                }
                steps {
                    sh './gradlew bootJar'
                    sh 'docker build -t redditimage:$GIT_COMMIT .'
                    sh 'sudo docker login -u $DOCKER_COMMON_CREDS_USR -p DOCKER_COMMON_CREDS_PSW'
                    sh 'docker tag redditimage gilthanas122/reddit'
                    sh 'docker push gilthanas122/reddit'
                }
            }

            stage('Deploy Jenkins') {
                steps {
                    build job: 'Rueppellii - Practice/Pityu-Deploy'

                }
            }
        }
    }
}