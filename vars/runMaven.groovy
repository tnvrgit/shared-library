def call(Map config = [:]) {
  def pompath  = config.get('pompath')
  def goals = config.get('goals', 'clean install')
  bat "mvn -f ${path} ${goals}" 
}
