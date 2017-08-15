# springboot-rest-vehicleVinChecker



Features.
1. Spring boot
2. swagger API
3. Database operation
4. lombok


confirgure and build steps

1. $ mvn clean install
2. $ mvn spring-boot:run
3. open the brower and type http://localhost:8080
you will see the swagger screen 
4. enter http://localhost:8888/api-docs in swagger search bar(to-do : need to configure swagger path so that swagger directly show the operation rather then entering the http://localhost:8888/api-docs)
5.execute master table.txt to setup master data i.e. customer,parts,supplier
6.execute transactional tables.txt to retrive the data from database
7.To retrive the record using get operation - put number or record i.e, 2 or 3 and part id as 1111, 2222 and
click on  "try it out" from swagger UI
8.to insert the record please use below json payload


{
  "customers": {
    "id": 1,
    "name": "ashish"
  },
  "parts": [
    {
      "id": 1111,
      "supplier": {
        "id": 11,
        "name": "ABC Electronic"
      },
      "name": "RAM",
      "description": "RAM for laptop",
      "price": "40",
      "quantity": 4
    }
  ]
}

Note : currently in the database there are only few customer,
part and supplier record are there, we have to use(Insert Statement) only which are available in Masters tables


Before building the project we have to configure ojdbc to our lcoal maven repo
We have to add Oracle JDBC driver in your Maven local repository. follow the below step to configure OJBC to local maven repo
1. download ojdbc8.jar from oracle website
2. run the following command to create artifact in maven repo
mvn install:install-file -Dfile={Path/to/your/ojdbc8.jar}
      -DgroupId=com.oracle -DartifactId=ojdbc8 -Dversion=12.2.0.1 -Dpackaging=jar
3. mvn clean install
4. mvn idea:idea
