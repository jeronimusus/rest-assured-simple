pipeline {
    agent {
        // label 'slave_node_on_my_aws'
        label 'master'
    }
    parameters {
        booleanParam(name: 'DEBUG_BUILD', defaultValue: true,
        description: 'Is it the debug build?')
    }
    stages {
        stage("Second Stage") {
            steps {
                echo 'Step2, second time Hello World'
                echo 'Step3, third time Hello World'
            }
        }
        stage("Checkout") {
            steps {
                // git url: 'https://github.com/jeronimusus/rest-assured-simple'
                git branch: 'main', url: 'https://github.com/jeronimusus/rest-assured-simple'
                withMaven (
                    maven: 'maven_3_8_3'

                ) {// withMaven will discover the generated Maven artifacts, JUnit Surefire & FailSafe reports and FindBug
                sh "mvn clean verify"
                }
            }
        }

    }
    post {
        success {
            echo 'The build was a success us a Jenkinsfile'
        }
    }
}