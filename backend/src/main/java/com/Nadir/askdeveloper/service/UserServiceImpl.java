package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.model.User;
import com.Nadir.askdeveloper.repo.UserRepo;
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
