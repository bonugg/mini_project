package com.example.mini_project.security;

import com.example.mini_project.handler.LoginSuccessHandler;
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
                //csrf 제외
                .csrf().ignoringAntMatchers("/idCheck", "/get/test")
                .and()
                .headers().frameOptions().disable()
                .and()
                .authorizeRequests()
                // image 폴더를 login 없이 허용
                .antMatchers("/images/**").permitAll()
                // css 폴더를 login 없이 허용
                .antMatchers("/css/**").permitAll()
                // js 폴더를 login 없이 허용
                .antMatchers("/js/**").permitAll()
                .antMatchers("/" ,"/get/test" ,"/login" ,"/signup" ,"/user_search" ,"/user_link" ,"/myLinkAdd" ,"/idCheck").permitAll()
                .anyRequest().authenticated();

        http
                .formLogin()
                .loginPage("/")    // GET 요청
                .successHandler(new LoginSuccessHandler("/"))
                .permitAll()
                .loginProcessingUrl("/auth")    // POST 요청
                .usernameParameter("id")
                .passwordParameter("password");

        http
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true);

        http
                .oauth2Login()
                .loginPage("/login")
                .successHandler(new LoginSuccessHandler("/"))
                .permitAll()
                .userInfoEndpoint() //로그인 성공 후 사용자정보를 가져옴
                .userService(customOAuth2UserService) //사용자정보를 처리할 때 사용
                .and()
                .failureUrl("/login");
        return http.build();
    }
}