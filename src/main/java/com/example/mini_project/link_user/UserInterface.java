package com.example.mini_project.link_user;

import com.example.mini_project.oauth.Role;

public interface UserInterface {
    Long getNo();
    String getName();
    String getId();
    String getUsername();
    String getEmail();
    String getPassword();
    String getAdress();
    String getPhone();
    String getProvider();
    String getPicture();
    Role getRole();
    Long getUserlike();
    Integer getRn();

}
