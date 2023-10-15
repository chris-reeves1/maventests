pipeline {
    agent any 

    tools {
        maven 'M3'  // Your Maven installation name
        jdk 'JDK'   // Your JDK installation name
    }
    
    stages {
        stage('Build') {
            steps {
                // Compile the code and package it
                script {
                    mvn 'clean package'
                }
            }
        }

        stage('Test') {
            steps {
                // Run unit tests
                script {
                    mvn 'test'
                }
            }
            post {
                always {
                    // Archive the test results
                    junit '**/target/surefire-reports/TEST-*.xml'
                }
            }
        }

        stage('Archive') {
            steps {
                // Archive the artifact
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
            }
        }
    }
}
