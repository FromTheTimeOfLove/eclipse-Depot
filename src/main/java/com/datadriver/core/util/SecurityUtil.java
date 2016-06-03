package com.datadriver.core.util;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.springframework.stereotype.Component;

import com.datadriver.core.feature.security.Coder;
import com.datadriver.web.common.enums.FinalConfig;

@Component("SecurityUtil")
public class SecurityUtil {
	
	private final static int	ITERATIONS	= 20;
	private static String		keyString	= PropertiesUtil.loadValue(FinalConfig.CONF_PROPERTIES, "conf.security.key");
	
	/**
	 * @Title: encrypt
	 * @Description:加密
	 * @param @param key
	 * @param @param plainText
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String encrypt(String plainText) throws Exception {
		try {
			byte[] salt = new byte[8];
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(keyString.getBytes());
			byte[] digest = md.digest();
			for (int i = 0; i < 8; i++) {
				salt[i] = digest[i];
			}
			PBEKeySpec pbeKeySpec = new PBEKeySpec(keyString.toCharArray());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey skey = keyFactory.generateSecret(pbeKeySpec);
			PBEParameterSpec paramSpec = new PBEParameterSpec(salt, ITERATIONS);
			Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
			cipher.init(Cipher.ENCRYPT_MODE, skey, paramSpec);
			byte[] cipherText = cipher.doFinal(plainText.getBytes());
			String saltString = new String(Base64.encodeBase64(salt));
			String ciphertextString = new String(Base64.encodeBase64(cipherText));
			return saltString + ciphertextString;
		} catch (Exception e) {
			throw new Exception("Encrypt Text Error:" + e.getMessage(), e);
		}
	}
	
	/**
	 * @Title: decrypt
	 * @Description: 解密
	 * @param @param key
	 * @param @param encryptTxt
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String decrypt(String encryptTxt) throws Exception {
		int saltLength = 12;
		try {
			String salt = encryptTxt.substring(0, saltLength);
			String ciphertext = encryptTxt.substring(saltLength, encryptTxt.length());
			byte[] saltarray = Base64.decodeBase64(salt.getBytes());
			byte[] ciphertextArray = Base64.decodeBase64(ciphertext.getBytes());
			PBEKeySpec keySpec = new PBEKeySpec(keyString.toCharArray());
			SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
			SecretKey skey = keyFactory.generateSecret(keySpec);
			PBEParameterSpec paramSpec = new PBEParameterSpec(saltarray, ITERATIONS);
			Cipher cipher = Cipher.getInstance("PBEWithMD5AndDES");
			cipher.init(Cipher.DECRYPT_MODE, skey, paramSpec);
			byte[] plaintextArray = cipher.doFinal(ciphertextArray);
			return new String(plaintextArray);
		} catch (Exception e) {
			throw new Exception(e);
		}
	}
	
	/**
	 * @Title: base64MultiEncrypt
	 * @Description:多层次的Base64加密
	 * @param @param plainText
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String base64MultiEncrypt(String plainText) throws Exception {
		plainText = Coder.encryptBASE64(plainText.getBytes());
		plainText = Coder.encryptBASE64(plainText.getBytes());
		plainText = Coder.encryptBASE64(plainText.getBytes());
		return plainText;
	}
	
	/**
	 * @Title: base64MultiDecrypt
	 * @Description:多层次的Base64加密
	 * @param @param plainText
	 * @param @return
	 * @param @throws Exception 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String base64MultiDecrypt(String encryptTxt) throws Exception {
		encryptTxt = new String(Coder.decryptBASE64(encryptTxt));
		encryptTxt = new String(Coder.decryptBASE64(encryptTxt));
		encryptTxt = new String(Coder.decryptBASE64(encryptTxt));
		return encryptTxt;
	}
}
