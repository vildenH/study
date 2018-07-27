package aes.demo;


import org.junit.Test;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * @author wh
 * @date 2018/7/24
 */
public class Encryptor {

    public static String encrypt(String key, String initVector, String value) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, iv);

            byte[] encrypted = cipher.doFinal(value.getBytes());
            System.out.println("encrypted string: "
                    + Base64.getEncoder().encodeToString(encrypted));

            return Base64.getEncoder().encodeToString(encrypted);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static String decrypt(String key, String initVector, String encrypted) {
        try {
            IvParameterSpec iv = new IvParameterSpec(initVector.getBytes("UTF-8"));
            SecretKeySpec skeySpec = new SecretKeySpec(key.getBytes("UTF-8"), "AES");

            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, iv);

            byte[] original = cipher.doFinal(Base64.getDecoder().decode(encrypted));

            return new String(original);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public static void main(String[] args) {
        String key = "Bar12345Bar12345"; // 128 bit key
        String initVector = "RandomInitVector"; // 16 bytes IV

        System.out.println(decrypt(key, initVector,
                encrypt(key, initVector, "620423199009217066")));

    }

    @Test
    public void testBase64API() {
        byte[] binaryData = "这是一个小小的测试 this is a test only".getBytes();

        long t1 = System.currentTimeMillis();

        for (int i = 0; i < 10000 * 1000; i++)
            org.apache.commons.codec.binary.Base64.decodeBase64(org.apache.commons.codec.binary.Base64.encodeBase64String(binaryData));
        java.util.Base64.Encoder encoder = java.util.Base64.getEncoder();
        java.util.Base64.Decoder decoder = java.util.Base64.getDecoder();
        long t2 = System.currentTimeMillis();
        for (int i = 0; i < 10000 * 1000; i++)
            decoder.decode(encoder.encodeToString(binaryData));

        long t3 = System.currentTimeMillis();

        System.out.println("t2-t1:" + (t2 - t1));
        System.out.println("t3-t2:" + (t3 - t2));
    }

}
