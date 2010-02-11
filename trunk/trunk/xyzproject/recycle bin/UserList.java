package com.visitek.xyzproject.manager.seam;

import java.util.Arrays;

import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

import com.visitek.xyzproject.model.business.User;

@Name("userList")
public class UserList extends EntityQuery<User>{
	
	private static final String EJBQL = "select * from User user";

	private static final String[] RESTRICTIONS = {
			"lower(user.username) like lower(concat(#{userList.criteria},'%'))",
			"lower(user.realname) like lower(concat(#{userList.criteria},'%'))" };

	private User user = new User();
	private String criteria = "";
	

	public UserList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}
	
    
}
