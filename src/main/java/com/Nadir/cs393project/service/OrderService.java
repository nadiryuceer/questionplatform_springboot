package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.User;

import java.util.List;

public interface OrderService {
    public boolean save(User order);
    public List<User> getById(int id);
}
