## Coding Assignment A

This repo is for the the back-end coding assignment of **.
Its a spring boot APP with developed with Java8.
The app exposes two endpoints and one endpoint takes 3 input parameters and calculate the total score based on
some static data.

#### Endpoints: 
/ : Just to check the status  
/calculateCreditScore : Return credit score based on 3 inputs.  


#### Testing:  
The source code contains both unit tests using TDD and BDD.  

#### Swagger:  
The APP also exposes swagger endpoint at http://IP:8085/swagger-ui.html  


For example :  
Input : Company Type,No Of employee, Time in Business
Output : Credit Score

### To Run as a docker container
```
docker run iamsoo/iamsoo-interview-a

```
Then <i>Go to IP:8085/swagger-ui.html</i>


### To build from git repo :clone , build, test &  run:

```
git clone git@github.com:IamSoo/iamsoo-interview-a.git
cd iamsoo-interview-a
mvn clean install
./mvnw spring-boot:run

```
Then <i>Go to IP:8085/swagger-ui.html</i>


### To build and run as docker container:
```
docker build -f Dockerfile -t iamsoo-interview-a .
docker run -p 8085:8085 iamsoo-interview-a
```