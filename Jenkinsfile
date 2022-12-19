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
                echo 'Hello World'
            }
        }
                stage('Deployment') {
            steps {
                echo 'Hello World'
            }
        }
    }
    post{
        always{

            emailext body: 'This Build got completed', subject: 'Build Completed', to: 'mathewaugustine30@gmail.com'
        }
    }
}
