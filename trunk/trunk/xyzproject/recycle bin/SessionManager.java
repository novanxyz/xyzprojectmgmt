package com.visitek.xyzproject.manager.seam;

import javax.ejb.Local;
import javax.ejb.Stateless;

import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Logger;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.log.Log;
import org.jboss.seam.security.Credentials;
import org.jboss.seam.security.Identity;

import com.visitek.xyzproject.service.UserSessionService;
import com.visitek.xyzproject.service.exception.InvalidLoginException;

@Local 
@Stateless
@Name("sessionMgr")
public class SessionManager {
	@Logger
	private Log log;

	@In
	Identity identity;
	@In
	Credentials credentials;
	@In
	String remoteAddr;
	@In
	String sessionId;

	
	public boolean login(){
		log.info("authenticating {0} from ${1}", credentials.getUsername(), remoteAddr);
		
		try {
			UserSessionService.login(credentials.getUsername(), credentials.getPassword(), remoteAddr, sessionId);
			return true;
		} catch (InvalidLoginException ex) {

		}
		return true;
	}
}
