package com.visitek.jproject.test;

import com.visitek.jproject.model.business.User;
import com.visitek.jproject.service.UserService;


public class MainTest {

    /**
     * @param args
     */
    public static void  main(String[] args) {
	
	System.out.println("");
	System.out.println("========================= START =============================");
	/*
	Set<AuditTrail> test = new HashSet<AuditTrail>();
	
	
	AuditTrail audit= new AuditTrail();
	
	for (int i = 0; i< 10; i++){
	    audit = new AuditTrail();
	   audit.setModuleId(Long.valueOf(i));
	   test.add(audit);   
	}
	
	System.out.println(test.size());
	Iterator<AuditTrail> it =test.iterator(); 
	while ( it.hasNext() ){
	    System.out.println(it.next());	    
	}
	*/
	User user = null;
	user = UserService.getUserbyId(10);
	
	System.out.println(user.toString());
	
	System.out.println("========================= END =============================");

    }

}
