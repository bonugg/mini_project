package com.example.mini_project.oauth;

import com.example.mini_project.link_user.User;
import com.example.mini_project.link_user.UserInterface;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmailAndProvider(String email, String provider);
    Optional<User> findByIdAndProvider(String id, String provider);
    Optional<User> findByNo(long no);
    List<User> findByUsernameContaining(String username);
    @Query(value = "SELECT USERNAME FROM T_MEMBER_LINK T WHERE T.NO = :no", nativeQuery = true)
    String findByUsername(long no);
    @Query(value = "SELECT PICTURE FROM T_MEMBER_LINK T WHERE T.NO = :no", nativeQuery = true)
    String findByPicture(long no);
    @Query(value = "SELECT T.USERNAME FROM T_MEMBER_LINK T WHERE T.NO = :no", nativeQuery = true)
    String findUsername_str(long no);
    @Query(value = "SELECT COUNT(*) FROM T_MEMBER_LINK T WHERE T.ID = :id", nativeQuery = true)
    int idCheck(String id);
    @Query(value = "SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER (ORDER BY USERLIKE DESC, USERNAME) AS Rn FROM T_MEMBER_LINK T ORDER BY T.USERLIKE DESC ) WHERE Rn <= 3 AND USERLIKE >= 1", nativeQuery = true)
    List<UserInterface> bestLikeList();
    @Query(value = "SELECT * FROM (SELECT T.*, ROW_NUMBER() OVER (ORDER BY USERLIKE DESC) AS Rn FROM T_MEMBER_LINK T ORDER BY T.USERLIKE DESC, T.USERNAME) WHERE Rn <= 10 AND Rn >= 4 AND USERLIKE >= 1", nativeQuery = true)
    List<UserInterface> bestLikeList2();
}
