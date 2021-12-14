package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.Tag;
import com.Nadir.cs393project.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepo tagRepo;
    public void save(Tag tag){
        tagRepo.save(tag);
    }
}
