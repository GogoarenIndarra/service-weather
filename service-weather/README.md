# service description
service provides weather for any city, fetched from api.openweathermap.

In order to limit calls to external api, application can work in two modes:  
 - cache mode - responses from api.openweathermap are stored in application cache.
 - db mode - responses from api.openweathermap are stored in h2 db.

Mode is selected via application properties:  
  whether.service.implementation.type=cache / db


http://localhost:8080/api/weather/{enter_city_name}  
http://localhost:8080/api/weather/topCity  
http://localhost:8080/api/weather/topTen  
http://localhost:8080/api/weather/saveCity  
http://localhost:8080/api/weather/temperatureOverTenDegree   
http://localhost:8080/api/weather/statistic/PL    
http://localhost:8080/api/weather/getCities  
  
Service has REST controllers for getting weather, statistic, and  save records.


Missing features:
Deleting records (REST DELETE)


# learning resources

stream: https://www.baeldung.com/java-list-to-map  
scheduled java: https://www.baeldung.com/spring-scheduled-tasks  
crone generator: https://www.freeformatter.com/cron-expression-generator-quartz.html  
kafka for spring: https://www.baeldung.com/spring-kafka  
starting kafa on windows https://zablo.net/blog/post/setup-apache-kafka-in-docker-on-windows/  
json to Object https://www.baeldung.com/jackson-object-mapper-tutorial  
stream groupBy https://blog.marcinchwedczuk.pl/grouping-using-java-8-streams  
