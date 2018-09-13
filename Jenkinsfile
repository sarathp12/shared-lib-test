@Library('cicd-jenkins-shared-lib-test')_

pipeline {
    agent none

    tools  {
       maven 'maven 3.5.4'
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
           mbuild 'clean package'
        }
      }
      stage ('build')
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

