package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Tag,Integer> {
    List<Tag> findByFirstName(String firstName);
    List<Tag> findByLastName(String lastName);
    List<Tag> findByFirstNameAndLastName(String firstName, String lastName);
}
