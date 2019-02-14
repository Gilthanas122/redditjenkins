pipeline {
    agent any
    stages{
        steps{
        stage('Init'){
                         step{
                    sh 'gradle bootJar'

        }
        }
        }
        steps{
        stage('Test'){

            step{
            echo 'Testing'
            }
        }
        }
         steps{
        stage ('Deploy'){
            step{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
            }
        }
        }
    }
}