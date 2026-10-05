def call(Map config = [:]) {
  def msg  = config.get('msg', 'hellooo')
  bat "mvn -f ./my-app/pom.xml clean" 
}
