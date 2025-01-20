package org.example.services.authentication;

import org.example.enums.TextLinks;
import org.example.services.txt.WriteTxt;
import org.example.services.txt.ReadTxtFile;

import javax.crypto.spec.SecretKeySpec;
import java.io.File;
import java.security.Key;
import java.util.Arrays;
import java.util.Random;

public class LoginStorage {
    private final String ALGORITHM = "AES";
    private final String filePath;
    private final int byteLength = 16;


    /**
     * для работы с файлами и шифрованием данных описаны в документации Oracle:
     * - Описание класса `FileInputStream`: <a href="https://docs.oracle.com/javase/8/docs/api/java/io/FileInputStream.html">...</a>
     * - Описание класса `FileOutputStream`: <a href="https://docs.oracle.com/javase/8/docs/api/java/io/FileOutputStream.html">...</a>
     * - Описание класса `Cipher`: <a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/Cipher.html">...</a>
     * - Описание класса `SecretKeySpec`: <a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/SecretKeySpec.html">...</a>
     * - Описание класса `IvParameterSpec`: <a href="https://docs.oracle.com/javase/8/docs/api/javax/crypto/spec/IvParameterSpec.html">...</a>
     * Документация по JCE (Java Cryptography Extension),
     * который используется для шифрования и дешифрования данных:
     * <a href="https://docs.oracle.com/javase/8/docs/technotes/guides/security/crypto/CryptoSpec.html">...</a>
     */

    public LoginStorage() {
        String home = TextLinks.USER_HOME.getString();
        String linksLoginFile = TextLinks.AUTHORIZATION.getString();
        this.filePath = System.getProperty(home) + File.separator + linksLoginFile;
    }


    public void saveToFile(String login, String password) throws Exception {
        String secretKey = createSecretKey();
        Key key = byteKey(secretKey);
        LoginCrypt storage = new LoginCrypt();
        String encryptedLogin = storage.encrypt(login, key, ALGORITHM);
        String encryptedPassword = storage.encrypt(password, key, ALGORITHM);
        new WriteTxt(filePath, encryptedLogin, encryptedPassword, secretKey);
    }


    public String[] readFromFile() throws Exception {
        String str = new ReadTxtFile().readTxtFile(filePath);
        String[] div = str.split(System.lineSeparator());
        String[] credentialsFromFile = div[0].split(";");

        LoginCrypt storage = new LoginCrypt();
        String secretKey = credentialsFromFile[2];
        Key key = byteKey(secretKey);

        String decryptedLogin = storage.decrypt(credentialsFromFile[0], key, ALGORITHM);
        String decryptedPassword = storage.decrypt(credentialsFromFile[1], key, ALGORITHM);
        return new String[]{decryptedLogin, decryptedPassword};
    }


    public Key byteKey(String secretKey) {
        //Длина ключа для AES должна составлять 16, 24 или 32 байт
        byte[] keyBytes = secretKey.getBytes();
        byte[] newKeyBytes = Arrays.copyOf(keyBytes, byteLength);
        return new SecretKeySpec(newKeyBytes, ALGORITHM);
    }


    private String createSecretKey() {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*()";
        StringBuilder sb = new StringBuilder(24);
        Random random = new Random();
        for (int i = 0; i < 23; i++) {
            int index = random.nextInt(characters.length());
            sb.append(characters.charAt(index));
        }
        sb.append("=");
        return sb.toString();
    }

}
