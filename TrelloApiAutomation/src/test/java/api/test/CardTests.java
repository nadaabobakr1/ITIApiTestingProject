package api.test;
import com.github.javafaker.Faker;
import api.endpoints.CardEndpoints;
import api.payload.Card;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;

public class CardTests {
	
	Card cardPayload;

	@BeforeClass
    public   void setUpData() {
	
	
    cardPayload = new Card();
    
    
    cardPayload.setIdList("654a4f7297eb09a1b64f8f81");
    cardPayload.setId("654aa51a93a6321ffc28cd5f");
    cardPayload.setName("card 99");
    System.out.println(cardPayload.getIdList());
    System.out.println(cardPayload.getName());
	
}
	@Test(priority =1)
	public void testPostUser() {
		
		
		Response response =CardEndpoints.createCard(cardPayload);
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
		
 		
	}
	
	@Test(priority =2)
	public void testGetCardByID() {
		
		Response response =CardEndpoints.getCard(this.cardPayload.getId());
		response.then().log().all();
		Assert.assertEquals(response.getStatusCode(), 200);
	
	}
	
	
	@Test(priority =3)
	public void testUpdateCardById() {
		
		
	
		this.cardPayload.setName("updated card name 99");
	
		
		Response response =
				CardEndpoints.updateCard(this.cardPayload.getId(), cardPayload);
		response.then().log().body();
		Assert.assertEquals(response.getStatusCode(), 200);


		
	
	}
	
	@Test(priority = 4)
	public void testDeleteCard() {
		Response response =
				CardEndpoints.deleteCard("654aab881afb37bc4ba63e73");
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}

}
