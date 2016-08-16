/**
 * 
 */
package com.adobe.prj.dao;

/**
 * @author rahujai
 *
 */
public class ProjectDaoFactory {
	public static ProjectDao getProjectDao() {
		return new ProjectDaoJdbcImpl();
	}
}
