package com.Nadir.askdeveloper.repo;

import com.Nadir.askdeveloper.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query("UPDATE Comment c SET c.votes = ?2 WHERE c.id = ?1")
    void vote(int qid, int updatedvote);
    @Modifying
    @Query("UPDATE Comment a SET a.text = ?2 WHERE a.id = ?1")
    void update(int id, String text);
}
