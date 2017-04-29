/**
 *
 */
package com.philips.gxr.logi.security.jaas;

import java.io.Serializable;
import java.security.Principal;

/**
 * @author 310170171
 *
 */
public class UserRolePrincipal implements Principal, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 7182111506918002410L;



	private final String name;
	public UserRolePrincipal(String name) {
		this.name = name;
	}
	/* (non-Javadoc)
	 * @see java.security.Principal#getName()
	 */
	@Override
	public String getName() {
		System.out.println("UserRolePrincipal.getName...");
		return name;
	}

	@Override
	public boolean equals(Object obj) {
		boolean flag = false;
		if (obj instanceof UserRolePrincipal){
			flag = name.equals(((UserRolePrincipal) obj).getName());
		}
		return flag;
	}

}
