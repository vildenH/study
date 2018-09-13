package test;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;
import java.security.AlgorithmParameters;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Random;

/**
 * @Author zhaoxinwang
 * @date 2018/8/2
 */
public class EncryptionUtils {


    public static final String TRANSFORMATION_AES_ECB = "AES/ECB/PKCS5Padding";
    public static final String TRANSFORMATION_AES_BCB = "AES/CBC/PKCS5Padding";
    public static final String ALGORITHM_AES = "AES";
    public static final int KEY_AES_SIZE = 256;
    private static final String FACTORY_ALGORITHM = "PBKDF2WithHmacSHA256";
    private static final int KEYSPEC_ITERATION_COUNT = 12288;
    private static final int KEYSPEC_LENGTH = 256;
    private static final int BLOCK_SIZE = 16;

    /**
     * 加密算法,适合无盐、无IV，适合ECB模式
     */
    public static byte[] encrypt(String content, String key, String transformation, String algorithm, int keySize) {
        if (StringUtils.isBlank(content) || StringUtils.isBlank(key)) {
            return null;
        }
        try {
            KeyGenerator keygen = KeyGenerator.getInstance(algorithm);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            keygen.init(keySize, secureRandom);

            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(keygen.generateKey().getEncoded(), algorithm));
            return cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 解密算法，同encrypt方法对应
     */
    public static byte[] decrypt(byte[] content, String key, String transformation, String algorithm, int keySize) {
        if (ArrayUtils.isEmpty(content) || StringUtils.isBlank(key)) {
            return null;
        }
        try {
            KeyGenerator keygen = KeyGenerator.getInstance(algorithm);
            SecureRandom secureRandom = SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(key.getBytes());
            keygen.init(keySize, secureRandom);

            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(keygen.generateKey().getEncoded(), algorithm));
            return cipher.doFinal(content);
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * AES256加密算法，加随机盐，使用默认IV
     * 返回为：盐+IV+密文，适合携带IV的模式，如CBC模式
     */
    public static byte[] encryptWithSalt(String content, String key, String transformation, String algorithm, int keySize) {
        if (StringUtils.isBlank(content) || StringUtils.isEmpty(key)) {
            return null;
        }
        try {
            byte[] salt = generateSalt();
            SecretKey secret = getDefaultSecretKey(key, salt, algorithm);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.ENCRYPT_MODE, secret);
            AlgorithmParameters params = cipher.getParameters();
            byte[] initVector = params.getParameterSpec(IvParameterSpec.class).getIV();
            byte[] ciphertext = cipher.doFinal(content.getBytes(StandardCharsets.UTF_8));
            byte[] returnBytes = new byte[initVector.length + BLOCK_SIZE + ciphertext.length];
            System.arraycopy(salt, 0, returnBytes, 0, salt.length);
            System.arraycopy(initVector, 0, returnBytes, salt.length, initVector.length);
            System.arraycopy(ciphertext, 0, returnBytes, salt.length + initVector.length, ciphertext.length);
            return returnBytes;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * AES256解密算法，同encryptWithSalt方法对应
     * content：盐+IV+密文
     */
    public static byte[] decryptWithSalt(byte[] content, String key, String transformation, String algorithm, int keySize) {
        if (ArrayUtils.isEmpty(content) || StringUtils.isEmpty(key)) {
            return null;
        }
        try {
            byte[] salt = new byte[BLOCK_SIZE];
            System.arraycopy(content, 0, salt, 0, salt.length);
            byte[] iv = new byte[BLOCK_SIZE];
            System.arraycopy(content, salt.length, iv, 0, iv.length);
            byte[] ciphertext = new byte[content.length - salt.length - iv.length];
            System.arraycopy(content, salt.length + iv.length, ciphertext, 0, ciphertext.length);
            SecretKey secret = getDefaultSecretKey(key, salt, algorithm);
            Cipher cipher = Cipher.getInstance(transformation);
            cipher.init(Cipher.DECRYPT_MODE, secret, new IvParameterSpec(iv));
            byte[] rB = cipher.doFinal(ciphertext);
            return rB;
        } catch (Exception e) {
        }
        return null;
    }

    /**
     * 获取默认的秘钥流key，使用SecretKeyFactory和PBEKeySpec
     */
    private static SecretKey getDefaultSecretKey(String key, byte[] salt, String keyAlgorithm) throws InvalidKeySpecException, NoSuchAlgorithmException {
        return getSecretKey(key, salt, FACTORY_ALGORITHM, keyAlgorithm, KEYSPEC_ITERATION_COUNT, KEYSPEC_LENGTH);
    }

    /**
     * 获取默认的秘钥流key，使用SecretKeyFactory和PBEKeySpec
     */
    private static SecretKey getSecretKey(String key, byte[] salt, String factoryAlgorithm, String keyAlgorithm, int iterationCount, final int keyLength) throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory factory = SecretKeyFactory.getInstance(factoryAlgorithm);
        return new SecretKeySpec(factory.generateSecret(new PBEKeySpec(key.toCharArray(), salt, iterationCount, keyLength)).getEncoded(), keyAlgorithm);
    }

    /**
     * 获取随机盐
     */
    private static byte[] generateSalt() {
        Random r = new SecureRandom();
        byte[] salt = new byte[BLOCK_SIZE];
        r.nextBytes(salt);
        return salt;
    }

    /**
     * base64编码
     */
    public static String base64Encode(byte[] bytes) {
        return ArrayUtils.isNotEmpty(bytes) ? DatatypeConverter.printBase64Binary(bytes) : null;
    }

    /**
     * base64解码
     */
    public static byte[] base64Decode(String string) {
        return StringUtils.isNotBlank(string) ? DatatypeConverter.parseBase64Binary(string) : null;
    }
}
