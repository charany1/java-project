/**
 * 
 */
package com.adobe.prj.db;

import com.adobe.prj.db.ddl.AssignmentDdl;
import com.adobe.prj.db.ddl.EmployeeDdl;
import com.adobe.prj.db.ddl.ProjectDdl;

/**
 * @author danchara
 *
 *
 *	Class for initializing database by creating employee, project and assignment tables if 
 *	they doesn't already exists.
 */
public class DbInit {
	
	
	/**
	 * Calls table creators , used in Application .
	 * */
	public static void initializeDatabase(){
		EmployeeDdl.createEmployeeTable();
		ProjectDdl.createProjectTable();
		AssignmentDdl.createAssignmentTable();
	}

}
