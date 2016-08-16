/**
 * 
 */
package com.adobe.prj.entity;

/**
 * @author rahujai
 *
 */
public class ProjectManager extends Employee {

	public ProjectManager(String first_name, String last_name, String email) {
		super(first_name, last_name, email);
		this.is_pm = true;
	}

}
