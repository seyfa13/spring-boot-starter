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
