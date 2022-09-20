#!/usr/bin/env groovy

node('worker') {

    stage('Checkout code') {
         checkout([$class: 'GitSCM',
         branches: [[name: '*/main']],
         userRemoteConfigs: [[url: 'https://github.com/SathishkumarDemoProject1/Devops.git']]])
    }
    def mvnImage = docker.image('maven:3.5.4-jdk-11');

    currentStage = 'Sonar Analysis'
    stage(currentStage) {
         withSonarQubeEnv('SONAR') {
            mvnImage.inside() {
                // Increment version number. Required by SonarQube
                // for comparison with previous_version [leak period]
                nxtBuildNumber = lastSuccessfulBuild(currentBuild) == 0 ? 1 : lastSuccessfulBuild(currentBuild).getNumber() + 1
                sh('mvn build-helper:parse-version versions:set -DnewVersion=\\${parsedVersion.majorVersion}.' + "${nxtBuildNumber}" + '.0 versions:commit')
                sh('mvn clean install');
                sh('echo "Sonar analysis is in progress.."')
                sh "mvn clean verify sonar:sonar -Dsonar.projectKey=devops"
            }
       }
    }
    currentStage = 'Quality Gate Check'
    stage(currentStage) {
        // We are asking process to sleep for 10 Seconds so that SONAR server can complete processing.
        // Change this value if SONAR performing very slow in analysing, also find out the reason for analysing < 10s,
        // current processing time is ~2 to 4 Seconds on an average.
        sleep(20)
        timeout(time: 60, unit: 'SECONDS') {
            // Parameter indicates whether to set pipeline to UNSTABLE if Quality Gate fails
            // true = set pipeline to UNSTABLE
            // TODO: Set to true once quality gate threshold is set.
            waitForQualityGate abortPipeline: true
        }
    }

    currentStage = 'Build docker image'
    stage(currentStage) {
       sh 'docker build -t sathishkumar281995/merchant:latest .'
       sh 'echo $DOCKERHUB_CREDENTIALS_PSW | docker login -u $DOCKERHUB_CREDENTIALS_USR --password-stdin'
       sh 'docker push sathishkumar281995/merchant:latest .'
    }
}

@NonCPS
def lastSuccessfulBuild(build) {
    println "Last Build " + build
    if (build != null) {
        if (build.result.toString().equals("SUCCESS")) {
            return build;
        }
        //Recurse now to handle in chronological order
        lastSuccessfulBuild(build.getPreviousBuild());
    } else {
        return 0
    }
}
