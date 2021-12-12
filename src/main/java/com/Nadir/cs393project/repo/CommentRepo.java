package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CommentRepo extends JpaRepository<Comment,Integer> {
    @Modifying
    @Query("UPDATE Comment c SET c.votes = ?2 WHERE c.id = ?1")
    @Transactional
    void vote(int qid, int updatedvote);
}
