package com.adobe.prj.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.adobe.prj.dao.ProjectDetails;
import com.adobe.prj.entity.Project;

/**
 * 
 * @author anurjain
 *
 */

public class ProjectDetailsUI {
	
	public void getProjectDetails(){
		
		Project p =new Project();
		Scanner inputreader=new Scanner(System.in);
		String input=null;
		do{
			
		System.out.println("Enter the name of the project");
		input=inputreader.nextLine();
		if(input==null||input.trim().equals("")){
			System.out.println("Please enter the name correctly");
			continue;
		}
		if(!input.trim().equals("")){
		p.setName(input);
		break;
		}
		}while(true);
		int num=0;
		while(true){//Check for string also
			System.out.println("Does the project has a project manager(0 for no,1 for yes)");
			try{
			num=inputreader.nextInt();
			if(!(num==1||num==0)){
				System.out.println("Please enter the choice correctly");
				//continue;
			}
			if((num==1||num==0)){
				if(num==1){
					p.setHasProjectManager(true);
					break;
			     }else{
			    	 p.setHasProjectManager(false);;
			    	 break;
			     }
			}
			}catch(InputMismatchException excep){
				System.out.println("Please enter the choice correctly");
				inputreader.nextLine();
				continue;
			}
			//System.out.println("Number is:"+num);
			}
	}
	public static void main(String[] args){
		ProjectDetailsUI Emp=new ProjectDetailsUI();
		Emp.getProjectDetails();
	}
}
