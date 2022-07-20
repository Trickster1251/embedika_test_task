# embedika_test_task

## Endpoints

### GET #### /cars/ return all cars  
### GET #### /cars/{id} return car with id  
### GET #### /cars/stats return information about first and last date record in table, and count records  
 
### POST #### /cars/ add car in table, request parametr "licensePlate" must be a unique, otherwise you get json with "Object already exists"  
 
## How to launch
$ sudo docker-compose up
