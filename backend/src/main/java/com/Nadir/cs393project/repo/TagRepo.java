package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Question;
import com.Nadir.cs393project.model.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepo extends JpaRepository<Tag,Integer> {
    @Query("SELECT t, q FROM Tag t INNER JOIN t.questions q WHERE t.name in ?1")
    List<Question> getQsWithTags(List<String> tags);
    @Query("SELECT t FROM Tag AS t where t.name in ?1")
    List<Tag> getWithName(String[] tagnames);
    @Query("SELECT t FROM Tag AS t where t.name=?1")
    Tag getByName(String tagname);
}
