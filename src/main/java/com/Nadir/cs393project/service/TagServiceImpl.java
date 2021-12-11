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
    public boolean save(Tag tag){
        try {
            tagRepo.save(tag);
            return true;
        }catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }
    }
}
