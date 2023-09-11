package com.Nadir.askdeveloper.user;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class UserController {

    public final String usersaveschema = "{\n    \"username\": \"string\",\n    \"email\": \"string\",\n    \"firstname\": \"string\",\n    \"lastname\": \"string\"}";

    @Autowired
    UserService userService;

    @Operation( summary = "CreateUser.",
            description = "Registers a new user.",
            tags = { "User" })
    @PostMapping(path = "/users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful save", content = @Content),
            @ApiResponse(responseCode = "500", description = "user with provided name/email exists", content = @Content)
    })
    public void addUser(@Valid @RequestBody UserSaveDTO user){
        userService.save(user);
    }

    @Operation( summary = "GetUserDetails.",
            description = "Returns user information details.",
            tags = { "User" })
    @GetMapping(path = "/users/{username}")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful", content = @Content(examples = @ExampleObject(value = usersaveschema))),
            @ApiResponse(responseCode = "404", description = "user not found", content = @Content)
    })
    public User getUserDetails(@PathVariable("username") String username){
        return userService.get(username);
    }
}
