pipeline {
    agent any
    stages{
        stage('Init'){
               step{
                    sh 'gradle bootJar'

        }
        }
        stage('Test'){
            step{
            echo 'Testing'
            }
        }

        stage ('Deploy'){
            step{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
            }
        }
    }
}