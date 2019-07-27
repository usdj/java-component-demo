package com.usdj.security.ecdsa;

import org.apache.commons.codec.binary.Hex;

import java.security.*;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * @author gerrydeng
 * @date 2019-07-22 22:28
 * @Description:
 */
public class UsdjECDSA {

    private static final String src = "Hello World!";

    public static void main(String[] args) {
        jdkECDSA();
    }

    private static void jdkECDSA() {
        try {
            // 1 初始化密钥
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("EC");
            keyPairGenerator.initialize(256);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            ECPublicKey rsaPublicKey = (ECPublicKey) keyPair.getPublic();
            ECPrivateKey rsaPrivateKey = (ECPrivateKey) keyPair.getPrivate();

            // 2 执行签名
            PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
            KeyFactory keyFactory = KeyFactory.getInstance("EC");
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Signature signature = Signature.getInstance("SHA1withECDSA");
            signature.initSign(privateKey);
            signature.update(src.getBytes());
            byte[] sign = signature.sign();
            System.out.println("Signed : " + Hex.encodeHexString(sign));

            // 3 验证签名
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            signature.initVerify(publicKey);
            signature.update(src.getBytes());
            boolean verify = signature.verify(sign);
            System.out.println("验证结果：" + verify);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        }
    }
}
