pipeline {
    agent any
    stages {
        stage('Git Checkout') {
            steps {
                git credentialsId: '30e3bc7c-69d9-4162-aec2-40bedf316d53', url: 'https://github.com/SharookhS/BDDFramework.git'
            }
        }
    }
}
