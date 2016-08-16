/**
 * 
 */
package com.adobe.prj.entity;

import com.adobe.prj.annotations.Column;
import com.adobe.prj.annotations.Table;
import com.adobe.prj.dao.EmployeeDetails;

/**
 * @author rahujai
 *
 */

@Table(name="employees")
public class Employee {
	protected int id;
	protected String first_name;
	protected String last_name;
	protected String email;
	protected int p_id;
	protected boolean is_pm;
	/**
	 * @return the id
	 */
	
	@Column(name="id", type="NUMERIC(10)")
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
	 * @return the first_name
	 */

	@Column(name="first_name")
	public final String getFirst_name() {
		return first_name;
	}
	/**
	 * @param first_name the first_name to set
	 */
	public final void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	/**
	 * @return the last_name
	 */

	@Column(name="last_name")
	public final String getLast_name() {
		return last_name;
	}
	/**
	 * @param last_name the last_name to set
	 */
	public final void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	/**
	 * @return the email
	 */

	@Column(name="email")
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
	 * @return the p_id
	 */

	@Column(name="p_id", type="NUMERIC(10)")
	public final int getP_id() {
		return p_id;
	}
	/**
	 * @param p_id the p_id to set
	 */
	public final void setP_id(int p_id) {
		this.p_id = p_id;
	}
	/**
	 * @return the is_pm
	 */

	@Column(name="is_pm", type="BOOLEAN")
	public final boolean isIs_pm() {
		return is_pm;
	}
	/**
	 * @param is_pm the is_pm to set
	 */
	public final void setIs_pm(boolean is_pm) {
		this.is_pm = is_pm;
	}
	public Employee(String first_name, String last_name, String email) {
		this.first_name = first_name;
		this.last_name = last_name;
		this.email = email;
		this.id = EmployeeDetails.total + 1;
		this.p_id = -1;
		this.is_pm = false;
	}
	
}
