package com.Nadir.askdeveloper.tag;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepo tagRepo;
    public void save(Tag tag){
        tagRepo.save(tag);
    }

    public void getAllTags(){
        tagRepo.getAll();
    }
}
