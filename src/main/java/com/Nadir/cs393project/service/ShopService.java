package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Answer;

import java.util.List;

public interface ShopService {
    public boolean save(Answer shop);
    public List<Answer> getByName(String name);
    public List<Answer> getAll();
    public Answer create(String name);
    public void delete(int id);
    public Answer getWithProductsGreaterThanX(int id, double price);
    public Answer getShopById(int id);
}
