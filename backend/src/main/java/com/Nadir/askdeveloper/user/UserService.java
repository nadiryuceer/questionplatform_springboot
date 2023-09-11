package com.Nadir.askdeveloper.user;

public interface UserService {
    public void save(UserSaveDTO user);

    public User get(String username);
}
