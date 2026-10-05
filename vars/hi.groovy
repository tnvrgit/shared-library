def call(Map config = [:]) {
    def msg  = config.get('msg', 'hello')
    bat "echo ${msg}" 
}  
