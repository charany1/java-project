package com.adobe.prj.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.adobe.prj.entity.Employee;
import com.prj.adobe.util.ValidEmail;

/**
 * 
 * @author anurjain
 *
 */

public class EmployeeDetailsUI {
	
	public void getEmployeeDetails(){
		
	Scanner inputreader=new Scanner(System.in);
	String input=null;
	Employee e=new Employee();
	do{
    System.out.println("Enter the name of the employee");
	input=inputreader.nextLine();
	if(input==null||input.trim().equals("")){
		System.out.println("Please enter the name correctly");
		continue;
	}
	if(!input.trim().equals("")){
	e.setName(input);
	break;
	}
	}while(true);
	System.out.println("Employee name"+e.getName());
	
	
	
	ValidEmail v=new ValidEmail();
	String emailString=null;
	do{
	System.out.println("Enter the e-mail id of the employee");
	emailString=inputreader.nextLine();
	if(emailString==null||emailString.trim().equals("") ||(!v.isValidEmailAddress(emailString))){
		System.out.println("Please enter you email correctly");
		continue;
	}
	if(!emailString.trim().equals("")){
		if(v.isValidEmailAddress(emailString)){
	        e.setEmail(emailString);
	        break;
		}
	}
	}while(true);
	
	
	int num=0;
	while(true){//Check for string also
	System.out.println("Is this employee a staff member(enter 0) or project manager(enter 1)");
	try{
	num=inputreader.nextInt();
	if(!(num==1||num==0)){
		System.out.println("Please enter the designation correctly");
		//continue;
	}
	if((num==1||num==0)){
		if(num==1){
			e.setRole(1);
			break;
	     }else{
	    	 e.setRole(0);
	    	 break;
	     }
	}
	}catch(InputMismatchException excep){
		System.out.println("Please enter the designation correctly");
		inputreader.nextLine();
		continue;
	}
	
	//System.out.println("Number is:"+num);
	}
	//System.out.println("Hello World");
}
	public static void main(String[] args){
		EmployeeDetailsUI Emp=new EmployeeDetailsUI();
		Emp.getEmployeeDetails();
	}
}
