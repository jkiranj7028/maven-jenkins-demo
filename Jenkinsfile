pipeline {
  agent any
  tools { maven 'maven-3911' }
  stages {
    stage('Build & Test') {
      steps {
        sh mvn clean install -U
        //sh 'mvn -B clean verify'
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
