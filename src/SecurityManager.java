import java.util.Random;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class SecurityManager
{
    //abetka
    final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private String password;
    //for random generate password
    final Random random = new Random();

    public SecurityManager(String password)
    {
        this.password = password;
    }
    
    public SecurityManager()
    {
        this("qHFGKdLb0Kn23EEerCN4Kr57G4ET7C3S");
    }
    
    public void setNewPassword(String password)
    {
        this.password = password;
    }
    
    public String getCurrentPassword()
    {
        return password;
    }
    
    public String encrypt(String plainText) throws Exception
    {
        Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());

        return Base64.encodeBase64String(encryptedBytes);
    }

    public String decrypt(String encrypted) throws Exception
    {
        Cipher cipher = getCipher(Cipher.DECRYPT_MODE);
        byte[] plainBytes = cipher.doFinal(Base64.decodeBase64(encrypted));

        return new String(plainBytes);
    }

    private Cipher getCipher(int cipherMode)
            throws Exception
    {
        String encryptionAlgorithm = "AES";
        SecretKeySpec keySpecification = new SecretKeySpec(
                password.getBytes("UTF-8"), encryptionAlgorithm);
        Cipher cipher = Cipher.getInstance(encryptionAlgorithm);
        cipher.init(cipherMode, keySpecification);

        return cipher;
    }
    
    //generate random string with settigs length
    public String randomString(String chars, int length) {
        StringBuilder buf = new StringBuilder();
        for (int i = 0; i < length; i++) {
            buf.append(chars.charAt(random.nextInt(chars.length())));
        }
        return buf.toString();
    }
    
    public void initRandomKey128()
    {
        password = randomString(AB, 16);
    }
    
    public void initRandomKey192()
    {
        password = randomString(AB, 24);
    }
    
    public void initRandomKey256()
    {
        password = randomString(AB, 32);
    }
}