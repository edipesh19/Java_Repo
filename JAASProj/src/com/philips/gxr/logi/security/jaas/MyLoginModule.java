package com.philips.gxr.logi.security.jaas;

import java.io.IOException;
import java.util.Map;

import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.NameCallback;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.callback.UnsupportedCallbackException;
import javax.security.auth.login.FailedLoginException;
import javax.security.auth.login.LoginException;
import javax.security.auth.spi.LoginModule;

public class MyLoginModule implements LoginModule {
	public static final String[][] TEST_USERS={{"testuser1", "password1"}, {"testuser2", "password2"}, {"testuser3", "password3"}};
	private Subject subject = null;
	private CallbackHandler callbackHandler = null;
	UserRolePrincipal principle = null;

	@Override
	public boolean abort() throws LoginException {
		System.out.println("MyLoginModule.abort...");
		if (subject != null && principle != null && subject.getPrincipals().contains(principle)){
			subject.getPrincipals().remove(principle);
		}
		subject = null;
		principle = null;
		return true;
	}

	@Override
	public boolean commit() throws LoginException {
		boolean flag = false;
		System.out.println("MyLoginModule.commit...");
		if (subject != null && !subject.getPrincipals().contains(principle)){
			subject.getPrincipals().add(principle);
			flag = true;
		}
		return flag;
	}

	@Override
	public void initialize(Subject subject, CallbackHandler callbackHandler, Map<String, ?> arg2, Map<String, ?> arg3) {
		System.out.println("MyLoginModule.initialize...");
		this.subject = subject;
		this.callbackHandler = callbackHandler;

	}

	@Override
	public boolean login() throws LoginException {
		boolean flag = false;
		System.out.println("MyLoginModule.login...");
		Callback[] callbackArray = new Callback[2];
		callbackArray[0] = new NameCallback("User name:");
		callbackArray[1] = new PasswordCallback("Password:", false);
		try {
			callbackHandler.handle(callbackArray);
			String name = ((NameCallback)callbackArray[0]).getName();
			String password = new String (((PasswordCallback)callbackArray[1]).getPassword());
			for(int i = 0; i < TEST_USERS.length; i++){
				if (TEST_USERS[i][0].equals(name) && TEST_USERS[i][1].equals(password)){
					principle = new UserRolePrincipal(name);
					System.out.println("authentication success...");
					flag = true;
					break;
				}
			}
			if (!flag){
				throw new FailedLoginException("authentication failure...");
			}
		} catch (IOException | UnsupportedCallbackException e) {
			e.printStackTrace();
		}
		return flag;
	}

	@Override
	public boolean logout() throws LoginException {
		System.out.println("MyLoginModule.logout...");
		subject.getPrincipals().remove(principle);
		subject = null;
		return true;
	}

}
