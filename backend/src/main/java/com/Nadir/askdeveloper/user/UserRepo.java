package com.Nadir.askdeveloper.user;

import com.Nadir.askdeveloper.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM users AS u where u.name=?1")
    User getByUserName(String name);

    @Query("SELECT u FROM users AS u where u.name=?1")
    Optional<User> findByUserName(String name);
}
