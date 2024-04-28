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
               stage('Install') {
                    steps {
        bat 'mvn install'
                        echo 'Installing... crud'
                    }
                }

    }
    post{
        always{
           echo 'Always me......'
        }
    }
}
