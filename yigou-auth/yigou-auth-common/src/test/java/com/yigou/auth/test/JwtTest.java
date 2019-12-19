package com.yigou.auth.test;

import com.yigou.common.pojo.UserInfo;
import com.yigou.common.utils.JwtUtils;
import com.yigou.common.utils.RsaUtils;
import org.junit.Before;
import org.junit.Test;

import java.security.PrivateKey;
import java.security.PublicKey;

public class JwtTest {

    private static final String pubKeyPath = "C:\\tmp\\rsa\\rsa.pub";

    private static final String priKeyPath = "C:\\tmp\\rsa\\rsa.pri";

    private PublicKey publicKey;

    private PrivateKey privateKey;

    @Test
    public void testRsa() throws Exception {
        RsaUtils.generateKey(pubKeyPath, priKeyPath, "yigou@Login(Auth}*^31)&heiMa%");
    }

    //@Before
    public void testGetRsa() throws Exception {
        this.publicKey = RsaUtils.getPublicKey(pubKeyPath);
        this.privateKey = RsaUtils.getPrivateKey(priKeyPath);
    }

    @Test
    public void testGenerateToken() throws Exception {
        // 生成token
        String token = JwtUtils.generateToken(new UserInfo(21L, "jacker"), privateKey, 5);
        System.out.println("token = " + token);
    }

    @Test
    public void testParseToken() throws Exception {
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJpZCI6MjAsInVzZXJuYW1lIjoiamFjayIsImV4cCI6MTU3NjQ5NTc5OH0.qS6m6JRmDgJ9Kqv9xbI8btRot0ilo-0rlWY1o4ChJ9W0yAzjK15clRbU6F-COOkuH7tR5rIoDVHTQimYu5tu3DMmrvu0Nh2nY_C183ygI-awXTFSvxCBRYM7t9Do2BtXUsSJqUJMwzeYAfvgBt7kac7ZemZa1rDFj0NkJpiJZmM";

        // 解析token
        UserInfo user = JwtUtils.getInfoFromToken(token, publicKey);
        System.out.println("id: " + user.getId());
        System.out.println("userName: " + user.getUsername());
    }
}