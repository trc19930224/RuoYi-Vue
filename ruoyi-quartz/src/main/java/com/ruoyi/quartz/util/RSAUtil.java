package com.ruoyi.quartz.util;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.X509EncodedKeySpec;

public class RSAUtil {

    /*
    * @Description: 公钥加密
    * @Param: password 明文
    * @Param: publicKey 公钥
    * @return: String 密文
    */
    public static String encrypt(String password, String publicKey) throws Exception {
        //base64编码的公钥
        byte[] decoded = Base64.decodeBase64(publicKey);
        RSAPublicKey pubKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(decoded));
        //RAS加密
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,pubKey);
        return Base64.encodeBase64String(cipher.doFinal(password.getBytes("UTF-8")));
    }

}
