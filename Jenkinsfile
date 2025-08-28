pipeline {
  agent any
  tools { maven 'Maven3.9.11' }
  stages {
    stage('Checkout') {
      steps {
        checkout scm
      }
    }
    stage('Build & Test') {
      steps {
        sh 'mvn -B clean verify'
      }
    }
    stage('Package') {
      steps {
        sh 'mvn -B -DskipTests=true package'
      }
      post {
        success {
          archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
        }
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
    }
  }
}
