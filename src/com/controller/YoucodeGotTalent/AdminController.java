package com.controller.YoucodeGotTalent;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.config.YoucodeGotTalent.Config;
import com.models.YoucodeGotTalent.Participation;


public class AdminController {
	Config config;
	
	public AdminController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegt","root","");
		
	}
	
	public void display() throws SQLException {
		
		String query = "Select * from Admin";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			System.out.println(resultSet.getString("name"));
			
		}  
		
	}
	
	
	
	
	// find all users
//	public List<user> findAllUser(){
//	}
	// admin connection 
	public void adminConnection() {
		try {
			Statement stmt=null;
			ResultSet rs= null;
			Scanner inp = new Scanner(System.in);
			System.out.println("entre votre email");
			String email = inp.nextLine();
			System.out.println("entre votre mot de passe");
			String password = inp.nextLine();
//			SELECT admins.password, users.email FROM admins INNER JOIN users ON admins.admin_id = users.user_id
			String sql = "SELECT admins.password, users.email FROM admins INNER JOIN users ON admins.admin_id = users.user_id";
			stmt = config.connect().createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				String emailFD = rs.getString("email");
				String passwordlFD = rs.getString("password");
				if((emailFD.equals(email)) && (passwordlFD.equals(password))) {
					System.out.println("valid");
				}else {System.out.println("pas valide");}
			}
			
			
//			inp.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	// find participaions 
//	  public List<Participation> findAllParticipation(){
//		 // return //List
//	  }
	// find participation by email 
//	  public Participation findParticipationByEmail() {
//		  //return Participation;
//	  }
	// validate participation
	  public void validateParticipation() {
		  //.....
	  }

}
