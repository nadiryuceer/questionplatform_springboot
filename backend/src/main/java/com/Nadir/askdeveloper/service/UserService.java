package com.Nadir.askdeveloper.service;

import com.Nadir.askdeveloper.model.User;

public interface UserService {
    public boolean save(User user);

    public User get(String nickname);
}
