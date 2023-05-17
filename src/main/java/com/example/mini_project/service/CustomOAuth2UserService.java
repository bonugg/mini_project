package com.example.mini_project.service;

import com.example.mini_project.link_user.SessionUser;
import com.example.mini_project.link_user.User;
import com.example.mini_project.oauth.OAuthAttributes;
import com.example.mini_project.oauth.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserService;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.Collections;

@RequiredArgsConstructor
@Service
public class CustomOAuth2UserService implements OAuth2UserService<OAuth2UserRequest, OAuth2User> {
    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

        OAuth2UserService<OAuth2UserRequest, OAuth2User> delegate = new DefaultOAuth2UserService();
        OAuth2User oAuth2User = delegate.loadUser(userRequest);

        String registratrionId = userRequest.getClientRegistration().getRegistrationId();
        //구글or카카오or네이버 텍스트 추출
        String userNameAttributeName = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();
        OAuthAttributes attributes = OAuthAttributes.of(registratrionId, userNameAttributeName, oAuth2User.getAttributes());
        attributes.setProvider(registratrionId);
        //provider를 추출한 텍스트로 세팅

        User user = saveOrUpdate(attributes);
        httpSession.setAttribute("user", new SessionUser(user));
        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority(user.getRoleKey())),
                attributes.getAttributes(),
                attributes.getNameAttributeKey()
        );
    }

    private User saveOrUpdate(OAuthAttributes attributes){
        User user = userRepository.findByEmailAndProvider(attributes.getEmail(), attributes.getProvider())
                    .map(entity -> entity.update(attributes.getUsername(), attributes.getPicture(), attributes.getProvider()))
                .orElse(attributes.toEntity());
        return userRepository.save(user);
    }
}
