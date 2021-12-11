package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Answer;
import com.Nadir.cs393project.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}
