def call() {
    node {
        stage('Checkout') {
            checkout scm
        }
        if (env.JOB_NAME.contains('deploy')) {
            packageArtifact()
        } else if (env.JOB_NAME.contains('test')) {
            buildAndTest()
        }
    }
}




def packageArtifact() {
    stage("Package artifact") {
        sh 'mvn package'
    }
}

def buildAndTest() {
    stage("Backend tests") {
        sh 'mvn test'
    }
}

