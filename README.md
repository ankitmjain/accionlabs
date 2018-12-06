# accionlabs
Rest Webservice with Jax-Rs

Technology Stack : Jax-rs with Jersery and Spring DI for Implemenation and Database connection.
Database : my.db ( Sqllite )



Manage Vheicle with CRUD opration
1. LIST - List down all the vheicle registred.

    http://localhost:8080/accionlabs/Service/VehicleService/List
    Method Type : Get
    Input Parameter : None
    
2.  Add New Vheicle
    
    http://localhost:8080/accionlabs/Service/VehicleService/AddVheicle
    Method Type : Post
    Input Parameter : {"name":"Hundai Creat","category":"SUV"}
     
3.  Update Vheicle
    
    http://localhost:8080/accionlabs/Service/VehicleService/UpdateVheicle
    Method Type : Put
    Input Parameter : {"id":3,"name":"Hundai Creat","category":"SUV"}
    
4.  Get Vheicle Detail by ID

    http://localhost:8080/accionlabs/Service/VehicleService/{id}
    Method Type : Get
    Input Parameter : None
    
5.  Delete Vheicle
    
    http://localhost:8080/accionlabs/Service/VehicleService/{id}
    Method Type : Delete
    Input Parameter : None
    
6.  Search Vheicle by ID, Name or Category

    http://localhost:8080/accionlabs/Service/VehicleService/Search?keyword={anything from id,name or categoty}
    Method Type : Get
    Input Parameter : None
    
7.  Recent Delete

    http://localhost:8080/accionlabs/Service/VehicleService/RecentDelete
    Method Type : Delete
    Input Parameter : None
    
