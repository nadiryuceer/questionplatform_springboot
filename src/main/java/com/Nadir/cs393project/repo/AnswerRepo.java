package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {
    @Modifying
    @Query("UPDATE Answer a SET a.votes = ?2 WHERE a.id = ?1")
    @Transactional
    void vote(int qid, int updatedvote);
}
