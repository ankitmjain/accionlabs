package test.java;

import static com.jayway.restassured.RestAssured.get;

import org.junit.BeforeClass;
import org.junit.Test;
import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.specification.RequestSpecification;

public class VehicleServiceTest {
	
	@BeforeClass
    public static void init() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
    }
	
	@Test
    public void listAllVhecles() {
		Response list = get("/accionlabs/Service/VehicleService/List").thenReturn();
		System.out.println(">>>> Response " +list.asString());
    }
	
	@Test
	public void addVheicle() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body("{\"name\":\"Load Truck\",\"make\":\"Ashok\",\"modal\":2015,\"modeOfTranport\":\"Road\",\"vehicleType\":\"Boat\",\"featureList\":[{\"feature_name\":\"Control Type\",\"feature_value\":\"Mannual\"},{\"feature_name\":\"numberofWheels\",\"feature_value\":\"16\"},{\"feature_name\":\"numberofSeats\",\"feature_value\":\"2\"}]\n" + 
				"}");
		Response response = request.post("/accionlabs/Service/VehicleService/AddVheicle");
		System.out.println(">>>> Response " +response.asString());
	}
	
	@Test
	public void addVheicle_Fail() {
		RequestSpecification request = RestAssured.given();
		request.header("Content-Type", "application/json");
		request.body("{\"name\":\"Load Truck\",\"make\":\"Ashok\",\"modal\":2015,\"modeOfTranport\":\"Road\",\"vehicleType\":\"fdsfds\",\"featureList\":[{\"feature_name\":\"Control Type\",\"feature_value\":\"Mannual\"},{\"feature_name\":\"numberofWheels\",\"feature_value\":\"16\"},{\"feature_name\":\"numberofSeats\",\"feature_value\":\"2\"}]\n" + 
				"}");
		Response response = request.post("/accionlabs/Service/VehicleService/AddVheicle");
		System.out.println(">>>> Response " +response.asString());
	}
	
	@Test
	public void getVeicheDetails() {
		Response list = get("/accionlabs/Service/VehicleService/1").thenReturn();
		System.out.println(">>>> Response " +list.asString());
	}
}
