package com.applications.gymApp.service;

import com.applications.gymApp.dao.UserRepository;
import com.applications.gymApp.dao.models.User;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public Collection<User> getAll() {
        return userRepository.findAll();
    }

    @Transactional(readOnly = true)
    public User getById(Integer id){
        return userRepository.getReferenceById(id);
    }
    @Transactional
    public User create(User request) {
        return userRepository.save(request);
    }

    @Transactional
    public User update(Integer id,User request){
        if (userRepository.existsById(id)) {
            request.setUserId(id);
            return userRepository.save(request);
        }
        throw new EntityNotFoundException("Entity by id = %s not found".formatted(id));
    }

    @Transactional
    public void delete(Integer id){
        userRepository.deleteById(id);
    }
}
