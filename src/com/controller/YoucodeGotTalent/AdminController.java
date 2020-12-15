package com.controller.YoucodeGotTalent;

import java.awt.List;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.config.YoucodeGotTalent.Config;
import com.models.YoucodeGotTalent.Participation;


public class AdminController {
	Config config;
	
	public AdminController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegb","root","");
		
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
	public List<user> findAllUser(){
	}
	// admin connection 
	public void adminConnection() {
		
	}
	// find participaions 
	  public List<Participation> findAllParticipation(){
		 // return //List
	  }
	// find participation by email 
	  public Participation findParticipationByEmail() {
		  //return Participation;
	  }
	// validate participation
	  public void validateParticipation() {
		  //.....
	  }

}
