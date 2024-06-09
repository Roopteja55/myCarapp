package com.edubridge.mini_project_myCarapp.main;

import java.util.List;
import java.util.Scanner;

import com.edubridge.mini_project_myCarapp.model.car;
import com.edubridge.mini_project_myCarapp.service.carService;
import com.edubridge.mini_project_myCarapp.service.carServiceImpl;

public class carMainApp {

public static void main(String[] args) {
		
		 carService service = new carServiceImpl();
		
		  car c= null;
		
		Scanner in = new Scanner(System.in);
		int option;
		do {
			System.out.println("  ");
			System.out.println("***WELCOME TO CAR APP***");
			System.out.println("*************************");
			System.out.println("==> 1. Add Car Record");
			System.out.println("==> 2. View All Cars");
			System.out.println("==> 3. search by name Car");
			System.out.println("==> 4. update  Car");
			System.out.println("==> 5. Delete one Car");
			System.out.println("==> 6. Delete all cars");
			System.out.println("==> 0. Exit");
			System.out.println("****PLEASE CHOOSE THE CORRECT OPTION****");
			option = in.nextInt();
			switch(option) {
			case 1:
				System.out.println("ADD NEW CAR");
				System.out.println("----------------");
				System.out.println("Please Enter Car CompanyName");
				String companyname=in.next();
				System.out.println("Please Enter Car Price");
				double price = in.nextDouble();
				System.out.println("Please Enter Car Colour");
				String colour=in.next();
				System.out.println("Please Enter Car Mileage");
				int mileage=in.nextInt();
				c = new car();
				c.setCompanyname(companyname);
				c.setPrice(price);
				c.setColour(colour);
				c.setMileage(mileage);
				
				int status = service.addcar(c);
				if(status==1) {
					System.out.println("New Car Added!");
				}else {
					System.out.println("Something Is Wrong");
				}
				
				
				break;
			case 2:
				
				List<car> cars= service.findcars();
				System.out.println("View Cars");
				for(car car:cars) {
					System.out.println("Gift ID               : "+car.getId());
					System.out.println("Gift Companyname      : "+car.getCompanyname());
					System.out.println("Gift Price            : "+car.getPrice());
					System.out.println("Gift Colour           : "+car.getColour());
					System.out.println("Gift Mileage          : "+car.getMileage());
				}
				break;
			case 3:
				System.out.println("Enter the car Name: ");
				companyname = in.next();
				c = service.findcarByName(companyname);
				if(c != null) {
					System.out.println("Id: "+c.getId());
					System.out.println("Name: "+c.getCompanyname());
					System.out.println("price: "+c.getPrice());
					System.out.println("Colour: "+c.getColour());
					System.out.println("Mileage: "+c.getMileage());
				}else {
					System.out.println("No contact found!!!");
				}
				
				break;
			case 4:
				System.out.println("Update Car");
				System.out.println("---------------");
				System.out.println("Search Car BY Name");
				System.out.println("Please Enter Car Name");
				companyname =in.next();
				
				c = service.findcarByName(companyname);
				 
				if (c != null) {
			        System.out.println("Car Found:");
			        System.out.println("Car ID       : "+c.getId());
					System.out.println("Car Name     : "+c.getCompanyname());
					System.out.println("Car Price    : "+c.getPrice());
					System.out.println("Car Colour : "+c.getColour());
					System.out.println("Car Mileage   : "+c.getMileage());
			     
				System.out.println("Please Enter Updating car Name");
				companyname=in.next();
				System.out.println("Please Enter Updating car price");
				price=in.nextDouble();
				System.out.println("Please Enter Updating car colour");
				colour=in.next();
				System.out.println("Please Enter Updating car mileage");
				mileage=in.nextInt();
				System.out.println(" Enter Existed Id");
				int id = in.nextInt();
				
				c=new car();
				c.setCompanyname(companyname);
				c.setColour(colour);
				c.setPrice(price);
				c.setMileage(mileage);
				c.setId(id);
				
				status =service.updatecar(c);
				if(status==1) {
					System.out.println("Updated Succesfully");
				}else {
					System.out.println("SomeThing is Wrong Added");
				}
				}else {
					System.out.println("No Car Found With Name");
				}
				
				break;
			case 5:
				System.out.println("Delete Car");
				System.out.println("Please Enter Car CompanyName");
				companyname=in.next();
				status=service.deletecarByName(companyname);
				if(status == 1) {
					System.out.println("DELETED CAR");
				}else {
					System.out.println("Something  Wrong");
				}
				
				break;
			case 6:
				//System.out.println("Delete All Contact");
				System.out.println("Are Uh Sure delete all Cars[Y/N]");
				String deleteConformStatus=in.next();
				
				if(deleteConformStatus.equalsIgnoreCase("Y")) {
				   service.deleteAllcars();
				   System.out.println("All Cars are Deleted");
				}
				
				
				break;
			case 0:
				System.exit(0);
				break;
				default:
					System.out.println("Invalid Option");
					break;
			
			}
			
		}while(option!=0);
	}

}