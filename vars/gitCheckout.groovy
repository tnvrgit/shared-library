def call(Map config = [:]) {
    def branch  = config.get('branch', 'main')
    def repoUrl = config.get('url')
    
    if (!repoUrl) {
        error "gitCheckout Error: 'url' parameter is required."
    }
    
    checkout([
        $class: 'GitSCM', 
        branches: [[name: "refs/heads/${branch}"]],
        doGenerateSubmoduleConfigurations: false, 
        extensions: [[$class: 'CleanBeforeCheckout']], 
        submoduleCfg: [], 
        userRemoteConfigs: [[
            //credentialsId: credentials, 
            url: repoUrl
        ]]
    ])
}
