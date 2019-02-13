pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                  sh './gradlew bootJar'
                  archiveArtifacts artifacts: 'gradle/wrapper/*.jar', fingerprint: true
            }
        }
        stage ('Test'){
            steps{
                    input message: 'Approve tests now??'
            }
        }
        stage ('Deploy'){
        steps{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
         }
    }
}
}
