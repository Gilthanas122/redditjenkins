pipeline {
    agent any
    stages {
        stage ('Build Servlet Project') {
            steps {
                    sh 'gradle bootJar'
            }
        }
        stage ('Test'){
            steps{
                    input message: 'Approve test now??'
            }
        }
        stage ('Deploy'){
                steps{
                if (env.BRANCH_NAME == 'master'){
                        build job : 'Rueppellii - Practice/Pityu-Deploy'
                        }
                if (env.BRANCH_NAME == 'dev'){
                    sh 'git merge'
                    echo 'Dev branch merged with master'
                }
                 }
            }
}
}