pipeline {
    agent any
    stages{
        stage('Init'){
                         steps{
                    sh 'gradle bootJar'
        }
        }
        stage('Test'){
            steps{
            echo 'Testing'
            }
        }
        stage ('Deploy'){
            steps{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
            }
        }
    }
}