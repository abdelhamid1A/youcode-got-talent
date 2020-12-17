package com.controller.YoucodeGotTalent;

import java.awt.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.config.YoucodeGotTalent.Config;
import com.models.YoucodeGotTalent.Participation;
import com.models.YoucodeGotTalent.User;


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
//	start getAll
	public  ArrayList<User> getAll() throws SQLException {
		ArrayList<User> usersList = new ArrayList<>();
		if(verifyConnection()==true) {
			System.out.println("it s connect");
			
			String sql = "SELECT * FROM users";
			PreparedStatement stmt = config.connect().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				
				User user  = new User(rs.getLong("user_id"),rs.getString("last_name"),rs.getString("first_name"),rs.getString("email"),rs.getString("phone"));
				usersList.add(user);
				
			}
			
//			for(User list: usersList) {
//				System.out.println(list.toString());
//			}
	
			
		}
		return usersList;
	}
//	end getAll
	
	
//	start get all participation
	public  ArrayList<Participation> getAllParticipation() throws SQLException {
		ArrayList<Participation> participationList = new ArrayList<>();
		if(verifyConnection()==true) {
			//System.out.println("it s connect");
			
			String sql = "SELECT * FROM `participation`";
			PreparedStatement stmt = config.connect().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				Participation participation  = new Participation(rs.getLong("user_id"), rs.getLong("id_category"), rs.getString("description"), rs.getTimestamp("show_start_time"), 
						rs.getTimestamp("show_end_time"), rs.getString("attached_file"), rs.getBoolean("is_accepted"));
				participationList.add(participation);
				
			}
			
			
		}
		return participationList;
	}
	
	
//	end get all participation
	
	
//	start find user by email
	
	  public Participation findParticipationByEmail(String email) throws SQLException {
			String sql = "select * FROM `participation` INNER JOIN users ON participation.user_id= users.user_id and users.email ='" + email +"'";
					
			PreparedStatement stmt = config.connect().prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			rs.next();
				
				Participation participation  = new Participation(rs.getLong("user_id"), rs.getLong("id_category"), rs.getString("description"), rs.getTimestamp("show_start_time"), 
						rs.getTimestamp("show_end_time"), rs.getString("attached_file"), rs.getBoolean("is_accepted"));
				
				
			return  participation;
			
	  }

	// validate participation
      public void validateParticipation(long UserID) throws SQLException {
         String sql = "UPDATE participation SET is_accepted = '1' WHERE participation.user_id =" + UserID ;
            PreparedStatement stmt = config.connect().prepareStatement(sql);
            stmt.executeUpdate();

      }
		
//	end find user by email
      
      public long adminConnection(String email, String password) {
  		long idFD=0;
  		try {
  			
  			Statement stmt=null;
  			ResultSet rs= null;
  			String sql = "SELECT admins.admin_id,admins.password, users.email FROM admins INNER JOIN users ON admins.admin_id = users.user_id";
  			stmt = config.connect().createStatement();
  			rs= stmt.executeQuery(sql);
  			while(rs.next()) {
  				String emailFD = rs.getString("email");
  				String passwordlFD = rs.getString("password");
  				idFD = rs.getLong("admin_id");
  				if((emailFD.equals(email)) && (passwordlFD.equals(password))) {
  					sql = "UPDATE admin_session set is_connected = 1 WHERE id_admin = ?";
  					PreparedStatement stmt2 = config.connect().prepareStatement(sql);
  					stmt2.setLong(1,idFD);
  					stmt2.executeUpdate();
  					System.out.println("vous etez connectez :)");
  				}


  			}
  				
  		} catch (Exception e) {
  			e.getMessage();
  		}
  		return idFD;
  		
  	}
      
      public int isConnected(long id ) throws SQLException{
  		int res =0;
  		String sql = "select * from admin_session WHERE id_admin = "+ id +" and is_connected = 1 ";
  		Statement stmt = config.connect().createStatement();
  		ResultSet rs= stmt.executeQuery(sql);
  		if (rs.isBeforeFirst()) {
  			res=1;
  		}
  		return res;
  	}

}
