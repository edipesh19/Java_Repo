package com.scispike.effectivejava.solution.ch03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SecureFileReader {

	public void readAndEncrypt(String filename, EncryptionStrategy encryptor) throws IOException {	
		BufferedReader infile = new BufferedReader(new FileReader(filename));
		String originalText = null;
		while((originalText = infile.readLine()) != null) {
			String encryptedText = encryptor.encrypt(originalText);
			System.out.printf("Original text: %s\n", originalText);
			System.out.printf("Encrypted text: %s\n", encryptedText);
			String decryptedText = encryptor.encrypt(encryptedText);
			System.out.printf("Decrypted text: %s\n", decryptedText);
		}
	}
	
	public static void main(String[] args) {
		EncryptionStrategy encryptor = new Rot13Encryption();
		SecureFileReader reader = new SecureFileReader();
		try {
			reader.readAndEncrypt("c:\\input.txt", encryptor);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}
	// Uncomment for testing InstrumentedRot13 lab
	/*public static void main(String[] args) {
		EncryptionStrategy encryptor = new Rot13Encryption();
		EncryptionStrategy instrumentedEncryptor = new InstrumentedRot13(encryptor);
		SecureFileReader reader = new SecureFileReader();
		try {
			reader.readAndEncrypt("c:\\input.txt", instrumentedEncryptor);
		}
		catch (IOException e) {
			System.out.println(e);
		}
	}*/

}
