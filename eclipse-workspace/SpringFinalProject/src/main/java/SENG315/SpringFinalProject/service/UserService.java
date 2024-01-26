package SENG315.SpringFinalProject.service;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import SENG315.SpringFinalProject.model.User;

public class UserService {
	
    public static JSONArray listUsers() {
		
		JSONArray results = new JSONArray();
		
		User user = new User();
		results = user.listUsers();
		
		return results;
	}
    
    public static JSONObject getUser(int id) {
		
		JSONObject jo = new JSONObject();
		
		User user = new User();
		user.setUserID(id);
		
		jo = user.getUser();
		
		return jo;
	}
    
    public static JSONObject updateUser(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			int userID = inputParms.getInt("userID");
			String firstName = inputParms.getString("firstName");
			String lastName = inputParms.getString("lastName");
			String email = inputParms.getString("email");
			String username = inputParms.getString("username");
			String password = inputParms.getString("password");
			int active = inputParms.getInt("active");
			
			User user = new User();
			
			user.setUserID(userID);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			user.setActive(active);
			
			message = user.updateUser();
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
    
    public static JSONObject addUser(JSONObject inputParms) {
		
		String message = "";
		
		JSONObject result = new JSONObject();
		
		try {
			
			//int userID = inputParms.getInt("userID");
			String firstName = inputParms.getString("firstName");
			String lastName = inputParms.getString("lastName");
			String email = inputParms.getString("email");
			String username = inputParms.getString("username");
			String password = inputParms.getString("password");
			int active = inputParms.getInt("active");
			
			User user = new User();
			
			//user.setUserID(userID);
			user.setFirstName(firstName);
			user.setLastName(lastName);
			user.setEmail(email);
			user.setUsername(username);
			user.setPassword(password);
			user.setActive(active);
			
			message = user.addUser();
		
			result.put("message", message);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
    
    public static JSONObject authenticate(JSONObject inputParms) {
		
		JSONObject result = new JSONObject();
		
		try {
			
			String username = inputParms.getString("username");
			String password = inputParms.getString("password");
			
			User user = new User();
			
			user.setUsername(username);
			user.setPassword(password);
			
			result = user.authenticate();
		
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
}
