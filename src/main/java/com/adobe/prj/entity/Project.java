/**
 * 
 */
package com.adobe.prj.entity;

import com.adobe.prj.annotations.Column;
import com.adobe.prj.annotations.Table;
import com.adobe.prj.dao.ProjectDetails;

/**
 * @author rahujai
 *
 */
@Table(name="projects")
public class Project {
	private int id;
	private String name;
	private int pm_id;
	public Project(String name) {
		this.name = name;
		this.id = ProjectDetails.total + 1;
		this.pm_id = -1;
	}
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
	 * @return the name
	 */
	@Column(name="name")
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
	 * @return the pm_id
	 */
	@Column(name="pm_id", type="NUMERIC(10)")
	public final int getPm_id() {
		return pm_id;
	}
	/**
	 * @param pm_id the pm_id to set
	 */
	public final void setPm_id(int pm_id) {
		this.pm_id = pm_id;
	}
}
