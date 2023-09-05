package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.Exception.UserExistsException;
import com.Nadir.askdeveloper.Exception.UserNotFoundException;
import com.Nadir.askdeveloper.Mapper.UserSaveMapper;
import com.Nadir.askdeveloper.dto.UserSaveDTO;
import com.Nadir.askdeveloper.model.User;
import com.Nadir.askdeveloper.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    public void save(UserSaveDTO user) {
        User u = UserSaveMapper.INSTANCE.createFullObjectforSave(user, userRepo);
        User usertemp = userRepo.getByUserName(user.getUsername());
        if (usertemp == null) {
            userRepo.save(u);
        }
        else throw new UserExistsException();
    }

    public User get(String username) {
        return userRepo.getByUserName(username);
    }
}
