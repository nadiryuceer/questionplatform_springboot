package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepo extends JpaRepository<Answer,Integer> {

}
