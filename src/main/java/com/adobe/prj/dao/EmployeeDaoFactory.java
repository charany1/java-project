/**
 * 
 */
package com.adobe.prj.dao;

/**
 * @author rahujai
 *
 */
public class EmployeeDaoFactory {
	public static EmployeeDao getEmployeeDao() {
		return new EmployeeDaoJdbcImpl();
	}
}
