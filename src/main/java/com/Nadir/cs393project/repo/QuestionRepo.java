package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface QuestionRepo extends JpaRepository<Question,Integer> {
    @Query("SELECT q FROM Question AS q")
    List<Question> getAll();
    @Query("SELECT q FROM Question AS q INNER JOIN q.tags t where t.name in ?1")
    List<Question> getAllWithTags(String[] tags);
    @Modifying
    @Query("UPDATE Question q SET q.votes = ?2 WHERE q.id = ?1")
    @Transactional
    void vote(int qid, int updatedvote);
    }
