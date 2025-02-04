package com.ecommers.services;

import com.ecommers.entities.UserEntity;
import com.ecommers.exception.UserNotFoundException;
import com.ecommers.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.List;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserEntity createUser(UserEntity userEntity) {
        userRepository.persist(userEntity);
        return userEntity;
    }

    public List<UserEntity> findAll(Integer page, Integer pageSize) {
        return userRepository.findAll().page(page, pageSize).list();
    }

    public UserEntity findById(Long userId) {
        return (UserEntity) userRepository.findByIdOptional(userId).orElseThrow(UserNotFoundException::new);
    }

    public UserEntity updateUser(Long userId, UserEntity userEntity) {
        var user = findById(userId);

user.setName(userEntity.getName());

userRepository.persist(user);
return user;
    }

    public void deleteById(Long userId) {
        var user = findById(userId);
        userRepository.deleteById(user.getId());
    }
}
