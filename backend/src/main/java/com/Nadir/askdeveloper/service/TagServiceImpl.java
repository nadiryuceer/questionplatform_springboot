package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.model.Tag;
import com.Nadir.askdeveloper.repo.TagRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepo tagRepo;
    public void save(Tag tag){
        tagRepo.save(tag);
    }
}
