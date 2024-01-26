package rest.MysqlBYOProject.dao;

import java.util.List;

import rest.MysqlBYOProject.model.Contact;

public interface ContactsDAO {
	
	//CRUD Operations
	public String addContact(Contact contact);
	
	public Contact findById(Long id);
	
	public String updateContact(Contact contact);
	
	public void deleteContact(Long id);
	
	//Queries
	public List<Contact> findAll();
	
}


