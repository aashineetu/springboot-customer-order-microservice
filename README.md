# springboot-rest-vehicleVinChecker



Features.
1. Spring boot
2. swagger API
3. Database operation


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
part and supplier record are there, we have to use only which are available in Masters tables
