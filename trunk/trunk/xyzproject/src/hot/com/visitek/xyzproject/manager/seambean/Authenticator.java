package com.visitek.xyzproject.manager.seambean;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
