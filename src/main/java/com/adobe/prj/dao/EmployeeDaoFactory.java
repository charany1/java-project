/**
 * 
 */
package com.adobe.prj.dao;

import com.adobe.prj.dao.jdbc.EmployeeDaoJdbcImpl;

/**
 * @author rahujai
 *
 */

//TODO : Modify it to implement factory pattern using a properties file .
public class EmployeeDaoFactory {
	public static EmployeeDao getEmployeeDao() {
		return new EmployeeDaoJdbcImpl();
	}
}
