package api.endpoints;
//https://api.trello.com/1/

public class Routes {
	
	public static String base_url ="https://api.trello.com/1/cards";
	
	static String key ="key=323ea3befaac9b212ad442792bca2f6d";
	static String token ="&token=ATTA5766188e9277180d09b1ec36f3b7398bad5ee8bf0a78d4ebdd2099a63b4c489b070C2DAC";
	




	
public static String post_card_url =base_url +"?{idList}/{name}"+"&"+key+token;

	
	public static String get_card_url =base_url +"/{id}?"+key+token;
	

	public static String update_card_url =base_url +"/{id}?"+key+token;
	

	public static String delete_card_url =base_url +"/{id}?"+key+token;


}
