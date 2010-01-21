package com.visitek.xyzproject.util;

import java.util.Collection;
import java.util.List;

import com.visitek.xyzproject.app.Constants;

public class KeyValueUtil {

	public static String getKeyValue(String classname,String field, int key){
		
		String query = 	"select value " +
					 	" from keyvalues " +
						" where classname ='"+classname+"' " + " and fieldname= '"+field+"' and key = " + key;
		
		List rs =   Constants.database.query(query);		
		if (rs.size()!=0) return (String)rs.get(0);		
		return null;
		
	}
	public Collection<String>  getKeyValue(String classname,String field){

		String query = 	"select value " +
	 	" from keyvalues " +
		" where classname ='"+classname+"' " + " and fieldname= '"+field+"'";
		
		List<String> resultList = Constants.em.createNamedQuery(query).getResultList();
		return resultList;
	}
}
