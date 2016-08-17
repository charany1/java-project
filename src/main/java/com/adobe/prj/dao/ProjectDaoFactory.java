/**
 * 
 */
package com.adobe.prj.dao;

import com.adobe.prj.dao.jdbc.ProjectDaoJdbcImpl;

/**
 * @author rahujai
 *
 */

//TODO : Modify to make it use properties file , implement factory pattern
public class ProjectDaoFactory {
	public static ProjectDao getProjectDao() {
		return new ProjectDaoJdbcImpl();
	}
}
