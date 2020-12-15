package com.controller.YoucodeGotTalent;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.config.YoucodeGotTalent.Config;
import com.method.YoucodeGotTalent.Methods;
import com.models.YoucodeGotTalent.User;


public class UserController {
	Config config;
	
	
	public UserController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegt","root","");
		
	}
	
	public void display() throws SQLException {
		
		String query = "Select * from users";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			System.out.println(resultSet.getString("first_name"));
			
		}  
//		
	}
	// Add user
	public void AddUser(String first_name,String last_name,String email,String phone) {
		PreparedStatement stmt;
		ResultSet rs;
		Statement stmt2;
		try {
			String sql = "INSERT INTO users (user_id,first_name,last_name,email,phone) VALUES(?,?,?,?,?)";
			Methods mt = new Methods();
			stmt = config.connect().prepareStatement(sql);
			Long id =mt.randomId();
			stmt.setLong(1, id);
			stmt.setString(2, first_name);
			stmt.setString(3, last_name);
			stmt.setString(4, email);
			stmt.setString(5, phone);
			stmt.executeUpdate();
			sql = "SELECT * FROM users";
			stmt2 = config.connect().createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt2.executeQuery(sql);
			rs.last();
			System.out.println("votre compte est bien enregistre votre information est :\nnom : "+rs.getString("first_name")+
					"\nprenom : "+rs.getString("last_name")+"\nemail : "+rs.getString("email")+"\nphone : "+rs.getString("phone")+
					"\nId : "+rs.getLong("user_id")+" enregistre votre id pour participe");
		} catch (SQLException e) {
			e.getMessage();
		}finally {
			
			rs=null;
			stmt= null;
			stmt2 = null;
		}
		
		
	}
	
	
	// find user by id
//	public User findUserById() {
//		//return user
//	}
	// update user by id 
	
	public void updateUser() {
	
	}
	

}
