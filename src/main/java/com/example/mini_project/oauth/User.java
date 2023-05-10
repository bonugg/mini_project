package com.example.mini_project.oauth;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@Entity
@Table(name="T_MEMBER_LINK")
public class User {
    @Column
    private String name;
    @Column(nullable = false)
    private String username;
    @Id
    private String email;
    @Column
    private String password;
    @Column
    private String address;
    @Column
    private String phone;
    @Column
    private String provider;
    @Column
    private String picture;
    @Enumerated(EnumType.STRING)
    @Column
    private Role role;

    @Builder
    public User(String name, String username, String email, String password, String address, String phone, String provider, String picture, Role role) {
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phone = phone;
        this.provider = provider;
        this.picture = picture;
        this.role = role;
    }

    public User update(String username, String picture, String provider) {
        this.username = username;
        this.picture = picture;
        this.provider = provider;
        return this;
    }
    public String getRoleKey() {
        return this.role.getKey();
    }
}
