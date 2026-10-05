def call(Map config = [:]) {
  // 1. Set default values if not provided by the pipeline
    def mavenToolName = config.get('mavenTool', 'maven-3.10')
    def jdkToolName   = config.get('jdkTool', 'jdk-21')
    def goals         = config.get('goals', 'clean install')
    def pom_path      = config.get('pom_path')

    // 2. Wrap execution inside the tools block dynamically
    showTools(mavenToolName, jdkToolName) {
        // 3. Detect OS automatically to use 'sh' or 'bat'
        if (isUnix()) {
            sh "mvn -f $(pom_path) ${goals}"
        } else {
            bat "mvn -f $(pom_path) ${goals}"
        }
    }
}
