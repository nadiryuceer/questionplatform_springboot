package com.Nadir.cs393project.service;


import com.Nadir.cs393project.model.Comment;
import com.Nadir.cs393project.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    TagRepo productRepo;
    public boolean save(Comment product){
        try {
            productRepo.save(product);
            return true;
        }catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }

    public List<Comment> getByName(String name){
        return productRepo.getByName(name);
    }
}
