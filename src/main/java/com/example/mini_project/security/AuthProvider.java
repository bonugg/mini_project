package com.example.mini_project.security;

import com.example.mini_project.link_user.User;
import com.example.mini_project.oauth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Component
@RequiredArgsConstructor
public class AuthProvider implements AuthenticationProvider {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        try {
            String id = (String) authentication.getPrincipal(); // 로그인 창에 입력한 id
            String password = (String) authentication.getCredentials(); // 로그인 창에 입력한 password

            PasswordEncoder passwordEncoder = passwordEncoder();
            UsernamePasswordAuthenticationToken token;
            User user = userRepository.findByIdAndProvider(id, "linktree").get();

            if (user != null && passwordEncoder.matches(password, user.getPassword())) { // 일치하는 user 정보가 있는지 확인
                List<GrantedAuthority> roles = new ArrayList<>();
                roles.add(new SimpleGrantedAuthority("ROLE_USER")); // 권한 부여

                token = new UsernamePasswordAuthenticationToken(user.getId(), null, roles);

                return token;
            }
        }catch (NoSuchElementException ne){
            System.out.println(ne.getMessage());
        }
        throw new BadCredentialsException("아이디 또는 비밀번호를 찾을 수 없습니다");
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return true;
    }

    public PasswordEncoder passwordEncoder() {
        return this.passwordEncoder;
    }
}
