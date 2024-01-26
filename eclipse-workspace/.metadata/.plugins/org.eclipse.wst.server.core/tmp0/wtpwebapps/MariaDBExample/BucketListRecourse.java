//BucketListResource

package rest.MysqlBYOProject;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.Response;
import rest.MysqlBYOProject.model.BucketList;

@Path("/bucketList")
public class BucketListResource {
	
    private BucketListDAO dao = new MysqlBucketListImpl();
	
	@Path("/{id}")
	@GET
	@Produces("application/json")
	public Response getActivity(@PathParam("id") Long id) {
		
		return Response.ok(dao.findById(id)).build();
	}
	
	@GET
	@Produces("application/json")
	public Response getAllActivty() {
		
		return Response.ok(dao.findAll()).build();
	}
	
	@POST
	@Consumes("application/json")
	public Response addNewActivty(BucketList bucketList) {
		
		String result = dao.addActivity(bucketList);
		
		return Response.ok(result).build();
	}
	
	@Path("/{id}")
	@PUT
	@Consumes("application/json")
	public Response updateActivity(@PathParam("id") Long id, BucketList bucketList) {
		
		bucketList.setId(id);
		
		String result = dao.updateActivity(bucketList);
		
		return Response.ok(result).build();
	}
	
	@Path("/{id}")
	@DELETE
	public Response deleteActivtiy(@PathParam("id") Long id) {
		
		dao.deleteActivity(id);
		
		return Response.ok().build();
	}
}

//MysqlDBUtil

package rest.MysqlBYOProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public final class MysqlDBUtil {
	
	private static java.sql.Connection con = null;
	private static String url;
	private static String serverName;
	private static String portNumber;
	private static String userName;
	private static String password;
	private static String database;
	private static String driver;
	
	//Private so cannot be instantiated
	private MysqlDBUtil() {
		
	}
	
	//Static block loads when application first loads
	static {
		//Pulls jdbc properties
		ResourceBundle rb = ResourceBundle.getBundle("jdbc");
		url = rb.getString("MySQL.url");
		serverName = rb.getString("MySQL.serverName");
		portNumber = rb.getString("MySQL.portNumber");
		userName = rb.getString("MySQL.userName");
		password = rb.getString("MySQL.password");
		database = rb.getString("MySQL.database");
		driver = rb.getString("MySQL.driver");
	}
	
	public static Connection getConnection() {
		try {
			String connectionURL = url + serverName + ":" + portNumber + "/" +database;
			
			Class.forName(driver);
			con = DriverManager.getConnection(connectionURL, userName, password);
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Error Trace in getConnection() : " + e.getMessage());
		}
		return con;
	}

}

// BucketListDAO

package rest.MysqlBYOProject.dao;

import java.util.List;

import rest.MysqlBYOProject.model.BucketList;

public interface BucketListDAO {
	
	//CRUD Operations
		public String addActivity(BucketList bucketList);
		
		public BucketList findById(Long id);
		
		public String updateActivity(BucketList bucketList);
		
		public void deleteActivity(Long id);
		
		//Queries
		public List<BucketList> findAll();
		

}


// MysqlBucketListImpl

package rest.MysqlBYOProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rest.MysqlBYOProject.MysqlDBUtil;
import rest.MysqlBYOProject.model.BucketList;

public class MysqlBucketListImpl implements BucketListDAO{

	@Override
	public String addActivity(BucketList bucketList) {
        String sql = "INSERT into bucketListDB.Activity(Activity) values (?)";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, bucketList.getActivity());
			
			stmt.executeUpdate();
			
			return bucketList.getActivity() + "added";
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public BucketList findById(Long id) {
        String sql = "SELECT * FROM bucketListDB.Activity where id = ?";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				BucketList b = new BucketList();
				b.setId(rs.getLong("id"));
				b.setActivity(rs.getString("activity"));
				
				return b;
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateActivity(BucketList bucketList) {
        String sql = "UPDATE bucketListDB.Activity set Activity=?, where id=?";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, bucketList.getActivity());
			stmt.setLong(2, bucketList.getId());
			
			int count= stmt.executeUpdate();
			if(count == 0) {
				return "invalid id";
			}
			
			return bucketList.getId() + "updated";
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteActivity(Long id) {
        String sql = "DELETE from bucketListDB.Activity where id = ?";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setLong(1, id);
			
			stmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<BucketList> findAll() {
		String sql = "SELECT * FROM bucketListDB.Activity";
		List<BucketList> list = new ArrayList<>();
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println(rs.getString("name"));
				BucketList b = new BucketList();
				b.setId(rs.getLong("id"));
				b.setActivity(rs.getString("Activity"));

				list.add(b);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	    return list;
	}

}

// BucketList

package rest.MysqlBYOProject.model;

public class BucketList {
	
	private Long id;
	private String activity;
	
	public BucketList() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	
	
}


// jdbc.properties

MySQL.url=jdbc:mysql://
MySQL.serverName=localhost
MySQL.portNumber=3306
MySQL.driver=com.mysql.cj.jdbc.Driver
MySQL.userName=root
MySQL.password=RootUser007
MySQL.database=bucketListDB

// script

$(document).ready(function() {
	
	getActivity();
});

//Client side API call using AJAX
function getActivity(){
	
	$.ajax({
		url: "./webapi/Activity/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
	}).done(function(response) {
		
		$.each(response, function(key, value) {
			
			var lstResults = "<tr><td>"+value.Activity+"</td>" + 
			"<td><a href = '#' onclick=editContact('"+value.id+"') data-toggle='tooltip' title='Edit'>Edit</a></td>" + 
			"<td><a href = '#' onclick=deleteContact('"+value.id+"') data-toggle='tooltip' title='Delete'>Delete</a></td></tr>";
			
			if($("#postBody").text()){
				document.getElementById('postBody').innerHTML += lstResults;
			}
		});
	});
}

function addActivity() {
	
	var activityName = $("#activityName").val();
	
	if(activityName == ""){
		alert("Activity cannot be blank");
		$("#contactName").focus();
		return;
	}
	
	var parms = { name:activityName };
	
	$.ajax({
		url: "./webapi/Activity/",
		type: 'POST',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		
	}).done(function(response) {
		
		window.location="./index.html";
	});
}

function deleteActivity(id){
	
	$.ajax({
		url: "./webapi/Activity/"+id,
		type: 'DELETE',
		
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		
	}).done(function(response) {
		
		window.location="./index.html";
	});
}

function editActivity(id){
	
	$("#editModal").modal('show');
	
	$.ajax({
		url: "./webapi/Activity/"+id,
		type: 'GET',
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		console.log("Get Error");
		
	}).done(function(response) {
		console.log(response);
		$("#activityID").val(response.id);
		$("#activityName").val(response.activity);
	});
}	

function updateActivity() {
	
	var activityID = $("#activityID").val();
	var activityName = $("#activityName").val();
	
	var parms = { id:activityID, name:activityName };
	
	$.ajax({
		url: "./webapi/Activity/"+activityID,
		type: 'PUT',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		
	}).done(function(response) {
		
		window.location="./index.html";
	});
}

// HTML

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Full Width Pics - Start Bootstrap Template</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="css/styles.css" rel="stylesheet" />
    </head>
    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#!">Start Bootstrap</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
                    <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                        <li class="nav-item"><a class="nav-link active" aria-current="page" href="#!">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">About</a></li>
                        <li class="nav-item"><a class="nav-link" href="#!">Contact</a></li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- Header - set the background image for the header in the line below-->
        <header class="py-5 bg-image-full" style="background-image: url('https://source.unsplash.com/wfh8dDlNFOk/1600x900')">
            <div class="text-center my-5">
                <img class="img-fluid rounded-circle mb-4" src="https://dummyimage.com/150x150/6c757d/dee2e6.jpg" alt="..." />
                <h1 class="text-white fs-3 fw-bolder">Full Width Pics</h1>
                <p class="text-white-50 mb-0">Landing Page Template</p>
            </div>
        </header>
        <!-- Content section-->
        <section class="py-5">
            <div class="container my-5">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <h1>Bucket List</h1>
                            <table>
    	                        <tbody id="postBody">
    		                        <tr>
    			                        <th>Activity</th>
    			                        <th></th>
    			                        <th></th>
    		                        </tr>
    	                        </tbody>
                            </table>
                                <div class="form-group col-lg-3 col-centered">
				                    <label for="activityName">Activity</label>
				                    <input type="text" class="form-control" id="activityName" autofocus required>
				                </div>
				                <div id="btn-center" class="form-group">
				                 <span>
				                     <button class="btn btn-primary" type="submit" onclick="addActivity()" id="activityAdd" data-toggle="tooltip" title="Add Contact">Add Activity</button>
				                 </span>
				                 <span>
				                     <button class = "btn btn-secondary" type="button" onclick="window.history.back()" data-toggle="tooltip" title="Cancel">Cancel</button>
				                 </span>
				                </div>
                    </div>
                </div>
            </div>
            <div id="editModal" class="modal fade" tabindex="-1">
        	<div class="modal-dialog">
        		<div class="modal-content">
        			<div class="modal-header">
        				<h5 class="modal-title">Edit Activity</h5>
        				<button type="button" class="close" data-bs-dismiss="modal">&times;</button>
        			</div>
        			<div class="modal-body">
        				<div class="form-group col-lg-6 col-centered">
						    <label for="activityID">ID</label>
						    <input type="text" class="form-control" id="activityID" readonly>
						</div>
        				<div class="form-group col-lg-6 col-centered">
						    <label for="activityName">Name</label>
						    <input type="text" class="form-control" id="activityName">
						</div>
        			</div>
        			<div class="modal-footer">
        				<button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
        				<button class="btn btn-primary" type="submit" onclick="updateActivity()" id="activityUpdate" data-toggle="tooltip" title="Update Activity">Update Activity</button>
        			</div>
        		</div>
        	</div>
        </div>
        </section>
        <!-- Image element - set the background image for the header in the line below-->
        <div class="py-5 bg-image-full" style="background-image: url('https://source.unsplash.com/4ulffa6qoKA/1200x800')">
            <!-- Put anything you want here! The spacer below with inline CSS is just for demo purposes!-->
            <div style="height: 20rem"></div>
        </div>
        <!-- Content section-->
        <section class="py-5">
            <div class="container my-5">
                <div class="row justify-content-center">
                    <div class="col-lg-6">
                        <h2>Engaging Background Images</h2>
                        <p class="lead">The background images used in this template are sourced from Unsplash and are open source and free to use.</p>
                        <p class="mb-0">I can't tell you how many people say they were turned off from science because of a science teacher that completely sucked out all the inspiration and enthusiasm they had for the course.</p>
                    </div>
                </div>
            </div>
        </section>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>


// pom.xml

<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/maven-v4_0_0.xsd">

    <modelVersion>4.0.0</modelVersion>

    <groupId>rest</groupId>
    <artifactId>MysqlBYOProject</artifactId>
    <packaging>war</packaging>
    <version>0.0.1-SNAPSHOT</version>
    <name>MysqlBYOProject</name>

    <build>
        <finalName>MysqlBYOProject</finalName>
        <plugins>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-compiler-plugin</artifactId>
                <version>3.8.1</version>
                <inherited>true</inherited>
                <configuration>
                    <source>1.8</source>
                    <target>1.8</target>
                </configuration>
            </plugin>
            <plugin>
                <groupId>org.apache.maven.plugins</groupId>
                <artifactId>maven-war-plugin</artifactId>
                <version>3.4.0</version>
            </plugin>
        </plugins>
    </build>

    <dependencyManagement>
        <dependencies>
            <dependency>
                <groupId>org.glassfish.jersey</groupId>
                <artifactId>jersey-bom</artifactId>
                <version>${jersey.version}</version>
                <type>pom</type>
                <scope>import</scope>
            </dependency>
        </dependencies>
    </dependencyManagement>

    <dependencies>
        <dependency>
            <groupId>org.glassfish.jersey.containers</groupId>
            <artifactId>jersey-container-servlet-core</artifactId>
            <!-- use the following artifactId if you don't need servlet 2.x compatibility -->
            <!-- artifactId>jersey-container-servlet</artifactId -->
        </dependency>
        <dependency>
            <groupId>org.glassfish.jersey.inject</groupId>
            <artifactId>jersey-hk2</artifactId>
        </dependency>
        <!-- uncomment this to get JSON support
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-binding</artifactId>
        </dependency>
        -->
        <!-- https://mvnrepository.com/artifact/com.mysql/mysql-connector-j -->
        <dependency>
            <groupId>com.mysql</groupId>
            <artifactId>mysql-connector-j</artifactId>
            <version>8.1.0</version>
        </dependency>
        <!-- https://mvnrepository.com/artifact/org.glassfish.jersey.media/jersey-media-json-jackson -->
        <dependency>
            <groupId>org.glassfish.jersey.media</groupId>
            <artifactId>jersey-media-json-jackson</artifactId>
        </dependency>

    </dependencies>
    <properties>
        <jersey.version>3.1.3</jersey.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
        <war.mvn.plugin.version>3.4.0</war.mvn.plugin.version>
    </properties>
</project>
