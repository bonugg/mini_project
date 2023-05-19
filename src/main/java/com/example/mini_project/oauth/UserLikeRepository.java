package com.example.mini_project.oauth;


import com.example.mini_project.link_user.UserLike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserLikeRepository extends JpaRepository<UserLike, Long> {
    @Query(value = "SELECT T.USERLIKEID FROM T_MEMBER_LIKE T WHERE T.NOLIKEUSER = :nolikeuser AND T.NOUSER = :nouser", nativeQuery = true)
    long findByUserLikeId(long nolikeuser, long nouser);

    @Query(value = "SELECT COUNT(*) FROM T_MEMBER_LIKE T WHERE T.NOLIKEUSER = :nolikeuser AND T.NOUSER = :nouser", nativeQuery = true)
    int LikeidCheck(long nolikeuser, long nouser);

}
