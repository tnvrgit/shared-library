def call(Map config = [:]) {
  def path  = config.get('path', './my-app/pom.xml')
  bat "mvn -f ${path} clean" 
}
