/**
 * 
 */
package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author rahujai
 *
 */

public class DBUtil {

	private static String URL = ConfigReader.getString("DB_URL"); //$NON-NLS-1$
	private static String USER = ConfigReader.getString("DB_USER"); //$NON-NLS-1$
	private static String PWD = ConfigReader.getString("DB_PWD"); //$NON-NLS-1$

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, USER, PWD);
	}
	

}


