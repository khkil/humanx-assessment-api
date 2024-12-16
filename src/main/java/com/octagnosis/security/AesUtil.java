package com.octagnosis.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.encrypt.AesBytesEncryptor;
import org.springframework.stereotype.Component;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

@Component
@RequiredArgsConstructor
public class AesUtil {
    private final AesBytesEncryptor encryptor;

    public String encrypt(String str) {
        byte[] encrypt = encryptor.encrypt(str.getBytes(StandardCharsets.UTF_8));
        return byteArrayToString(encrypt);
    }

    public String decrypt(String encryptedStr) {
        byte[] decryptBytes = stringToByteArray(encryptedStr);
        byte[] decrypt = encryptor.decrypt(decryptBytes);
        return new String(decrypt, StandardCharsets.UTF_8);
    }

    private String byteArrayToString(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte abyte : bytes) {
            sb.append(abyte);
            sb.append(" ");
        }
        return sb.toString();
    }

    private byte[] stringToByteArray(String byteString) {
        String[] split = byteString.split("\\s");
        ByteBuffer buffer = ByteBuffer.allocate(split.length);
        for (String s : split) {
            buffer.put((byte) Integer.parseInt(s));
        }
        return buffer.array();
    }
}
