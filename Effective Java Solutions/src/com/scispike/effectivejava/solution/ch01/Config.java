package com.scispike.effectivejava.solution.ch01;

public class Config {
	private String protocol;
	private String host;
	private String port;
	private String contextRoot;
	private boolean useCache;
	
	public static class Builder {
		private String protocol;
		private String host;
		private String port;
		private String contextRoot;
		private boolean useCache;
		
		public Builder(String contextRoot) {
			this.contextRoot = contextRoot;
			this.protocol = "http";
			this.host = "localhost";
			this.port = "80";
			this.useCache = false;
		}
		
		public Builder protocol(String s) {
			this.protocol = s;
			return this;
		}
		
		public Builder host(String s) {
			this.host = s;
			return this;
		}
		
		public Builder port(String s) {
			this.port = s;
			return this;
		}
		
		public Builder useCache(boolean b) {
			this.useCache = b;
			return this;
		}
		
		public Config build() {
			return new Config(this);
		}
	}
	
	private Config(Builder builder) {
		this.protocol = builder.protocol;
		this.host = builder.host;
		this.port = builder.port;
		this.contextRoot = builder.contextRoot;
		this.useCache = builder.useCache;
	}

	public String getProtocol() {
		return protocol;
	}

	public String getHost() {
		return host;
	}

	public String getPort() {
		return port;
	}

	public String getContextRoot() {
		return contextRoot;
	}

	public boolean isUseCache() {
		return useCache;
	}
	
	@Override
	public String toString() {
		return String.format("%s://%s:%s/%s/?useCache=%b", protocol, host, port, contextRoot, useCache);
	}
	
	public static void main(String[] args) {
		Config config = new Config.Builder("scispike").host("www.scispike.com").useCache(true).build();
		System.out.printf("URL for %s: %s\n", config.getHost(), config);
	}
}
