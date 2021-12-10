package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Tag;

import java.util.List;

public interface CustomerService {
    public boolean save(Tag customer);
    public List<Tag> findByFirstName(String firstName);
    public List<Tag> findByLastName(String lastName);
    public List<Tag> findByFirstAndLastName(String firstName, String lastName);
}
