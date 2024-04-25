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

            emailext body: 'This Build got completed', subject: 'Build Completed', to: 'mathewaugustine30@gmail.com'
        }
    }
}
