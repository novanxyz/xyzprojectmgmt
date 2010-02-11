package com.visitek.xyzproject.app;

public class Configuration {
	public static Configuration inst;

	String appName;
	String version;
	String companyName;
	String projectName;

	static {
		inst = Constants.config;
	}

	public static Configuration getInstance() {
		return inst;
	}

	public Configuration() {

	}

	public String getAppName() {
		return appName;
	}

	public String getCompanyName() {
		return companyName;
	}

	public String getProjectName() {
		return projectName;
	}

	public String getVersion() {
		return version;
	}

	public void setAppName(String appName) {
		this.appName = appName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
