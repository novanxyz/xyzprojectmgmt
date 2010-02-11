package com.visitek.xyzproject.manager.seam;

import org.jboss.seam.annotations.Begin;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.annotations.web.RequestParameter;
import org.jboss.seam.framework.EntityHome;

import com.visitek.xyzproject.model.business.User;

@Name("userHome")
public class UserHome extends EntityHome<User>
{
    @RequestParameter Long userId;

    @Override
    public Object getId()
    {
        if (userId == null)
        {
            return super.getId();
        }
        else
        {
            return userId;
        }
    }

    @Override @Begin(join=true)
    public void create() {
        super.create();
    }
    @Override
	protected User createInstance() {
		User user = new User();
		return user;
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

	public User getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}


}
