  pipeline {
        agent any

        tools {
            // Install the Maven version configured as "M3" and add it to the path.
            maven "M3"
        }

        stages {
            // not required - done by Jenkins
            // stage('Checkout') {
            //     steps {
            //         // Get some code from a GitHub repository
                    
            //         git branch: 'main', url: 'https://github.com/QA-Instructor/victoria-hello-java.git'
            //     }
            // }
            stage('Compile') {
                steps {
                    // Run Maven on a Unix agent.
                    sh "mvn clean compile"
                }
            }
            stage('Test') {
                steps {
                    // Run Maven on a Unix agent.
                    // Only use this switch if you want to continue with failing tests
                    // sh "mvn -Dmaven.test.failure.ignore=true test"
                    sh "mvn test"
                }
            }
            stage('Package') {
                steps {
                    // Run Maven on a Unix agent.
                    // Use this switch to avoid maven running the tests again
                    sh "mvn -Dmaven.test.skip package"
                }
            
                post {
                    // If Maven was able to run the tests, even if some of the test
                    // failed, record the test results and archive the jar file.
                    success {
                        junit '**/target/surefire-reports/TEST-*.xml'
                        archiveArtifacts 'target/*.jar'
                    }
                }  
            }    
        }
   
