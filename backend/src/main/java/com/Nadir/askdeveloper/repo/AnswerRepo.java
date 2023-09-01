package com.Nadir.askdeveloper.repo;

import com.Nadir.askdeveloper.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {
    @Modifying
    @Query("UPDATE Answer a SET a.votes = ?2 WHERE a.id = ?1")
    void vote(int qid, int updatedvote);

    @Modifying
    @Query("UPDATE Answer a SET a.text = ?2 WHERE a.id = ?1")
    void update(int id, String text);
}
