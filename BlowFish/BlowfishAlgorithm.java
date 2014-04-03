package eccs2011;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

import com.sun.org.apache.xml.internal.security.exceptions.Base64DecodingException;
import com.sun.org.apache.xml.internal.security.utils.Base64;
  

public class BlowfishAlgorithm {  
  
    KeyGenerator keyGenerator = null;  
    SecretKey secretKey = null;  
    Cipher cipher = null;  
  
    public BlowfishAlgorithm() {  
        try {  
            /** 
             * Create a Blowfish key 
             */  
            keyGenerator = KeyGenerator.getInstance("Blowfish");  
            secretKey = keyGenerator.generateKey();  
  
            /** 
             * Create an instance of cipher mentioning the name of algorithm 
             *     - Blowfish 
             */  
            cipher = Cipher.getInstance("Blowfish");  
        } catch (NoSuchPaddingException ex) {  
            System.out.println(ex);  
        } catch (NoSuchAlgorithmException ex) {  
            System.out.println(ex);  
        }  
  
    }  
  
    /** 
     * 
     * @param plainText 
     * @return cipherBytes 
     */  
    public byte[] encryptText(String plainText) {  
        byte[] cipherBytes = null;  
        try {  
            /** 
             * Initialize the cipher for encryption 
             */  
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);  
            /** 
             * Convert the text string to byte format 
             */  
            byte[] plainBytes = plainText.getBytes();  
            /** 
             * Perform encryption with method doFinal() 
             */  
            cipherBytes = cipher.doFinal(plainBytes);  
        } catch (IllegalBlockSizeException ex) {  
            System.out.println(ex);  
        } catch (BadPaddingException ex) {  
            System.out.println(ex);  
        } catch (InvalidKeyException ex) {  
            System.out.println(ex);  
        }  
  
        return cipherBytes;  
    }  
  
    /** 
     * 
     * @param cipherBytes 
     * @return plainText 
     */  
    public String decryptText(byte[] cipherBytes) {  
        String plainText = null;  
        try {  
            /** 
             * Initialize the cipher for decryption 
             */  
            cipher.init(Cipher.DECRYPT_MODE, secretKey);  
            /** 
             * Perform decryption with method doFinal() 
             */  
            byte[] plainBytes = cipher.doFinal(cipherBytes);  
            /** 
             * Convert encrypted text to string format 
             */  
            plainText = new String(plainBytes);  
        } catch (IllegalBlockSizeException ex) {  
            System.out.println(ex);  
        } catch (BadPaddingException ex) {  
            System.out.println(ex);  
        } catch (InvalidKeyException ex) {  
            System.out.println(ex);  
        }  
  
        return plainText;  
    }  
  
    /** 
     * 
     * @param plainText 
     * @return cipherText 
     */  
    public String encrypt(String plainText) {  
        String cipherText = null;  
        byte[] cipherBytes = encryptText(plainText);  
        cipherText = bytesToString(cipherBytes);  
        return cipherText;  
    }  
  
    /** 
     *  
     * @param cipherText 
     * @return plainText 
     */  
    public String decrypt(String cipherText) {  
        String plainText = null;  
        byte[] cipherBytes = stringToBytes(cipherText);  
        plainText = decryptText(cipherBytes);  
        return plainText;  
    }  
  
    public static void main(String[] args) {  
        BlowfishAlgorithm blowfishAlgorithm = new BlowfishAlgorithm();  
        String textToEncrypt = "Blowfish Algorithm";  
        System.out.println("Text before Encryption: " + textToEncrypt);  
        String s = null;
        try {
			DataInputStream dis = new DataInputStream(new FileInputStream(new File("c:\\faces.jpg")));
			int av = dis.available();
			byte b[] = new byte[av];
			dis.read(b);
			dis.close();
			s = eccs2011.Base64.encode(b, 0, b.length);
			
			
		
        String cipherText = blowfishAlgorithm.encrypt(s);  
        System.out.println("Cipher Text: " + cipherText);  
        String comebak = blowfishAlgorithm.decrypt(cipherText);
        byte bb[] = eccs2011.Base64.decode(comebak);
        
        DataOutputStream out = new DataOutputStream(new FileOutputStream(new File("c:\\srikanth.jpg")));
        out.write(bb);
        out.close();
        
        } catch (Exception e) {
			e.printStackTrace();
		}
        
    }  
  
    /** 
     *  
     * @param rawText 
     * @return plainText 
     * 
     * Perform Base64 encoding 
     */  
    private String bytesToString(byte[] rawText) {  
        String plainText = null;  
        plainText = Base64.encode(rawText);  
        return plainText;  
    }  
  
    /** 
     *  
     * @param plainText 
     * @return rawText 
     * 
     * Perform Base64 decoding 
     */  
    private byte[] stringToBytes(String plainText) {  
        byte[] rawText = null;  
        try {  
            rawText = Base64.decode(plainText);  
        } catch (Base64DecodingException ex) {  
            System.out.println(ex);  
        }  
        return rawText;  
    }  
}  