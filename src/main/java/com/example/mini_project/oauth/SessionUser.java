package com.example.mini_project.oauth;

import lombok.Getter;
import lombok.ToString;

import java.io.Serializable;

@Getter
public class SessionUser implements Serializable {
    private String username;
    private String email;
    private String picture;

    public SessionUser(User user){
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.picture = user.getPicture();
    }
}