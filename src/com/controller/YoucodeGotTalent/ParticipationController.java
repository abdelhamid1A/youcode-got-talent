package com.controller.YoucodeGotTalent;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.config.YoucodeGotTalent.Config;

public class ParticipationController {
Config config;
	
	public ParticipationController() throws SQLException {
		
		config= new Config("jdbc:mysql://localhost/youcodegb","root","");
		
	}
	
	public void display() throws SQLException {
		
		String query = "Select * from participation";
		Statement statement = config.connect().createStatement();
		ResultSet resultSet = statement.executeQuery(query);
		
		while (resultSet.next()) {
			
			System.out.println(resultSet.getString("name"));
			
		}  
		
	}
	
	// add participation 
	public void addParticipation() {

	}
}
