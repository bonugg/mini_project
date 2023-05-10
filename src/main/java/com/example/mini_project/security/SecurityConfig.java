package com.example.mini_project.security;

import com.example.mini_project.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                .antMatchers("/login", "/signup").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/login")    // GET 요청
                .loginProcessingUrl("/auth")    // POST 요청
                .usernameParameter("email")
                .passwordParameter("password")
                .defaultSuccessUrl("/");

        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/");

        http
                .oauth2Login()
                .loginPage("/login")
                .defaultSuccessUrl("/") // 로그인 성공 시 이동
                .userInfoEndpoint() //로그인 성공 후 사용자정보를 가져옴
                .userService(customOAuth2UserService) //사용자정보를 처리할 때 사용
                .and()
                .failureUrl("/")
        ;
        return http.build();
    }
}