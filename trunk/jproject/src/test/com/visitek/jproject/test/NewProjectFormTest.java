package com.visitek.jproject.test;

import org.testng.annotations.Test;
import org.jboss.seam.mock.SeamTest;

public class NewProjectFormTest extends SeamTest {

	@Test
	public void test_newProjectForm() throws Exception {
		new FacesRequest("/newProjectForm.xhtml") {
			@Override
			protected void updateModelValues() throws Exception {				
				//set form input to model attributes
				setValue("#{newProjectForm.value}", "seam");
			}
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{newProjectForm.newProjectForm}");
			}
			@Override
			protected void renderResponse() {
				//check model attributes if needed
				assert getValue("#{newProjectForm.value}").equals("seam");
			}
		}.run();
	}
}
