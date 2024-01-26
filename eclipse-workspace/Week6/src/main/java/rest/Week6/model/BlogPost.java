package rest.Week6.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

public class BlogPost {
	
	int id;
	int userId;
	String title;
	String body;
	
	//Constructors
	public BlogPost() {
		
	}
	
	public BlogPost(int id, int userId, String title, String body) {
		this.id = id;
		this.userId = userId;
		this.title = title;
		this.body = body;
	}
	
	public String getAllPosts() {
		
		APICall apiCall	= new APICall();
		
		apiCall.setApiURL("https://jsonplaceholder.typicode.com/posts/");
		apiCall.setRequestMethod("GET");
		
		String apiResult = apiCall.makeAPICall();
		
		return apiResult;
		
	}
	
	public String getPost() {
		
		APICall apiCall	= new APICall();
		
		apiCall.setApiURL("https://jsonplaceholder.typicode.com/posts/"+id+"");
		apiCall.setRequestMethod("GET");
		
		String apiResult = apiCall.makeAPICall();
		
		return apiResult;
		
	}
	
	//getters and setters
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public Stirng getTitle() {
		return title;
	}

	public void setTitle(Stirng title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}
	
	

}
