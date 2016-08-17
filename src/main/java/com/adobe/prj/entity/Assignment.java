package com.adobe.prj.entity;

/**
 * 
 * @author anurjain
 *
 */

public class Assignment {
	private int projectId;
	private int employeeId;
	public Assignment() {
	}
	public Assignment(int projectId, int employeeId) {
		this.projectId = projectId;
		this.employeeId = employeeId;
	}
	/**
	 * @return the projectId
	 */
	public final int getProjectId() {
		return projectId;
	}
	/**
	 * @param projectId the projectId to set
	 */
	public final void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	/**
	 * @return the employeeId
	 */
	public final int getEmployeeId() {
		return employeeId;
	}
	/**
	 * @param employeeId the employeeId to set
	 */
	public final void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	

}
