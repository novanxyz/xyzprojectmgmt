package com.visitek.xyzproject.service;

import java.util.Date;

import com.visitek.xyzproject.model.business.Session;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.exception.InvalidLoginException;


public class UserSessionService extends BaseService<Session>{

	static Session session;

	public static User getCurrentUser(String sessId) {

		try {

			if ((sessId == null || sessId.length() == 0) && session != null)
				return session.getUser();

			Session session = (Session) getEntityManager().createNamedQuery("sessionById")
					.setParameter("session_id", sessId)
					.getSingleResult();
			return session.getUser();

		} catch (Exception e) {
			return null;
		}
	}

	public static Session login(String username, String password,
			String Ipaddress, String sessId) throws InvalidLoginException {
		

		User user = (User) getEntityManager().createNamedQuery("login")
				.setParameter("username", username)
				.setParameter("password", password)
				.getSingleResult();

		if (user == null)
			throw new InvalidLoginException();

		session = new Session();
		session.setUser(user);
		session.setLogIn(new Date());
		session.setRemoteAddr(Ipaddress);
		session.setName(sessId);
		getEntityManager().persist(session);
		return session;
	}

	
	public static boolean logout(Session sess) {
		
		sess.setLogOut(new Date());
		getEntityManager().persist(sess);
		session = null;
		return true;
	}

	public static boolean logout(User user, String sess_id)
			throws InvalidLoginException {

		Session s = (Session) getEntityManager().createNamedQuery("getUserSession")
				.setParameter("user_id", user.getId())
				.getSingleResult();
		if (s == null)
			throw new InvalidLoginException();
		return logout(s);
	}

	public static Session getCurrentUserSession(String username) {		
		User u = UserService.findByName(username,false);
		
		
		return null;
	}

	

}
