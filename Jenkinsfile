pipeline {
    agent any

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World'
            }
        }
                stage('Build') {
            steps {
             bat 'mvn clean package'
                echo 'Building crud'
            }
        }
                stage('Test') {
            steps {
             bat 'mvn test'
                echo 'Testing crud'
            }
        }
               stage('Deplyment') {
                    steps {
        bat 'mvn deploy'
                        echo 'Deploying crud'
                    }
                }

    }
    post{
        always{
           echo 'Always me......'
        }
    }
}
