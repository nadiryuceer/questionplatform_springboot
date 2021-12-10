package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Comment;

import java.util.List;

public interface ProductService {
    public boolean save(Comment product);
    public List<Comment> getByName(String name);
}
