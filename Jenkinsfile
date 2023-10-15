pipeline {
    agent any 

    tools {
        maven "M3"
    }

    stages {
        stage('Compile') {
            steps {
                script {
                    // Using the Maven Pipeline Plugin's mvn command
                    mvn "clean compile"
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    mvn "test"
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    // Skips running tests during the package phase
                    mvn "-DskipTests package"
                }
            }
            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.jar'
                }
            }  
        }    
    }
}
