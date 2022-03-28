pipeline {

    agent {
        label 'pipeline-test'
    }

    stages {

        stage("Test") {
            steps {
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
