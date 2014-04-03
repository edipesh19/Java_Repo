package com.scispike.effectivejava.solution.ch08;

public class ConfigNotAvailableException extends Exception {
	private static final long serialVersionUID = 84229926660759380L;

	private String configName;
	
	public ConfigNotAvailableException(String configName, Throwable cause) {
		super(cause);
		this.configName = configName;
	}
	
	public String getMessage() {
		return String.format("Configuration %s not available", this.configName);
	}
}
