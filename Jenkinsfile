pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                  sh  './gradlew build'
            }
        }
        stage ('Test'){
            steps{

                Step{
                    input message: 'Approve tests??'
                }
            }
        }
        stage ('Deploy'){
        steps{
            Step{
                build job : 'Rueppellii - Practice/Pityu-Deploy'
            }
        }
    }
}
}
