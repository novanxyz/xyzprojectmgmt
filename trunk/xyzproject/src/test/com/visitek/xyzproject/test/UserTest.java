package com.visitek.xyzproject.test;

import org.jboss.seam.mock.SeamTest;
import org.testng.annotations.Test;

public class UserTest extends SeamTest {

	@Test
	public void test_user() throws Exception {
		new FacesRequest("/modules/user/user.xhtml") {
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{user.user}");
			}
		}.run();
	}
}
