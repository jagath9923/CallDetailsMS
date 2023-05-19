pipeline {
    agent any
    tools {
        maven 'apache-maven-3.9.2'
        jdk 'openjdk11'
    }
    stages {
        stage('SCM CheckOut') {
            steps {
                checkout scmGit(branches: [[name: '*/main']], extensions: [], userRemoteConfigs: [[url: 'https://github.com/jagath9923/CallDetailsMS']])
            }
        }
        stage('Build Maven') {
            steps {
                bat 'mvn clean install'
            }
        }
        stage('Build Docker Image') {
            steps {
                script {
                    bat 'docker build -t jagath9923/calldetailsms .'
                }
            }
        }
        stage('Push Image to Hub') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'docker_hub', passwordVariable: 'docker_hub_pwd', usernameVariable: 'docker_hub_usr')]) {
                    bat 'docker login --username %docker_hub_usr% --password %docker_hub_pwd%'
                }
                bat 'docker push jagath9923/calldetailsms'
                // jagath9923/calldetailsms:%BUILD_NUMBER%'
            }  
        }
        stage('Deploy to k8s'){
            steps{
                script{
                    kubernetesDeploy (configs: 'deploymentservice.yaml',kubeconfigId: 'minikube_config_pwd')
                }
            }
        }
    }
    post {
        always {
          bat 'docker logout'
        }
    }
}
