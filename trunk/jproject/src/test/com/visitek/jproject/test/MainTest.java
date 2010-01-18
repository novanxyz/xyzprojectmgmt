package com.visitek.jproject.test;

import javax.persistence.EntityManager;

import com.visitek.jproject.app.Constants;



public class MainTest {

    /**
     * @param args
     */
    public static void  main(String[] args) {
	
	System.out.println("");
	System.out.println("========================= START =============================");
	
	
	
	
	EntityManager em = Constants.em;
	
	System.out.println( " EM " + em.isOpen() );
	
	
	
	
	System.out.println("========================= END =============================");

    }

}
