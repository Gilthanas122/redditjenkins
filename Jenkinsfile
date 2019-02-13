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
                    input message: 'Approve tests now???'
            }
        }
       stage('PR for dev') {
                  when {
                      branch 'dev2'
                  }
                  steps {
                    sh 'git merge'
                  }
        }
        stage ('PR for master){
            when{
                branch 'master'
            }
            steps{
                 build job : 'Rueppellii - Practice/Pityu-Deploy'
            }
        }
    }
}