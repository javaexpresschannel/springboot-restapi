pipeline {
    agent any 
   tools {
        maven "MAVEN"
     
    }
    stages {
        stage('Clean & Compile') { 
            steps {
                // Run Maven on a Unix agent.
              
                sh "mvn clean compile"
            }
        }
        stage('Build') { 
            
            steps {
                sh "mvn package"
            }
        }
        stage('Build Docker image'){
          
            steps {
                
                sh 'docker build -t  javaexpress/docker_jenkins_springboot:${BUILD_NUMBER} .'
            }
        }
        stage('Docker Login'){
            
            steps {
                 withCredentials([string(credentialsId: 'DockerId', variable: 'Dockerpwd')]) {
                    sh "docker login -u javaexpress -p ${Dockerpwd}"
                }
            }                
        }
        stage('Docker Push'){
            steps {
                sh 'docker push javaexpress/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }
        stage('Docker deploy in Ec2'){
            steps {
               
                sh 'docker run -itd -p  8081:8080 javaexpress/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }
        stage('Archving') { 
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
