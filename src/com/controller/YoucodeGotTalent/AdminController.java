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
			@SuppressWarnings("resource")
			Scanner inp = new Scanner(System.in);
			System.out.println("entre votre email");
			String email = inp.nextLine();
			System.out.println("entre votre mot de passe");
			String password = inp.nextLine();
//			SELECT admins.password, users.email FROM admins INNER JOIN users ON admins.admin_id = users.user_id
			String sql = "SELECT admins.admin_id,admins.password, users.email FROM admins INNER JOIN users ON admins.admin_id = users.user_id";
			stmt = config.connect().createStatement();
			rs= stmt.executeQuery(sql);
			while(rs.next()) {
				String emailFD = rs.getString("email");
				String passwordlFD = rs.getString("password");
				String idFD = rs.getString("admin_id");
				if((emailFD.equals(email)) && (passwordlFD.equals(password))) {
//					System.out.println("valid");
//					ResultSet rs2= null;
					sql = "UPDATE admin_session set is_connected = 1 WHERE id_admin = ?";
					PreparedStatement stmt2 = config.connect().prepareStatement(sql);
					stmt2.setString(1,idFD);
					stmt2.executeUpdate();
					System.out.println("vous etez connectez :)");
				}else {
					System.out.println("pas valide");
					}
			}
			
			
			inp.close();
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	public void logout() throws SQLException {
		
		String sql = "UPDATE admin_session SET is_connected = 0 WHERE id_admin = 15970010";
		PreparedStatement stmt = config.connect().prepareStatement(sql);
		stmt.executeUpdate();
		System.out.println("déconnecté avec succès");
		
	}
	
	
	public Boolean verifyConnection() throws SQLException {
		
			
				String sql = "SELECT * FROM admin_session WHERE id_admin = 15970010";
				PreparedStatement stmt;
				stmt = config.connect().prepareStatement(sql);
				ResultSet rs = stmt.executeQuery();
				rs.next();
				Boolean etat = rs.getBoolean("is_connected");
				return etat;
				
		
	
		
		
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
