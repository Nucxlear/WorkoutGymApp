package com.applications.gymApp.dto.user;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserRequest {
    private String login;
    private String password;
    private String userStatus;
}
