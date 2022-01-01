package com.Nadir.cs393project.service;

import com.Nadir.cs393project.model.User;
import com.Nadir.cs393project.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    public boolean save(User user) {
        try {
            userRepo.save(user);
            return true;
        } catch (Exception e){
            System.out.println(e.getCause());
            return false;
        }

    }
}
