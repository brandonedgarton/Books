package rest.MysqlBYOProject.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import rest.MysqlBYOProject.MysqlDBUtil;
import rest.MysqlBYOProject.model.Contact;

public class MysqlContactsImpl implements ContactsDAO {

	@Override
	public String addContact(Contact contact) {
		String sql = "INSERT into contacts(name) values (?)";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contact.getActivity());
			
			stmt.executeUpdate();
			
			return contact.getActivity() + "added";
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Contact findById(Long id) {
        String sql = "SELECT * FROM contacts where id = ?";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setLong(1, id);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Contact c = new Contact();
				c.setId(rs.getLong("id"));
				c.setActivity(rs.getString("name"));

				return c;
			}
			rs.close();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String updateContact(Contact contact) {
        String sql = "UPDATE contacts set name=? where id=?";
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			
			stmt.setString(1, contact.getActivity());

			stmt.setLong(2, contact.getId());
			
			int count= stmt.executeUpdate();
			if(count == 0) {
				return "invalid id";
			}
			
			return contact.getId() + "updated";
		} catch(SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteContact(Long id) {
		String sql = "DELETE from contacts where id = ?";
		
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
	public List<Contact> findAll() {
		String sql = "SELECT * FROM contacts";
		List<Contact> list = new ArrayList<>();
		
		try {
			Connection conn = MysqlDBUtil.getConnection();
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				//System.out.println(rs.getString("name"));
				Contact c = new Contact();
				c.setId(rs.getLong("id"));
				c.setActivity(rs.getString("name"));
			
				list.add(c);
			}
			rs.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	    return list;
	}
	
}
