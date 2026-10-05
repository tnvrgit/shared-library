def call(Map config = [:]) {
    // 1. Set default values if not provided by the pipeline
    def mavenToolName = config.get('mavenTool')
    def jdkToolName   = config.get('jdkTool')
    def goals         = config.get('goals', 'clean install')

    // 2. Wrap execution inside the tools block dynamically
    showTools(mavenToolName, jdkToolName) {
        // 3. Detect OS automatically to use 'sh' or 'bat'
        if (isUnix()) {
            sh "mvn ${goals}"
        } else {
            bat "mvn ${goals}"
        }
    }
}

// Helper method to bind tools within the script block
def showTools(String mavenName, String jdkName, Closure body) {
    // Obtains tools paths dynamically inside the script step
    def mvnHome = tool name: mavenName, type: 'hudson.tasks.Maven$MavenInstallation'
    def jdkHome = tool name: jdkName, type: 'hudson.model.JDK'
    
    withEnv(["PATH+MAVEN=${mvnHome}/bin", "JAVA_HOME=${jdkHome}"]) {
        body()
    }
}
