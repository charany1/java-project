/**
 * 
 */
package com.adobe.prj.client;

import java.util.Iterator;
import java.util.List;

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
public class ProjectAssigningApp {

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
		
		pd.addProject();
		
//		ed.addEmployee();
//		
//		assignPm();
//		
//		addStaff();
//		
//		output();
	}

}
