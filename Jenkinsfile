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
             sh 'mvn clean package'
                echo 'Building crud'
            }
        }
                stage('Test') {
            steps {
             sh 'mvn test'
                echo 'Testing crud'
            }
        }
               stage('Test') {
                    steps {
        sh 'mvn deploy'
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
