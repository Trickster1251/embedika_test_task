# embedika_test_task

## Endpoints

### GET  
 **/cars/** return all cars with get parametrs for filtering
 **/cars/{id}** return car with id  
 **/cars/stats** return information about first and last date record in table, and count records  
 
### POST  
/cars/ add car in table, request parametr "licensePlate" must be a unique, otherwise you get json with "Object already exists"  
 
## How to launch
$ sudo docker-compose up
