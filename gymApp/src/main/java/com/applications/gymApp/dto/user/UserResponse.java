package com.applications.gymApp.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserResponse {
    private Integer userId;
    private String login;
    private String password;
    private String userStatus;
}
