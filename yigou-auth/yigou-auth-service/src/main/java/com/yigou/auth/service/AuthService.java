package com.yigou.auth.service;

import com.yigou.auth.client.UserClient;
import com.yigou.auth.config.JwtProperties;
import com.yigou.common.pojo.UserInfo;
import com.yigou.common.utils.JwtUtils;
import com.yigou.user.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UserClient userClient;

    @Autowired
    private JwtProperties properties;

    public String authentication(String username,String password){

        User user=this.userClient.queryUser(username,password);

        if (user== null){
            return null;
        }

        try {
            UserInfo userInfo = new UserInfo();
            userInfo.setId(user.getId());
            userInfo.setUsername(user.getUsername());
          return JwtUtils.generateToken(userInfo,properties.getPrivateKey(),properties.getExpire());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
}