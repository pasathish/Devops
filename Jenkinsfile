pipeline {
    agent any
    stages {
        stage('Build') {
            agent {

                docker {
                    image 'maven:3.8.1-adoptopenjdk-11'
                    args '-v $HOME/.m2:/root/.m2'
                    reuseNode true
                }
            }
            steps {
                script{
                    // withSonarQubeEnv('sonarserver') { 
                    //     sh "mvn clean sonar:sonar"
                    // }
                    // timeout(time: 1, unit: 'HOURS') {
                    //     def qg = waitForQualityGate()
                    //       if (qg.status != 'OK') {
                    //         error "Pipeline aborted due to quality gate failure: ${qg.status}"
                    //       }
                    //   }
                      sh "mvn clean install"
		  
                 	}
            }
        }
    }
}