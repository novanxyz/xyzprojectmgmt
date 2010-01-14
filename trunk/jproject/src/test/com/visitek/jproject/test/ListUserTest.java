package com.visitek.jproject.test;

import org.testng.annotations.Test;
import org.jboss.seam.mock.SeamTest;

public class ListUserTest extends SeamTest {

	@Test
	public void test_listUser() throws Exception {
		new FacesRequest("/listUser.xhtml") {
			@Override
			protected void updateModelValues() throws Exception {				
				//set form input to model attributes
				setValue("#{listUser.value}", "seam");
			}
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{listUser.listUser}");
			}
			@Override
			protected void renderResponse() {
				//check model attributes if needed
				assert getValue("#{listUser.value}").equals("seam");
			}
		}.run();
	}
}
