package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.dto.UserSaveDTO;
import com.Nadir.askdeveloper.model.User;

public interface UserService {
    public void save(UserSaveDTO user);

    public User get(String username);
}
