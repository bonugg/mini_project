package com.example.mini_project.link_user;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name="T_MEMBER_LIKE")
public class UserLike {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long userlikeid;
    @Column
    private long nouser;
    @Column
    private long nolikeuser;
}
