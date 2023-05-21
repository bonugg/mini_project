package com.example.mini_project.link_user;

import com.example.mini_project.oauth.Role;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="T_MEMBER_LINK")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long no;
    @Column
    private String name;
    @Column
    private String id;
    @Column(nullable = false)
    private String username;
    @Column
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
    @Column
    @ColumnDefault("0")
    private long userlike;

    @Builder
    public User(String name, String id, String username, String email, String password, String address, String phone, String provider, String picture, Role role) {
        this.name = name;
        this.id = id;
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

    public void plusLike(){
        this.userlike++;
    }

    public void minusLike(){
        this.userlike--;
    }
}
