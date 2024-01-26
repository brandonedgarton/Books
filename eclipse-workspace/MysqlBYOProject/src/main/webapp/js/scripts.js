$(document).ready(function() {
	
	getContacts();
});

//Client side API call using AJAX
function getContacts(){
	
	$.ajax({
		url: "./webapi/contacts/",
		type: 'GET',
		dataType: "json",
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
	}).done(function(response) {
		
		$.each(response, function(key, value) {
			
			var lstResults = "<tr><td>"+value.activity+"</td>" + 
			"<td><a href = '#' onclick=editContact('"+value.id+"') data-toggle='tooltip' title='Edit'>Edit</a></td>" + 
			"<td><a href = '#' onclick=deleteContact('"+value.id+"') data-toggle='tooltip' title='Delete'>Delete</a></td></tr>";
			
			if($("#postBody").text()){
				document.getElementById('postBody').innerHTML += lstResults;
			}
		});
	});
}

function addContact() {
	
	var contactName = $("#contactName").val();
	
	if(contactName == ""){
		alert("Activity cannot be blank");
		$("#contactName").focus();
		return;
	}
	
	var parms = { activity:contactName };
	
	$.ajax({
		url: "./webapi/contacts/",
		type: 'POST',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		
	}).done(function(response) {
		
		window.location="./index.html";
	});
}

function deleteContact(id){
	
	$.ajax({
		url: "./webapi/contacts/"+id,
		type: 'DELETE',
		
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		
	}).done(function(response) {
		
		window.location="./index.html";
	});
}

function editContact(id){
	
	$("#editModal").modal('show');
	
	$.ajax({
		url: "./webapi/contacts/"+id,
		type: 'GET',
		contentType: "application/json",
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		console.log("Get Error");
		
	}).done(function(response) {
		console.log(response);
		$("#contactIDModal").val(response.id);
		$("#contactNameModal").val(response.activity);
	});
}	

function updateContact() {
	
	var contactIDModal = $("#contactIDModal").val();
	var contactNameModal = $("#contactNameModal").val();
	
	var parms = { id:contactIDModal, activity:contactNameModal };
	
	$.ajax({
		url: "./webapi/contacts/"+contactIDModal,
		type: 'PUT',
		contentType: "application/json",
		data: JSON.stringify(parms)
	}).fail(function(response) {
		console.log(JSON.stringify(response));
		
	}).done(function(response) {
		
		window.location="./index.html";
	});
}
	
	
	