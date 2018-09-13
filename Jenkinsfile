@Library('cicd-jenkins-shared-lib-test')_

pipeline {
    agent none

    tools  {
       jdk 'jdk'
      }

    stages {

      stage ('test') {
         agent {
           label 'master'
        }
         steps {
           echo 'Hello World'
           sayHello 'Seumans'
        }
      }
      stage ('build') {
        agent {
           label 'master'
        }
         steps {
            echo "i am running"
            mbuild 'clean package'
            archiveArtifacts artifacts: '**/*.war'
           }
        }
    }
 }

