package com.usdj.security.base64;

import com.sun.org.apache.bcel.internal.generic.FieldGenOrMethodGen;
import org.apache.commons.codec.binary.Base64;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.io.IOException;
import java.util.Arrays;

/**
 * @author gerrydeng
 * @date 2019-07-22 20:36
 * @Description: Base64三种编码解码方式 1jdk 2Commons Codec 3BouncyCastle
 */
public class UsjBase64 {

    private static final String key = "Hello World!";

    public static void main(String[] args) throws IOException {
//        jdkBase64();
//        commonsCodesBase64();
        bouncyCastleBase64();
    }

    private static void jdkBase64() throws IOException {
        BASE64Encoder base64Encoder = new BASE64Encoder();
        String encode = base64Encoder.encode(key.getBytes());
        System.out.println("Encode :" + encode);
        BASE64Decoder base64Decoder = new BASE64Decoder();
        System.out.println("Decode :" + new String(base64Decoder.decodeBuffer(encode)));
    }

    private static void commonsCodesBase64(){
        String encode = Base64.encodeBase64String(key.getBytes());
        System.out.println("Encode :" + encode);
        System.out.println("Decode :" + new String(Base64.decodeBase64(encode)));
    }

    private static void bouncyCastleBase64(){
        byte[] encode = org.bouncycastle.util.encoders.Base64.encode(key.getBytes());
        System.out.println("Encode :" + new String(encode));
        byte[] decode = org.bouncycastle.util.encoders.Base64.decode(encode);
        System.out.println("Decode :" + new String(decode));
    }
}
