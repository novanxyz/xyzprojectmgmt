package com.visitek.xyzproject.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.model.business.AccessControlList;
import com.visitek.xyzproject.model.business.Role;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.UserSessionService;

public class Permission {

	private static Map<String, Integer> propertyAcl;

	static User actor;
	static {

		propertyAcl = Constants.defaultPropertyPermission;

		List<AccessControlList> perms = new ArrayList<AccessControlList>();

		User user = UserSessionService.getCurrentUser(null);

		if (!user.equals(null))
			try {
				perms = Constants.em.createNamedQuery("getUserPermission")
						.setParameter("user_id", user.getId()).getResultList();
				actor = user;
				Set<Role> group = user.getRoles();
				Iterator it = group.iterator();

				while (it.hasNext()) {
					Role r = (Role) it.next();
					perms.addAll(Constants.em.createNamedQuery(
							"getRolePermission").setParameter("role_id",
							r.getId()).setParameter("user_id", user.getId())
							.getResultList());
				}
			} catch (Exception e) {
			}

		Iterator<AccessControlList> it = perms.iterator();

		while (it.hasNext()) {
			AccessControlList acl = it.next();
			propertyAcl.put(acl.getObjectId(), acl.getObjectAcl());
		}

	}

	public Permission(User user) {

		propertyAcl = new HashMap<String, Integer>();

		if (!user.equals(null))
			try {
				List<AccessControlList> perms = new ArrayList<AccessControlList>();
				Set<Role> group = user.getRoles();

				Iterator it = group.iterator();

				while (it.hasNext()) {
					Role r = (Role) it.next();
					perms.addAll(Constants.em.createNamedQuery(
							"getRolePermission").setParameter("role_id",
							r.getId()).setParameter("user_id", user.getId())
							.getResultList());
				}

				perms.addAll(Constants.em.createNamedQuery("getUserPermission")
						.setParameter("user_id", user.getId()).getResultList());
				actor = user;

				Iterator<AccessControlList> itr = perms.iterator();

				while (itr.hasNext()) {
					AccessControlList acl = itr.next();
					propertyAcl.put(acl.getObjectId(), acl.getObjectAcl());
				}
			} catch (Exception e) {
			}
	}

	public void addRolePermission(Role role, String module, String property,
			String oid, int newacl) {

		// check exist ?
		oid = oid == null || oid.length() > 0 ? "" : "#" + oid;
		property = oid == null || property.length() > 0 ? "" : "." + property;

		List<AccessControlList> perms = Constants.em.createNamedQuery(
				"getRolePermission").setParameter("role_id", role.getId())
				.setParameter("user_id", null).getResultList();

		Iterator<AccessControlList> Itacls = perms.iterator();

		while (Itacls.hasNext()) {
			AccessControlList acl = Itacls.next();
			if (acl.getObjectId().equals(module + property + oid)) {
				// ?????

				acl.setObjectAcl((newacl + acl.getObjectAcl()) % 16);
				Constants.em.persist(acl);
			}
		}
	}

	public void addUserPermission(User user, String module, String oid,
			String property, int newacl) {

		// check exist ?

		if ((user.equals(actor) || user.equals(null))
				&& propertyAcl.containsKey(module + property + oid))
			newacl = Math.abs(propertyAcl.get(property) - newacl);

		try {
			AccessControlList acl;
			oid = oid == null || oid.length() > 0 ? "" : "#" + oid;
			property = oid == null || property.length() > 0 ? "" : "."
					+ property;

			try {

				acl = (AccessControlList) Constants.em.createNamedQuery(
						"getPermissionUser").setParameter("user_id",
						user != null ? user.getId() : null).setParameter("obj",
						module + property + oid).getSingleResult();

				acl.setObjectAcl(acl.getObjectAcl() + newacl);

			} catch (Exception noex) {

				acl = new AccessControlList();
				acl.setUser(null);
				acl.setObjectId(module + property + oid);
				acl.setObjectAcl(newacl);
			}

			Constants.em.persist(acl);
			propertyAcl.put(acl.getObjectId(), acl.getObjectAcl());

		} catch (Exception ex) {

		}

	}

	public void addUserRolePermission(Role role, User user, String module,
			String property, String oid, int newacl) {

		// check exist ?
		oid = oid == null || oid.length() > 0 ? "" : "#" + oid;
		property = oid == null || property.length() > 0 ? "" : "." + property;

		List<AccessControlList> perms = Constants.em.createNamedQuery(
				"getRolePermission").setParameter("role_id", role.getId())
				.setParameter("user_id", user.getId()).getResultList();

		Iterator<AccessControlList> Itacls = perms.iterator();

		while (Itacls.hasNext()) {
			AccessControlList acl = Itacls.next();
			if (acl.getObjectId().equals(module + property + oid)) {
				// ?????
				acl.setObjectAcl((newacl + acl.getObjectAcl()) % 16);

				Constants.em.persist(acl);
			}
		}
	}

	public boolean checkAdd(String module, String oid, String property) {
		oid = oid == null || oid.length() == 0 ? "" : "#" + oid;
		property = property == null || property.length() == 0 ? "" : "."
				+ property;

		if (propertyAcl.containsKey(module + property + oid))
			return propertyAcl.get(property)
					% AccessControlList.ACL_PERMISSION_ADD > 0;
		return Constants.defaultAddPermission;// actually unreacable code;
	}

	public boolean checkDelete(String module, String oid, String property) {
		oid = oid == null || oid.length() == 0 ? "" : "#" + oid;
		property = property == null || property.length() == 0 ? "" : "."
				+ property;

		if (propertyAcl.containsKey(module + property + oid))
			return propertyAcl.get(property)
					% AccessControlList.ACL_PERMISSION_DELETE > 0;
		return Constants.defaultDeletePermission; // actually unreacable code;
	}

	public boolean checkEdit(String module, String oid, String property) {
		oid = oid == null || oid.length() == 0 ? "" : "#" + oid;
		property = property == null || property.length() == 0 ? "" : "."
				+ property;

		if (propertyAcl.containsKey(module + property + oid))
			return propertyAcl.get(property)
					% AccessControlList.ACL_PERMISSION_EDIT > 0;
		return Constants.defaultEditPermission; // actually unreacable code;
	}

	public boolean checkView(String module, String oid, String property) {
		oid = oid == null || oid.length() == 0 ? "" : "#" + oid;
		property = property == null || property.length() == 0 ? "" : "."
				+ property;

		if (propertyAcl.containsKey(module + property + oid))
			return propertyAcl.get(property)
					% AccessControlList.ACL_PERMISSION_VIEW > 0;
		return Constants.defaultViewPermission;
	}

	public void deleteRolePermission(Role role, String module, String property,
			String oid) {

		oid = oid == null || oid.length() > 0 ? "" : "#" + oid;
		property = oid == null || property.length() > 0 ? "" : "." + property;
		try {
			AccessControlList acl = (AccessControlList) Constants.em
					.createNamedQuery("getPermissionRole").setParameter(
							"role_id", role.getId()).setParameter("obj",
							module + property + oid).getSingleResult();

			Constants.em.remove(acl);
		} catch (Exception e) {
		}
	}

	public void deleteUserPermission(User user, String module, String property,
			String oid) {
		oid = oid == null || oid.length() > 0 ? "" : "#" + oid;
		property = oid == null || property.length() > 0 ? "" : "." + property;

		try {
			AccessControlList acl = (AccessControlList) Constants.em
					.createNamedQuery("getPermissionUser").setParameter(
							"user_id", user.getId()).setParameter("obj",
							module + property + oid).getSingleResult();
			Constants.em.remove(acl);
		} catch (Exception e) {
		}

	}

	public int strToPermission(String aclstr) {
		int p = 0;
		if (aclstr.indexOf("v") >= 0)
			p += AccessControlList.ACL_PERMISSION_VIEW;
		if (aclstr.indexOf("e") >= 0)
			p += AccessControlList.ACL_PERMISSION_EDIT;
		if (aclstr.indexOf("a") >= 0)
			p += AccessControlList.ACL_PERMISSION_ADD;
		if (aclstr.indexOf("d") >= 0)
			p += AccessControlList.ACL_PERMISSION_DELETE;
		return p;
	}

}
