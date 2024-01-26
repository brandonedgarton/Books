package SENG315.SpringFinalProject.rest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import SENG315.SpringFinalProject.service.UserService;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	@GetMapping
	public String listUsers() {
		
		JSONArray users = UserService.listUsers();
		
		return users.toString();
	}
	
	@PutMapping
	public String updateUser(@RequestBody String inputParms) {
		
		try {
			JSONObject result = UserService.updateUser(new JSONObject(inputParms));
		
			return result.toString();
		} catch (JSONException e) {
			e.printStackTrace();
			
			return "updateUsersAPI failed";
		}
	}
	
	@GetMapping(path="/{id}")
	public String getUser(@PathVariable int id) {
		
		JSONObject users = UserService.getUser(id);
		
		return users.toString();
	}
	
	@PostMapping
	public String addUser(@RequestBody String inputParms) {
		
		try {
			JSONObject result = UserService.addUser(new JSONObject(inputParms));
			
			return result.toString();
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		return "addUsersAPI failed";
	}

}
