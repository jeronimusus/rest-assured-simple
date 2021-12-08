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
        // stage("First Stage") {
        //     steps {
        //         sleep 5 // 10 seconds
        //         echo 'step 1, Hello World echo'
        //         script {
        //             sh "docker run hello_world_ruby_executes"
        //         }
        //     }
        // }
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
        stage('reports') {
            steps {
                script {
                    allure([
                        includeProperties: false,
                        jdk: '',
                        properties: [],
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: 'allure-results']]
                    ])
                }
            }
        }
    }
    post {
        success {
            echo 'The build was a success'
        }
    }
}