@Library('my-shared-lib')_

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
        }
      }
    }
 }
