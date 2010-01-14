package com.visitek.jproject.test;

import org.testng.annotations.Test;
import org.jboss.seam.mock.SeamTest;

public class UserTest extends SeamTest {

	@Test
	public void test_user() throws Exception {
		new FacesRequest("/user.xhtml") {
			@Override
			protected void updateModelValues() throws Exception {				
				//set form input to model attributes
				setValue("#{User.value}", "seam");
			}
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{User.user}");
			}
			@Override
			protected void renderResponse() {
				//check model attributes if needed
				assert getValue("#{User.value}").equals("seam");
			}
		}.run();
	}
}
