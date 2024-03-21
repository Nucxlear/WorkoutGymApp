package com.applications.gymApp.dao;

import com.applications.gymApp.dao.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
