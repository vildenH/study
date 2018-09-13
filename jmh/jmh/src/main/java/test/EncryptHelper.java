package test;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.nio.charset.StandardCharsets;

/**
 * @Author zhaoxinwang
 * @date 2018/8/2
 */
public class EncryptHelper {

    /**
     * AES256 ECB PKCS5Padding 加密
     * 无盐，速度快，适合上下游通信传递
     */
    public static String encrypt256Aes(String content, String key) {
        byte[] aesBytes = EncryptionUtils.encrypt(content, key, EncryptionUtils.TRANSFORMATION_AES_ECB, EncryptionUtils.ALGORITHM_AES, EncryptionUtils.KEY_AES_SIZE);
        return ArrayUtils.isNotEmpty(aesBytes) ? EncryptionUtils.base64Encode(aesBytes) : null;
    }

    /**
     * AES256 ECB PKCS5Padding 解密
     * 无盐，速度快，适合上下游通信传递
     */
    public static String decrypt256Aes(String content, String key) {
        if (StringUtils.isBlank(content) || StringUtils.isBlank(key)) {
            return null;
        }
        byte[] aesBytes = EncryptionUtils.decrypt(EncryptionUtils.base64Decode(content), key, EncryptionUtils.TRANSFORMATION_AES_ECB, EncryptionUtils.ALGORITHM_AES, EncryptionUtils.KEY_AES_SIZE);
        return ArrayUtils.isNotEmpty(aesBytes) ? new String(aesBytes, StandardCharsets.UTF_8) : null;
    }

    /**
     * AES256 CBC PKCS5Padding 加密，含有随机盐
     * 返回包括16位随机盐+VI+cipher进行base64
     */
    public static String encrypt256AesWithSalt(String content, String key) {
        if (StringUtils.isBlank(content) || StringUtils.isBlank(key)) {
            return null;
        }
        byte[] aesBytes = EncryptionUtils.encryptWithSalt(content, key, EncryptionUtils.TRANSFORMATION_AES_BCB, EncryptionUtils.ALGORITHM_AES, EncryptionUtils.KEY_AES_SIZE);
        return ArrayUtils.isNotEmpty(aesBytes) ? EncryptionUtils.base64Encode(aesBytes) : null;
    }

    /**
     * AES256 CBC PKCS5Padding 解密，含有随机盐
     * 使用encrypt256AesWithSalt加密的字符串得到明文字符串
     */
    public static String decrypt256AesWithSalt(String content, String key) {
        if (StringUtils.isBlank(content) || StringUtils.isBlank(key)) {
            return null;
        }
        byte[] aesBytes = EncryptionUtils.decryptWithSalt(EncryptionUtils.base64Decode(content), key, EncryptionUtils.TRANSFORMATION_AES_BCB, EncryptionUtils.ALGORITHM_AES, EncryptionUtils.KEY_AES_SIZE);
        return ArrayUtils.isNotEmpty(aesBytes) ? new String(aesBytes, StandardCharsets.UTF_8) : null;
    }
}
