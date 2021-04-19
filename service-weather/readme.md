# service description
service provide weather for city from internal database if data are fresh otherwise fetch it from external service:
api.openweathermap.

Service has REST controllers for getting weather, statistic, and  save records.


Missing features:
Deleting records (REST DELETE)
Kafka messaging


# learning resources

stream: https://www.baeldung.com/java-list-to-map  
scheduled java: https://www.baeldung.com/spring-scheduled-tasks  
crone generator: https://www.freeformatter.com/cron-expression-generator-quartz.html  
kafka for spring: https://www.baeldung.com/spring-kafka  
starting kafa on windows https://zablo.net/blog/post/setup-apache-kafka-in-docker-on-windows/  
json to Object https://www.baeldung.com/jackson-object-mapper-tutorial  
stream groupBy https://blog.marcinchwedczuk.pl/grouping-using-java-8-streams  
