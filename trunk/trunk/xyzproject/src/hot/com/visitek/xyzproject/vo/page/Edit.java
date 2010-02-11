package com.visitek.xyzproject.vo.page;

import com.visitek.xyzproject.model.entity.Address;





public class Edit extends Base {
    public Form form ;
    public String msg;
    
	public Edit(){		
		
		Address  addr = new Address();
		form = new Form(addr.getClass());
				
	}
    
    
    

}
