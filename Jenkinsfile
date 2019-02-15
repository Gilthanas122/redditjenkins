pipeline {
    agent any
    environment {
        DOCKER_COMMON_CREDS = credentials('docker-technical-foxyfox')
    }
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
                sh 'docker build -t redditimage:$GIT_COMMIT .'
                sh 'sudo docker login -u $DOCKER_COMMON_CREDS_USR -p $DOCKER_COMMON_CREDS_PSW'
                sh 'docker tag redditimage:$GIT_COMMIT foxyfox/pityu-reddit'
                sh 'docker push foxyfox/pityu-reddit'
            }
        }
        stage('Deploy for production') {
            when {
                branch 'master'
            }
            steps {
                sh 'docker build -t redditimage:$GIT_COMMIT .'
                sh 'sudo docker login -u $DOCKER_COMMON_CREDS_USR -p $DOCKER_COMMON_CREDS_PSW'
                sh 'docker tag redditimage:$GIT_COMMIT foxyfox/pityu-reddit'
                sh 'docker push foxyfox/pityu-reddit'
                build job: 'Rueppellii - Practice/Pityu-Deploy'
            }
        }
    }
    post {
        // only triggered when blue or green sign
        success {
            slackSend (channel: '@$rueppellii-jenkins', color: '#36A64F', message: "Job succeeded ")
        }
        // triggered when red sign
        failure {
            slackSend (channel: '@$rueppellii-jenkins', color: '#36A64F', message: "Job failed ")
        }
        // trigger every-works
        always {
            slackSend (channel: '@$rueppellii-jenkgins', color: '#36A64F', message: "Job has been triggered")
        }
    }
}
