package com.visitek.xyzproject.manager.seam;

import javax.ejb.Local;

@Local
public interface Authenticator {

	boolean authenticate();

}
