package com.example.mini_project.link_user;

import lombok.Data;

import java.io.Serializable;

@Data
public class SessionUser implements Serializable {
    private long no;
    private String name;
    private String id;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String picture;
    private String provider;

    public SessionUser(User user){
        this.no = user.getNo();
        this.name = user.getName();
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.address = user.getAddress();
        this.phone = user.getPhone();
        this.picture = user.getPicture();
        this.provider = user.getProvider();
    }
}