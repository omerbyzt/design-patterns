package com.ba.facade;

public class CustomEncryptor {
    public static void main(String[] args) {
        String text = "Content";
//        AESEncryptor aesEncryptor = new AESEncryptor();
//        aesEncryptor.encrypt(text);
//
//        MD5Encryptor md5Encryptor = new MD5Encryptor();
//        md5Encryptor.encrypt(text, "KEY");
//
//        SHAEncryptor shaEncryptor = new SHAEncryptor();
//        shaEncryptor.encrypt(text, "KEY", false);

        EncyptorFacade encyptorFacade = new EncyptorFacade();
        encyptorFacade.encrypt(text, EncyptorFacade.EncType.AES);
    }
}
