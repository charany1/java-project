/**
 * 
 */
package com.adobe.prj.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author rahujai
 *
 */
public class ProjectDetails {
	public static int total;
	static{
		//TODO total = Database.totalEntries
		try {
			Connection con = DBUtil.getConnection();
			String SQL = "SELECT COUNT(id) FROM projects";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();
			//System.out.println(rs.getInt(0) + " " + rs.getInt(1));
			total = rs.getInt(1);
			//System.out.println(total);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			total = 0;
			try {
				Connection con = DBUtil.getConnection();
				String SQL = "CREATE TABLE projects (id NUMERIC(10), name VARCHAR(20), pm_id NUMERIC(10))";
				Statement stmt = con.createStatement();
				stmt.executeUpdate(SQL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
