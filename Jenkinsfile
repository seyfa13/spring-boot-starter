pipeline {

    agent {
        label 'pipeline-test'
    }

    stages {

        stage("Build") {
            steps {
                echo 'Build'
                echo 'ork $WORKSPACE'
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
