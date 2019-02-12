pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                  sh 'make'
                  archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
        stage ('Test'){
            steps{
                    input message: 'Approve tests??'
            }
        }
        stage ('Deploy'){
        steps{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
        }
    }
}
}
