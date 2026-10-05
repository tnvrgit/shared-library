def call(Map config = [:]) {
  // 1. Set default values if not provided by the pipeline
    def mavenToolName = config.get('mavenTool', 'maven-3.10')
    def jdkToolName   = config.get('jdkTool', 'jdk-21')
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
