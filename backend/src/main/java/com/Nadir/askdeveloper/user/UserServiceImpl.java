package com.Nadir.askdeveloper.user;

import com.Nadir.askdeveloper.Exception.UserExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
