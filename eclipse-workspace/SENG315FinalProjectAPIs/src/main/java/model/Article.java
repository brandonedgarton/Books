package model;

import java.sql.Connection;
import java.sql.Statement;

import org.json.JSONArray;
import org.json.JSONObject;

public class Article {
	
	int articleID;
	int articleAuthorID;
	String articleTitle;
	String articleContent;
	
	public Article() {
		
	}
	
    public Article(int articleID, int articleAuthorID, String articleTitle, String articleContent) {
    	this.articleID = articleID;
    	this.articleAuthorID = articleAuthorID;
    	this.articleTitle = articleTitle;
    	this.articleContent = articleContent;
	}
    
    public JSONArray getAllArticles() {
    	
    	JSONObject articleJSONObject = null;
    	JSONArray articlesJSONArray = new JSONArray();
        
    	try {
    		
        	MSSQLConnection mssqlConnection = new MSSQLConnection();
			Connection connection = mssqlConnection.getConnection();
			Statement stmt = connection.createStatement(
					java.sql.ResultSet.TYPE_SCROLL_INSENSITIVE, java.sql.ResultSet.CONCUR_READ_ONLY);
			
			String articlesQuery = "SELECT * " +
			  		"FROM SENG315FinalProject.dbo.articles WITH (NOLOCK) ";
				
				java.sql.ResultSet articlesResults = stmt.executeQuery(articlesQuery);
	
				while(articlesResults.next()){
					
					articleJSONObject = new JSONObject();
					
					String articleID = articlesResults.getString("articleID").trim();
					String articleAuthorID = articlesResults.getString("articleAuthorID").trim();
					String articleTitle = articlesResults.getString("articleTitle").trim();
					String articleContent = articlesResults.getString("articleContent").trim();
					
					articleJSONOBject.put();

				}

		    
			//Close Connections
			try { if (articlesResults != null) articlesResults.close(); } catch (Exception e) {}; 
	    	try { if (stmt!= null) stmt.close(); } catch (Exception e) {};
	    	try { if (connection != null) connection.close(); } catch (Exception e) {}; 
		
		} catch (Exception e) {
		    System.out.println(e.getMessage());
		}
    }
    
    //Getters and Setters
	public int getArticleID() {
		return articleID;
	}

	public void setArticleID(int articleID) {
		this.articleID = articleID;
	}

	public int getArticleAuthorID() {
		return articleAuthorID;
	}

	public void setArticleAuthorID(int articleAuthorID) {
		this.articleAuthorID = articleAuthorID;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleContent() {
		return articleContent;
	}

	public void setArticleContent(String articleContent) {
		this.articleContent = articleContent;
	}
    
}
