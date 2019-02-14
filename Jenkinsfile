pipeline {
    agent any
<<<<<<< HEAD
    environment {
        registry = "foxyfox/pityu-reddit"
        registryCredential = 'docker-technical-foxyfox'
        dockerImage = ''
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
                sh './gradlew bootJar'
                sh 'docker build -t redditimage:$GIT_COMMIT .'
                sh 'sudo docker login'
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
                sh 'sudo docker login'
                sh 'docker tag redditimage gilthanas122/reddit'
                sh 'docker push gilthanas122/reddit'
=======
    stages{
        stage('Init'){
               step{
                    sh 'gradle bootJar'

        }
        }
        stage('Test'){
            step{
            echo 'Testing now'
            }
        }

        stage ('Deploy'){
            step{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
>>>>>>> 5ba991b3ae5a592a3eaf0ebbca15f0d19a59b5db
            }
        }
    }
    post {
        // only triggered when blue or green sign
        success {
            slackSend
        }
        // triggered when red sign
        failure {
            slackSend
        }
        // trigger every-works
        always {
            slackSend
        }
    }
}