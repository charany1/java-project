/**
 * 
 */
package com.adobe.prj.entity;

/**
 * @author rahujai
 * @author anurjain
 *
 */

public class Employee {
	
	//Make all private as private
	
	private int id;
	private String name;//Make it name only
	private String email;
	private int role;//Replace
	public Employee() {
	}
	public Employee(int id, String name, String email, int role) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.role = role;
	}
	/**
	 * @return the id
	 */
	public final int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public final void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public final String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public final void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public final void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the role
	 */
	public final int getRole() {
		return role;
	}
	/**
	 * @param role the role to set
	 */
	public final void setRole(int role) {
		this.role = role;
	}
}
