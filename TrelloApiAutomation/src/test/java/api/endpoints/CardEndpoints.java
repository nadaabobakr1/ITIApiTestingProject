package api.endpoints;

import static io.restassured.RestAssured.given;
import api.payload.Card;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.apache.logging.log4j.util.StringBuilderFormattable;
import org.json.JSONObject;
import org.junit.Assert;

public class CardEndpoints {
	
public static Response createCard(Card payload){
		
		
		Response response =
			given()
			.pathParam("idList", payload.getIdList())
			.pathParam("name", payload.getCardname())
		   .contentType(ContentType.JSON)
		   .accept(ContentType.JSON)
		   .body(payload)
		.when() 
		   .post(Routes.post_card_url);
		
		return response;
		   
	}

public static Response getCard(String id){
	
	
	Response response =
		given()
	   .pathParam("id",id)
	.when() 
	   .get(Routes.get_card_url);
	
	return response;
	   
}

public static Response updateCard(String id, Card payload){
	
	
	Response response =
		given()
	   .contentType(ContentType.JSON)
	   .accept(ContentType.JSON)
	   .pathParam("id",id)
	   .body(payload)
	.when() 
	   .put(Routes.update_card_url);
	
	return response;
	   
}

public static Response deleteCard(String id){
	
	
	Response response =
		given()
	   .pathParam("id",id)
	.when() 
	   .delete(Routes.delete_card_url);
	
	return response;
	   
}
public static Response getCardField(String id){
	
	
	Response response =
		given()
	   .pathParam("id",id)
	.when() 
	   .get(Routes.get_card_field_url);
	
	return response;
	   
}
}
