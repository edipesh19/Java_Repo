package com.scispike.effectivejava.solution.ch03;


public class InstrumentedRot13 implements EncryptionStrategy {
	private EncryptionStrategy encryptor;
	
	public InstrumentedRot13(EncryptionStrategy encryptor) {
		this.encryptor = encryptor;
	}
	
	@Override
	public String encrypt(String clearText) {
		long start = System.currentTimeMillis();
		String rslt = encryptor.encrypt(clearText);
		long end = System.currentTimeMillis();
		System.out.printf("It took %d milliseconds to encrypt\n", end - start);
		return rslt;
	}	
}
