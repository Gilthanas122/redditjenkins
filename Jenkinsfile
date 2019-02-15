pipeline {
    agent any
    environment {
        DOCKER_COMMON_CREDS = credentials('docker-technical-foxyfox')
    }
    stages {
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
                sh './gradlew bootJar'
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
            slackSend(
                    channel: '#rueppellii-jenkins',
                    color: '#36A64F',
                    message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} was successful"
            )
        }
        // triggered when red sign
        failure {
            slackSend(
                    channel: '#rueppellii-jenkins',
                    color: '#36A64F',
                    message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} failed "
            )
        }
        // trigger every-works
        always {
            slackSend(
                    channel: '#rueppellii-jenkins',
                    color: '#36A64F',
                    message: "Job: ${env.JOB_NAME} with buildnumber ${env.BUILD_NUMBER} has been triggered"
            )
        }
    }
}
