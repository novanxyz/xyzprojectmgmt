package com.visitek.xyzproject.util.db;
import org.hibernate.cfg.NamingStrategy;

public class XYZNamingStrategy implements NamingStrategy {

	public String classToTableName(String arg0) {
		
		arg0 = arg0.toLowerCase();
		if (arg0.endsWith("s") 
			|| arg0.endsWith("sh") 
			|| arg0.endsWith("ch")
			|| arg0.endsWith("o")
			|| arg0.endsWith("z")) return arg0 + "es";
		if (arg0.endsWith("y")) return arg0.substring(0, arg0.length()-1) + "ies";
		return arg0 + 's';
		
	}
	
	public String tableToClassName(String tab){
		
		if (tab.endsWith("ies")) return tab.substring(0, tab.length()-3) + "y";
		return tab.substring(0,tab.length()-1);
	}


	public String collectionTableName(String arg0, String arg1, String arg2,
			String arg3, String arg4) {
		
		return arg0 + "_" + classToTableName(arg3) ;
				
	}

	public String columnName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String foreignKeyColumnName(String arg0, String arg1, String arg2,
			String arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public String joinKeyColumnName(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String logicalCollectionColumnName(String arg0, String arg1,
			String arg2) {
		// TODO Auto-generated method stub
		return null;
	}

	public String logicalCollectionTableName(String arg0, String arg1,
			String arg2, String arg3) {
		// TODO Auto-generated method stub
		return null;
	}

	public String logicalColumnName(String arg0, String arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public String propertyToColumnName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String tableName(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
