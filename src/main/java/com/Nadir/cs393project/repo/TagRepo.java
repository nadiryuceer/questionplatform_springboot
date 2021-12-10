package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Comment,Integer> {
    /*List<Comment> getByName(String name);
    @Query("SELECT p FROM Comment p WHERE p.shop.id = ?1 AND p.price>?2")
    List<Comment> getWithShopIdandGreaterThanX(int id, double price);
*/
    @Query("SELECT t, q FROM Tag t INNER JOIN t.questions q WHERE t.name in ?1")
    List<Question> getQsWithTags(List<String> tags);
}
