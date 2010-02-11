package com.visitek.xyzproject.test;

import org.testng.annotations.Test;
import org.jboss.seam.mock.SeamTest;

public class AddressTest extends SeamTest {

	@Test
	public void test_addressList() throws Exception {
		
		System.out.println(TestUtil.listJNDITree("xyzproject.ear#xyzproject.jar"));
		new FacesRequest("/modules/address/list.xhtml") {
			@Override
			protected void updateModelValues() throws Exception {				
				//set form input to model attributes
				setValue("#{addressList.strcriteria}", "kuningan");
			}
			@Override
			protected void invokeApplication() {
				//call action methods here
				invokeMethod("#{addressList.resultList}");
			}
			@Override
			protected void renderResponse() {
				//check model attributes if needed
				assert getValue("#{addressList.strcriteria}").equals("kuningan");
			}
		}.run();
	}
}
