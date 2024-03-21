package com.applications.gymApp.dao.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "Product")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Column(name = "userName", nullable = false)
    private String userName;
    @Column(name = "userStatus", nullable = false)
    private String userStatus;

}
