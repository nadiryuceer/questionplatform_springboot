package com.Nadir.cs393project.repo;

import com.Nadir.cs393project.model.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepo extends JpaRepository<Answer, Integer> {
    List<Answer> getByName(String name);
    Answer getShopById(int id);
    @Query("Select s from Shops s")
    List<Answer> getAll();
    //Unused but example of joined JPQL Query
    @Query("Select s,p FROM Shops s JOIN s.products p WHERE s.id = ?1 AND p.price>?2")
    public List<Answer> getWithProductsGreaterThanX(int id, double price);
}
