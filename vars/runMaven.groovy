def call(Map config = [:]) {
  def pompath  = config.get('pompath')
  def goals = config.get('goals', 'clean install')
  if (!pompath) {
    error "Please enter pom path"
  }
  bat "mvn -f ${pompath} ${goals}" 
}
