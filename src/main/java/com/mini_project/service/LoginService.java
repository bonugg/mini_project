package com.mini_project.service;

import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class LoginService {
    private static PasswordEncoder passwordEncoder;

    private static void encode() {

        // 이렇게쓰면 기본으로 bcrypt형식으로 암호화 되는구나..
        passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        String password = "password";
        String encPassword = passwordEncoder.encode(password);

        System.out.println(" password : " + password );
        System.out.println(" encPassword : " + encPassword ); // encode의 결과로 앞에 저절로 {bcrypt}가 붙어왔네 ??

        System.out.println("1. passwordEncoder.matches(password, encPassword); : " + passwordEncoder.matches(password, encPassword));
        System.out.println("2. (encPassword).contains(\"{bcrypt}\") : " + (encPassword).contains("{bcrypt}"));

    }
}