package com.App.YoucodeGotTalent;

//import java.security.Timestamp;
import java.sql.SQLException;
//import java.time.LocalTime;
//import java.util.Random;
import java.util.Scanner;

import com.controller.YoucodeGotTalent.AdminController;
import com.controller.YoucodeGotTalent.ParticipationController;
import com.controller.YoucodeGotTalent.UserController;
import com.models.YoucodeGotTalent.User;
//import com.youcodeGotTalent.method.Methods;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;  

public class App {

	public static void main(String[] args) throws SQLException {
//		AdminController adminController = new AdminController();
//		ParticipationController partie = new ParticipationController();
//		partie.addParticipation();
//		Scanner scan=new Scanner(System.in); 
//		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH");
//		System.out.println("Enter the start time of your show: (yyy-mmm-dd h:m:s)");
//		String startTime = scan.nextLine();
//		Date fechaNueva = format.parse(fechaStr);
//		Timestamp startTimestamp = Timestamp.valueOf(startTime);
//		System.out.println(startTimestamp);
		
//		   methode logout
//		adminController.logout();
//		   methode verify if admin connected or no
//		adminController.verifyConnection();
//		System.out.println(adminController.verifyConnection());
//		adminController.adminConnection();
//		Scanner menu = new Scanner(System.in);
//		System.out.println("phone");
//		String phone = menu.next();
		

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
		
		boolean back= true;
		boolean back1 = true;
		boolean back2 = true;
		boolean vBack = true;
		Scanner menu = new Scanner(System.in);
	    while (back) { 
	    	back1 = true;
	    	back2 = true;
		System.out.println("1- User");
		System.out.println("2- Admin");
		
		String input = menu.next();
		//menu.close();
		  
			 switch (Integer.parseInt(input)) {
			
		case 1 : do { 
				System.out.println("1- Add user");
			 System.out.println("2- Find user by Id");
			 System.out.println("3- Update user ");
			 System.out.println("4- participation ");
			 System.out.println("5- Back ");
			 int s2 = menu.nextInt();
			 UserController user = new UserController();
			 ParticipationController part = new ParticipationController();
			 	switch(s2) {  
			 	case 1 :
			 		System.out.println("your first name");
			 		 String first_name = menu.next();
			 		System.out.println("your last name");
			 		 String last_name = menu.next();
			 		System.out.println("your email ");
			 		 String email = menu.next();
			 		System.out.println("your phone Number ");
			 		 String phone = menu.next();
			 		user.AddUser(first_name, last_name, email, phone);
			 		break;
			 	case 2 :  System.out.println(user.findUserById().toString());
			 			 
			 			break;
			 	case 3 : 
			 		user.updateUser();
					 	break;
			 	case 4 : 
			 		part.addParticipation();
					 	break;
			 	case 5 : back2=false;
			 				break;
			 	default : System.out.println("choose from the menu below"); 
			 			break;
			 				
			 	}
		
		}while(back2);
		break;
		case 2 :
			AdminController admin = new AdminController();
			if (admin.verifyConnection()==true) {
			while (back1) { 
			    vBack = true;
				 System.out.println("1- Find all users");
				 System.out.println("2- find all participation");
				 System.out.println("3- find  participation by email");
				 System.out.println("4- log out ");
				 int s1 = menu.nextInt();
				 	switch(s1) {
				 	case 1 : 
				 		for(User list: admin.getAll()) {
						System.out.println(list.toString());
					}
				 		break;
				 	case 2 : System.out.println(" all participation");
				 		break;
				 	case 3 : System.out.println(" participation by email");
				 			 System.out.println(" you want to validate this participation ");
				 			 System.out.println(" 1- YES");
				 			 System.out.println(" 2- NO");
				 			 int v = menu.nextInt();
								while (vBack) {
										switch(v) {
										case 1 : System.out.println("  validated");
										vBack = false;
										break;
										case 2 : System.out.println("  did not valited");
										vBack = false;
										break;
										default : System.out.println("  error");
										 			}
										 } 
									break;
										case 4 : back1=false ;
										} 
		
		
	} 
			}else admin.adminConnection();
		break;
	default : System.out.println("choose from the betwen the numbers below ! ");	
}
			}

}
}
