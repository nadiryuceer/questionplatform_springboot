package com.Nadir.askdeveloper.repo;

import com.Nadir.askdeveloper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
    @Query("SELECT u FROM users AS u where u.nickname=?1")
    User getByName(String name);
}
