package com.applications.gymApp.converter;

import com.applications.gymApp.dao.models.User;
import com.applications.gymApp.dto.user.*;

import java.util.Collection;
import java.util.List;

public class UserConverter {
    public static User toModel(UserRequest api) {
        return new User()
                .setLogin(api.getLogin())
                .setPassword(api.getPassword())
                .setUserStatus(api.getUserStatus());
    }

    public static UserResponse toApi(User model) {
        return UserResponse.builder()
                .userId(model.getUserId())
                .login(model.getLogin())
                .password(model.getPassword())
                .userStatus(model.getUserStatus())
                .build();
    }

    public static List<UserResponse> toApi(Collection<User> models) {
        return models.stream()
                .map(UserConverter::toApi)
                .toList();
    }
}
