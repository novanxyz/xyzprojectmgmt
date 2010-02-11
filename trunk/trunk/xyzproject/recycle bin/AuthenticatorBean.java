package com.visitek.xyzproject.manager.seam;

import javax.ejb.Stateless;

import org.apache.log4j.Logger;
import org.jboss.seam.annotations.In;

import org.jboss.seam.annotations.Name;

import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.visitek.xyzproject.app.Constants;
import com.visitek.xyzproject.service.UserSessionService;
import com.visitek.xyzproject.service.exception.InvalidLoginException;

@Stateless
@Name("authenticator")
public class AuthenticatorBean implements Authenticator {
	
	private Logger log = Constants.logger;

	@In
	Identity identity;
	@In
	Credentials credentials;
	@In
	String remoteAddr;
	@In
	String sessionId;

	public boolean authenticate() {
		log.info("authenticating {0}");
		// write your authentication logic here,
		// return true if the authentication was
		// successful, false otherwise
		if ("admin".equals(credentials.getUsername())) {
						
			try {
				UserSessionService.login(credentials.getUsername(), credentials.getPassword(), remoteAddr, sessionId);
				return true;
			} catch (InvalidLoginException ex) {

			}
			
		}
		return false;
	}

}
