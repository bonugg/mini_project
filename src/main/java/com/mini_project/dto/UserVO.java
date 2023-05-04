package com.mini_project.dto;

import java.util.ArrayList;
import java.util.Collection;

import com.mini_project.service.LinkService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserVO implements UserDetails {

    private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

    private String M_ID;
    private String M_PWD;
    private String AUTHORITY;
    private char ENABLED;

    public UserVO(String M_ID){
        this.M_ID = M_ID;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
//        ArrayList<GrantedAuthority> auth = new ArrayList<GrantedAuthority>();
//        auth.add(new SimpleGrantedAuthority(AUTHORITY));
        ArrayList<GrantedAuthority> a = new ArrayList<>();
        a.add(new SimpleGrantedAuthority("ROLE_USER"));
        return a;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return M_PWD;
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return M_ID;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        if(ENABLED == 1){
            return true;
        }else
            return false;
    }
}