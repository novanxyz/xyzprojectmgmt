package com.visitek.xyzproject.test;

import org.testng.annotations.Test;
import org.jboss.seam.mock.SeamTest;

public class UserTest extends SeamTest {

	@Test
	public void test_user() throws Exception {
		new FacesRequest("/user.xhtml") {
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{user.user}");
			}
		}.run();
	}
}
