package com.adobe.prj.dao.jdbc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.adobe.prj.dao.EmployeeDao;
import com.adobe.prj.entity.Employee;

public class EmployeeDaoJdbcImpl implements EmployeeDao {

	private static Connection con;
	static {
		try {
			con = DBUtil.getConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
<<<<<<< HEAD:src/main/java/com/adobe/prj/dao/EmployeeDaoJdbcImpl.java
	public void addEmployee(Employee e) {
		/*if(EmployeeDetails.total==0) {
			String SQL = "CREATE TABLE employees (id NUMERIC(10), first_name VARCHAR(20), last_name VARCHAR(20), email VARCHAR(50), p_id NUMERIC(10), is_pm BOOLEAN)";
			try {
				Statement stmt = con.createStatement();
				stmt.executeUpdate(SQL);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}*/
=======
	public void addEmployee() {
		
>>>>>>> a94ce1f9fd6bb6c58939aed6e1c68046eabb33ae:src/main/java/com/adobe/prj/dao/jdbc/EmployeeDaoJdbcImpl.java
		String first_name = "emp1"; // TODO read from console
		String last_name = "loyee2"; // TODO read from console
		String email = "emp@loyee.com"; // TODO read from console
		
		try {
			String SQL = "INSERT INTO employees (id, first_name, last_name, email, p_id, is_pm) VALUES (?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, e.getId());
			ps.setString(2, e.getName());
			ps.setString(3, e.getEmail());
			ps.setInt(4, e.getRole());
			ps.executeUpdate();
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> getExistingProjectManagers() {
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE is_pm=true";
		List<Employee> result = new ArrayList<Employee>();
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(SQL);
			
			
			while(rs.next()) {
				Employee e = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				e.setId(rs.getInt("id"));
				e.setP_id(rs.getInt("p_id"));
				e.setIs_pm(rs.getBoolean("is_pm"));
				result.add(e);
			}
		} catch (SQLException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		return result;
	}

	@Override
	public Employee getEmployee(int pm_id) {
		Employee emp = null;
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE id=?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, pm_id);
			ResultSet rs = ps.executeQuery();
			rs.next();
			emp = new Employee(rs.getString("name"),rs.getString("email"));
			emp.setId(rs.getInt("id"));
			emp.setIs_pm(rs.getBoolean("is_pm"));
			emp.setP_id(rs.getInt("p_id"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}

	@Override
	public List<Employee> getExistingEmployees() {
		List<Employee> emps = new ArrayList<Employee>();
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE is_pm=?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setBoolean(1, false);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Employee emp = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				emp.setId(rs.getInt("id"));
				emp.setIs_pm(rs.getBoolean("is_pm"));
				emp.setP_id(rs.getInt("p_id"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}

	@Override
	public List<Employee> getEmployeesOfProject(int id) {
		List<Employee> emps = new ArrayList<Employee>();
		String SQL = "SELECT id, first_name, last_name, email, p_id, is_pm FROM employees WHERE p_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Employee emp = new Employee(rs.getString("first_name"), rs.getString("last_name"), rs.getString("email"));
				emp.setId(rs.getInt("id"));
				emp.setIs_pm(rs.getBoolean("is_pm"));
				emp.setP_id(rs.getInt("p_id"));
				emps.add(emp);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emps;
	}
	
}
