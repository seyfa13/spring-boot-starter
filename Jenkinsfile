pipeline {

    agent any

    stages {

        stage("Test") {
            steps {
                sh "mvn -version"
                sh "mvn clean install"
            }
        }

        stage("Build") {
            steps {
                echo 'Build'
            }
        }

        stage("Deploy") {
            steps {
                echo 'Deploy'
            }
        }

    }
    
    post {
        always {
            cleanWs()
        }
    }

}
