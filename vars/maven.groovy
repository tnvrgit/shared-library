def call(Map config = [:]) {
  def msg  = config.get('msg', 'hellooo')
  bat "echo ${msg}" 
}
