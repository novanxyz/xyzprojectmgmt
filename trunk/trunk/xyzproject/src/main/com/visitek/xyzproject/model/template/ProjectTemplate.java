package com.visitek.xyzproject.model.template;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.model.entity.Project;

public class ProjectTemplate extends Project {
	private static final long serialVersionUID = 1L;

	static {
		Constants.em.find(ProjectTemplate.class, 1L);

	}

	public Project newProject() {
		return this;
	}
}
