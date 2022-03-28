pipeline {

    agent any

    stages {

        stage("Test") {
            sh "mvn -version"
            sh "mvn clean install"
        }

        stage("Build") {
            echo 'Build'
        }

        stage("Deploy") {
            echo 'Deploy'
        }

    }

}
