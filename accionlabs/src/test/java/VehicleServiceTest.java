package test.java;

import org.junit.BeforeClass;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.parsing.Parser;
import com.jayway.restassured.response.ValidatableResponse;

public class VehicleServiceTest {
	
	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }
	
	/*@BeforeClass
    public static void setup() {
        String port = System.getProperty("server.port");
        if (port == null) {
            RestAssured.port = Integer.valueOf(8080);
        }
        else{
            RestAssured.port = Integer.valueOf(port);
        }


        String basePath = System.getProperty("server.base");
        if(basePath==null){
            basePath = "/accionlabs/Service/";
        }
        RestAssured.basePath = basePath;

        String baseHost = System.getProperty("server.host");
        if(baseHost==null){
            baseHost = "http://localhost";
        }
        RestAssured.baseURI = baseHost;

    }*/
	@Test
    public void listAllVhecles() {
		ValidatableResponse values = get("/accionlabs/Service/VehicleService/List").then().defaultParser(Parser.JSON);
		System.out.println(values);
    }
}
