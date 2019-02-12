pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                  sh  './gradlew bootJar'
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
