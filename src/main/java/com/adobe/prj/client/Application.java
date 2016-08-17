/**
 * 
 */
package com.adobe.prj.client;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.dao.EmployeeDaoFactory;
import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.dao.ProjectDaoFactory;
import com.adobe.prj.entity.Employee;
import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 *
 * @version 1.0
 */
public class Application {

	/**
	 * @param args
	 */

	private static ProjectDao pd = ProjectDaoFactory.getProjectDao();
	private static EmployeeDao ed = EmployeeDaoFactory.getEmployeeDao();
	
	private static void addStaff() {
		List<Project> projects = pd.getAllProjects();
		System.out.println("Existing projects: ");
		projects.forEach(p -> System.out.println(p.getName()));
		
		List<Employee> emps = ed.getExistingEmployees();
		System.out.println("Existing employees: ");
		emps.forEach(p -> System.out.println(p.getFirst_name() + " " + p.getLast_name()));
		
		//TODO assign employees

	}
	
	private static void assignPm(){
		List<Project> projects = pd.getExistingProjects();
		System.out.println("Existing projects: ");
		projects.forEach(p -> System.out.println(p.getName()));
		
		List<Employee> pms = ed.getExistingProjectManagers();
		System.out.println("Existing project managers: ");
		pms.forEach(p -> System.out.println(p.getFirst_name() + " " + p.getLast_name()));

		if(projects.size() > pms.size()){
			System.out.println("Insufficient number of Project Managers");
			return;
		}
		Iterator<Project> ip = projects.iterator();
		Iterator<Employee> ie = pms.iterator();
		while(ip.hasNext()){
			ip.next().setPm_id(ie.next().getId());
		}
	}
	
	private static void output() {
		List<Project> projects = pd.getAllProjects();
		projects.forEach((p) -> {
			System.out.println("Project : " + p.getName());
			Employee pm = ed.getEmployee(p.getPm_id());
			System.out.println("Project Manager : " + pm.getFirst_name() + " " + pm.getLast_name()); //TODO Exception when no manager
			System.out.println("Staff :");
			List<Employee> emps = ed.getEmployeesOfProject(p.getId());
			int count = 0;
			Iterator<Employee> ie = emps.iterator();
			while(ie.hasNext()) {
				Employee emp = ie.next();
				System.out.println((++count) + ". " + emp.getFirst_name() + " " + emp.getLast_name());
			}
		});
	}
	
	public static void main(String[] args) {
		
		//Class.forName("ProjectDetails").getClassLoader().loadClass()
		int input;
		System.out.println("Project Management System");
		do{
			
			System.out.println("1.Add Project");
			System.out.println("2.Add Employee");
			System.out.println("3.Assign Project Manager");
			System.out.println("4.Add Employees[Staff]");
			System.out.println("5.Display Project Details");
			System.out.println("0.Quit");
			System.out.println("Enter your choice");
			Scanner in = new Scanner(System.in);
			input = in.nextInt();
			switch(input){
			case 1:pd.addProject();
			       System.out.println("Project has been added to the database");
			       break;
			case 2:ed.addEmployee();
			       System.out.println("Employee has been added to the database");
			       break;
			case 3:assignPm();
		           System.out.println("Project manager has been assigned to the project");
		           break;
		    case 4:addStaff();
	               System.out.println("Employees have been added to the project");
	               break;
		    case 5:output();
		           break;
		    case 0:for(int i=0;i<1000;i++){
		    	       System.out.println("\b");
		            }
		    	   System.exit(0);
		    	   break;
		    default:System.out.println("Invalid input");
		            break;
			}
			//System.out.print("\033[H\033[2J");

			/*for(int i=0;i<1000;i++){
	    	       System.out.println("\b");
	            }*/
		}while(true);
	}

}
