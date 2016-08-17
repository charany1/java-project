/**
 * 
 */
package com.adobe.prj.dao.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.adobe.prj.dao.ProjectDao;
import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 *
 */
public class ProjectDaoJdbcImpl implements ProjectDao {
	
	private static Connection con;
	static {
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void addProject() {
		String name = "project1"; // TODO read from console
		Project p = new Project(name);
		System.out.println("Enter the name of the project");
		Scanner inputreader=new Scanner(System.in);
		String input=null;
		input=inputreader.nextLine();
		p.setName(input);
		/*if(ProjectDetails.total==0) {
			String SQL = "CREATE TABLE projects (id NUMERIC(10), name VARCHAR(20), pm_id NUMERIC(10))";
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(SQL);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}*/
		try {
			//String SQL = DBUtil.insertStatement("projects" , new String[]{"id","name","pm_id"});
			String SQL = "INSERT INTO projects (id, name, pm_id) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, p.getId());
			ps.setString(2, p.getName());
			ps.setInt(3, p.getPm_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Project> getExistingProjects() {
		String SQL = "SELECT name,id,pm_id FROM projects WHERE pm_id=-1";
		List<Project> result = new ArrayList<Project>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Project p = new Project(rs.getString("name"));
				p.setId(rs.getInt("id"));
				p.setPm_id(rs.getInt("pm_id"));
				result.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public List<Project> getAllProjects() {
		String SQL = "SELECT name,id,pm_id FROM projects";
		List<Project> result = new ArrayList<Project>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			while(rs.next()) {
				Project p = new Project(rs.getString("name"));
				p.setId(rs.getInt("id"));
				p.setPm_id(rs.getInt("pm_id"));
				result.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
