public class ThomasWalkerRun {

    public static void main(String[] args) throws Exception{
        String password = "JHW1KxLG5JnW6mE89JNFK4W764Eg7ChS";
        String plainText = "Hello AES!";
        System.out.println("PlainText: " + plainText);
        
        SecurityManager sm1 = new SecurityManager(password);
        String cipherText = sm1.encrypt(plainText);
        System.out.println("sm1.Password length: " + sm1.getCurrentPassword().length()*8 + " bit");
        System.out.println("sm1.Crypt: " + cipherText);
        System.out.println("sm1.Decrypt: " + sm1.decrypt(cipherText));
        
        SecurityManager sm2 = new SecurityManager();
        cipherText = sm2.encrypt(plainText);
        System.out.println("sm2.Password length: " + sm2.getCurrentPassword().length()*8 + " bit");
        System.out.println("sm2.Crypt: " + cipherText);
        System.out.println("sm2.Decrypt: " + sm2.decrypt(cipherText));
        
        SecurityManager sm3 = new SecurityManager();
        sm3.initRandomKey128();
        cipherText = sm3.encrypt(plainText);
        System.out.println("sm3.Password length: " + sm3.getCurrentPassword().length()*8 + " bit");
        System.out.println("sm3.Crypt: " + cipherText);
        System.out.println("sm3.Decrypt: " + sm3.decrypt(cipherText));
        
        SecurityManager sm4 = new SecurityManager();
        sm4.initRandomKey192();
        cipherText = sm4.encrypt(plainText);
        System.out.println("sm4.Password length: " + sm4.getCurrentPassword().length()*8 + " bit");
        System.out.println("sm4.Crypt: " + cipherText);
        System.out.println("sm4.Decrypt: " + sm4.decrypt(cipherText));
        
        SecurityManager sm5 = new SecurityManager();
        sm4.initRandomKey256();
        cipherText = sm5.encrypt(plainText);
        System.out.println("sm5.Password length: " + sm5.getCurrentPassword().length()*8 + " bit");
        System.out.println("sm5.Crypt: " + cipherText);
        System.out.println("sm5.Decrypt: " + sm5.decrypt(cipherText));
    }
}