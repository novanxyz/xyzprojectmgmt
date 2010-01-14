package com.visitek.jproject.manager.seam;

import org.jboss.seam.annotations.Create;
import org.jboss.seam.annotations.Destroy;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.Scope;
import org.jboss.seam.ScopeType;

import org.jboss.seam.annotations.Startup;

import com.visitek.jproject.app.Constants;

@Name("jprojectStartup")
@Scope(ScopeType.APPLICATION)
@Startup
public class StartUp {
	
	@Create
	public void create(){
		Constants.database.initialize(!Constants.testMode);
	}
	
	@Destroy
	public void destroy(){
		
		
	}
	

}
