package com.scispike.effectivejava.solution.ch03;

public class Rot13Encryption implements EncryptionStrategy {

	@Override
	public String encrypt(String clearText) {
	    StringBuilder sb = new StringBuilder(clearText.length());
	    char[] chars = clearText.toCharArray();
	    for (char c : chars) {
	        if (c >= 'a' && c <= 'm' || c >= 'A' && c <= 'M')
	            c += 13;
	        else if (c >= 'n' && c <= 'z' || c >= 'N' && c <= 'Z')
	            c -= 13;
	        sb.append(c);
	    }
	    return sb.toString();
	}

	public static void main(String[] args) {
		Rot13Encryption rot13 = new Rot13Encryption();
		String originalText = "Hello";
		String s = rot13.encrypt(originalText);
		System.out.printf("Original text: %s\n", originalText);
		System.out.printf("Encrypted text: %s\n", s);
		s = rot13.encrypt(s);
		System.out.printf("Decrypted text: %s\n", s);
	}
}
