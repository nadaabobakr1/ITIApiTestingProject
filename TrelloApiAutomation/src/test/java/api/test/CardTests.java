package api.test;
import com.github.javafaker.Faker;
import api.endpoints.CardEndpoints;
import api.payload.Card;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;


import org.testng.annotations.Listeners;

import org.testng.annotations.Test;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CardTests {
	
	Card cardPayload;

	@BeforeClass
    public   void setUpData() {
	
	
    cardPayload = new Card();
    
    
    cardPayload.setIdList("654a4f75f9d2ffd99e8f8992");
    cardPayload.setId("6552a2dd3335df5f59fc6d83");
    cardPayload.setName("new CARD");
    System.out.println(cardPayload.getIdList());
    System.out.println(cardPayload.getName());
	
}
	@Test(priority =1)
	public void testPostCard() {
		//testing on element of third list
		
		Response response =CardEndpoints.createCard(cardPayload);
		Assert.assertEquals(response.getStatusCode(), 200);
		response.then()
		.body("idList", equalTo("654a4f75f9d2ffd99e8f8992"));
		
		
 		
	}
	
	@Test(priority =2)
	public void testGetCardByID() {
		//testing on first element of second list
		
		Response response =CardEndpoints.getCard("654aa4f0e5ad637f7639428f");
		response.then().log().all()
		.body("id", equalTo("654aa4f0e5ad637f7639428f"))
		.body("idList", equalTo("654a4f7297eb09a1b64f8f81"))
		.body("name", equalTo("group 2"));
		

	
	}
	
	
	@Test(priority =3)
	public void testUpdateCardById() {
		
		
	
		this.cardPayload.setName("CARD UPDATED NAME");
	
		
		Response response =
				CardEndpoints.updateCard(this.cardPayload.getId(), cardPayload);
		response.then().log().body()
		.body("name", equalTo("CARD UPDATED NAME"));
		Assert.assertEquals(response.getStatusCode(), 200);
		
		


		
	
	}
	
	@Test(priority = 4)
	public void testDeleteCard() {
		Response response =
				CardEndpoints.deleteCard("6552a7497f3157effcaa60f7");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}

}
