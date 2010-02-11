package com.visitek.xyzproject.manager.seam;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.visitek.xyzproject.model.entity.Address;

@Name("addressHome")
public class AddressHome extends EntityHome<Address>{
    @RequestParameter 
    private Long addrId;

    @Override
    public Object getId()
    {
        if (addrId == null)
        {
            return super.getId();
        }
        else
        {
            return addrId;
        }
    }

    @Override @Begin(join=true)
    public void create() {
        super.create();
    }
    @Override
	protected Address createInstance() {
    	Address addr = new Address();
		return addr;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Address getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public Long getAddrId() {
		return addrId;
	}

	public void setAddrId(Long addrId) {
		this.addrId = addrId;
	}


}
