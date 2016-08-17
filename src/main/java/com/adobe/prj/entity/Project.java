/**
 * 
 */
package com.adobe.prj.entity;

/**
 * @author rahujai
 * @author anurjain
 *
 */
public class Project {
	private int id;
	private String name;
	private boolean hasProjectManager;
	public Project() {
	}
	public Project(int id, String name, String client, boolean hasProjectManager) {
		this.id = id;
		this.name = name;
		this.hasProjectManager = hasProjectManager;
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
	 * @return the hasProjectManager
	 */
	public final boolean isHasProjectManager() {
		return hasProjectManager;
	}
	/**
	 * @param hasProjectManager the hasProjectManager to set
	 */
	public final void setHasProjectManager(boolean hasProjectManager) {
		this.hasProjectManager = hasProjectManager;
	}
	
	
}
