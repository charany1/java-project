/**
 * 
 */
package com.adobe.prj.db.ddl;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import com.adobe.prj.dao.jdbc.DBUtil;

/**
 * @author danchara
 *	Class for initializing assignment table in database if it isn't already created . 
 *	Used in DbInit .
 *
 *	assignment table represents relationship between a project and employee([staff|manager])
 *	assigned to it .
 */
public class AssignmentDdl {
	public static void createAssignmentTable(){
		String createAssignmentTableSql = "CREATE TABLE assignment("+
										  "project_id INTEGER NOT NULL,"+
										  "employee_id INTEGER NOT NULL,"+
										  "CONSTRAINT FK1 FOREIGN KEY (project_id) REFERENCES project(id),"+
										  "CONSTRAINT FK2 FOREIGN KEY (employee_id) REFERENCES employee(id));";
		
		
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DBUtil.getConnection();
			statement = connection.createStatement();
			statement.executeQuery(createAssignmentTableSql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			DBUtil.releaseStatement(statement);
			DBUtil.releaseConnection(connection);
		}
		
	}

}
