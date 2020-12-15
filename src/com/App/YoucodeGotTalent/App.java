package com.App.YoucodeGotTalent;

import java.sql.SQLException;
//import java.util.Random;
import java.util.Scanner;

import com.controller.YoucodeGotTalent.AdminController;
import com.controller.YoucodeGotTalent.UserController;
import com.models.YoucodeGotTalent.User;
//import com.youcodeGotTalent.method.Methods;

public class App {

	public static void main(String[] args) throws SQLException {
		AdminController adminController = new AdminController();
		adminController.adminConnection();
		Scanner menu = new Scanner(System.in);
		System.out.println("phone");
		String phone = menu.next();
		

//		UserController userController = new UserController();
//		userController.findUserById();
//		System.out.println("first name");
//		String first_name = menu.next();
//		System.out.println("last name");
//		String last_name = menu.next();
//		System.out.println("email");
//		String email = menu.next();
//		System.out.println("phone");
//		phone = menu.next();
//		userController.AddUser(first_name, last_name, email, phone);
//		
//		userController.display();
//		int back=0;
//		
//	     int s = menu.nextInt();
//		
//		do {
//		System.out.println("1- User");
//		System.out.println("2- Admin");
//		switch (s){
//		case 1: System.out.println("user");
//		case 2: System.out.println("user");
//		}
//
//	}while (back == 1);

}
}
