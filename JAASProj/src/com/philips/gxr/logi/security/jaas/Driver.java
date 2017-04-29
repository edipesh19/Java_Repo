package com.philips.gxr.logi.security.jaas;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.security.PrivilegedAction;

import javax.security.auth.Subject;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;

public class Driver {

	public enum Action {
		action1, action2, logout
	};

	public static void main(String[] args) {

		Driver driver = new Driver();
		System.setProperty("java.security.auth.login.config", "D:\\Dipesh\\jaasproj.config");
		// System.out.println(System.getProperties().getProperty("java.security.auth.login.config"));
		LoginContext loginContext = null;
		while (true) {
			try {
				loginContext = new LoginContext("MyJaasTutorial", new CbHandler());
				loginContext.login();

				boolean flag = true;
				while (flag) {
					flag = driver.performAction(loginContext);
				}
			} catch (LoginException e) {
			}
		}

	}

	boolean performAction(LoginContext loginContext) throws LoginException {

		boolean flag = false;
		System.out.println("Please specify the action to take (usage: action1, action2, logout)");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		try {
			switch (Action.valueOf(br.readLine())) {
			case logout:
				loginContext.logout();
				System.out.println("Logged out successfully...");
				flag = false;
				break;

			case action1:
				PrivilegedAction<Object> privilegedAcrion1 = () -> {
					System.out.println("action1 was performed ");
					return null;
				};
				Subject.doAs(loginContext.getSubject(), privilegedAcrion1);
				System.out.println("by " + loginContext.getSubject().getPrincipals().iterator().next().getName());
				flag = true;
				break;
			case action2:
				PrivilegedAction<Object> privilegedAcrion2 = () -> {
					System.out.println("action2 was performed ");
					return null;
				};
				Subject.doAs(loginContext.getSubject(), privilegedAcrion2);
				System.out.println("by " + loginContext.getSubject().getPrincipals().iterator().next().getName());
				flag = true;
				break;
			default:
				break;

			}
		} catch (IOException | IllegalArgumentException e) {
		}
		return flag;
	}

}
