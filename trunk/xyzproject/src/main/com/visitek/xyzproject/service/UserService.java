package com.visitek.xyzproject.service;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import com.visitek.xyzproject.model.business.Role;
import com.visitek.xyzproject.model.business.User;
import com.visitek.xyzproject.service.exception.DuplicateUserNameException;
import com.visitek.xyzproject.service.exception.InvalidEmailException;
import com.visitek.xyzproject.service.exception.InvalidPasswordException;
import com.visitek.xyzproject.service.exception.NoSuchUserException;

public class UserService extends BaseService<User> {

	public void activateUser(User user) {
		user.setActive(true);
		getEntityManager().persist(user);
	}

	public void addUserRole(User user, Role role) {
		user.addRole(role);
		getEntityManager().persist(user);
	}

	public boolean authenticateUser(User user, String passwd) {

		try {

			User u = (User) getEntityManager().createNamedQuery("authenticate")
					.setParameter("user_id", user.getId()).setParameter(
							"passwd", passwd).getSingleResult();
			if (u.equals(user))
				return true;
		} catch (NonUniqueResultException e) {
			return true;
		} catch (Exception e) {
		}
		return false;

	}

	public void changePassword(User user, String oldpasswd, String newpasswd)
			throws InvalidPasswordException {

		if (authenticateUser(user, oldpasswd)) {
			user.setPassword(newpasswd);
			getEntityManager().persist(user);
		} else
			throw new InvalidPasswordException();

	}

	public Role createRole(String name) {

		Role role = (Role) getEntityManager().createNamedQuery("roleByName")
				.setParameter("name", "name").getSingleResult();
		if (role == null)
			role = new Role(name);
		getEntityManager().persist(role);
		return role;

	}

	public User createUser(String username, String password, String email)
			throws DuplicateUserNameException, InvalidEmailException {
		User u;
		try {
			u = getUserbyName(username);
			if (u != null)
				throw new DuplicateUserNameException();
		} catch (NoResultException ex) {

			u = new User(username);
			u.setEmail(email);
			u.setActive(false);
			u.setPassword(password);
			try {
				MessagingService.sendNewUserNotification(u);
				createUser(u);
			} catch (InvalidEmailException e) {
				u = null;
				throw new InvalidEmailException();
			}

		} catch (Exception e) {
			throw new DuplicateUserNameException();
		}

		return u;
	}

	public User createUser(User user) throws DuplicateUserNameException {

		try {
			User u = getUserbyName(user.getUsername());
			if (user != null)
				throw new DuplicateUserNameException();
		} catch (Exception e) {
			throw new DuplicateUserNameException();
		}

		persist(user);
		return user;
	}

	public void deleteUser(User user) {
		remove(user);
		user = null;
	}

	public User getUserbyId(int id) {
		return find(new Long(id));
	}

	public User getUserbyName(String name) {
		return findByName(name, false);
	}

	public void removeUserRole(User user, Role role) {
		user.removeRole(role);
		getEntityManager().persist(user);
	}

	public List<User> retrieveUser(String criteria) throws NoSuchUserException {

		try {
			List<User> ul = getEntityManager().createNamedQuery("userList")
					.setParameter("criteria", criteria)
					.getResultList();
			if (ul.isEmpty())
				throw new NoSuchUserException();
			return ul;
		} catch (Exception e) {
			throw new NoSuchUserException();
		}

	}

	public void updateUser(User user) {
		persist(user);
	}

}
