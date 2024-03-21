package com.applications.gymApp.controllers;

import com.applications.gymApp.converter.UserConverter;
import com.applications.gymApp.dto.user.UserRequest;
import com.applications.gymApp.dto.user.UserResponse;
import com.applications.gymApp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserService userService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<UserResponse> getAllUsers(){
        return UserConverter.toApi(userService.getAll());
    }

    @GetMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public UserResponse getById(@PathVariable Integer id){
        return UserConverter.toApi(userService.getById(id));
    }
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse createUser(@RequestBody UserRequest request){
        var created = userService.create(UserConverter.toModel(request));
        return UserConverter.toApi(created);
    }

    @PutMapping(value = "/{id}", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public UserResponse updateUser(@PathVariable Integer id, @RequestBody UserRequest request) throws Exception {
        var updated = userService.update(id, UserConverter.toModel(request));
        return UserConverter.toApi(updated);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping(value = "/{id}", produces = APPLICATION_JSON_VALUE)
    public void deleteUser(@PathVariable Integer id){
        userService.delete(id);
    }
}
