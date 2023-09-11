package com.Nadir.askdeveloper.user;

import javax.validation.constraints.*;

public class UserSaveDTO {
    @NotEmpty(message = "username is required")
    @Pattern(regexp = "[^ ,]+", message = "username cannot contain space and comma")
    private String username;
    @NotEmpty(message = "email is required")
    @Email(message = "Email format is invalid. Should be in user@domain")
    private String email;
    @NotEmpty(message = "firstname is required")
    @Pattern(regexp = "[A-Z&a-z]+", message = "firstname should only consist of letters")
    private String firstname;
    @NotEmpty(message = "lastname is required")
    @Pattern(regexp = "[A-Z&a-z]+", message = "lastname should only consist of letters")
    private String lastname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
