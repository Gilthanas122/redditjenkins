pipeline {
    agent any
    stages {
        stage('Example Build') {
            steps {
                echo 'Hello, Maven'
                sh 'gradle bootJar'
            }
        }
        stage('Example Test') {
            steps {
                echo 'Hello, JDK'
            }
        }
         stage('Deploy') {
                    steps {
                    build job : 'Rueppellii - Practice/Pityu-Deploy'
                    }
                }
    }
}
