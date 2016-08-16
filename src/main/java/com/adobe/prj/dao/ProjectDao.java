/**
 * 
 */
package com.adobe.prj.dao;

import java.util.List;

import com.adobe.prj.entity.Project;

/**
 * @author rahujai
 *
 */
public interface ProjectDao {
	public void addProject();
	public List<Project> getExistingProjects();
	public List<Project> getAllProjects();
}
