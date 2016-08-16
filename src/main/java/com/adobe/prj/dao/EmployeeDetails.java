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
public class EmployeeDetails {
	public static int total;
	static{
		//TODO total = Database.totalEntries
		try {
			Connection con = DBUtil.getConnection();
			String SQL = "SELECT COUNT(id) FROM employees";
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			rs.next();
			System.out.println(rs.getInt(0) + " " + rs.getInt(1));
			total = rs.getInt(1);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			total = 0;
			try {
				Connection con = DBUtil.getConnection();
				String SQL = "CREATE TABLE employees (id NUMERIC(10), first_name VARCHAR(20), last_name VARCHAR(20), email VARCHAR(40), p_id NUMERIC(10), is_pm BOOLEAN)";
				Statement stmt = con.createStatement();
				stmt.executeUpdate(SQL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
