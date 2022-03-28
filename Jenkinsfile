pipeline {

    agent {
        label 'pipeline-test'
    }

    stages {

        stage("Build") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }

        stage("Deploy") {
            steps {
                sh "pwd"
                sh "ls -l"
                echo 'Deploy'
            }
        }

    }
   
}
