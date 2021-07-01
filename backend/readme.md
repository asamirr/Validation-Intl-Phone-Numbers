# To solely test the backend web app

- Run `mvn spring-boot:run` here in "backend" directory
- Head to the browser and go to "http://localhost:8080/customers"

There's only one endpoint which is `/customers`. It takes 2 parameters (country and state) to return the validity 
state for the required country 

(To test it "http://localhost:8080/customers?country=Cameroon&valid=valid" and it returns the entire list
of the customers whether valid or not if no parameters were passed ("http://localhost:8080/customers")

