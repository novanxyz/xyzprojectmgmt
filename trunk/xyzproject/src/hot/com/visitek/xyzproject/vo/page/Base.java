package com.visitek.xyzproject.vo.page;

import net.sf.click.Page;

import org.apache.log4j.Logger;


public class Base extends Page{
	
	protected Logger log;
	
    public Logger getLogger() {
        if (log == null) {
            log = Logger.getLogger(getClass());
        }
        return log;
    }

}
