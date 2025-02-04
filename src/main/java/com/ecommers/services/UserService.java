package com.ecommers.services;

import com.ecommers.entities.UserEntity;
import com.ecommers.exception.CpfAlreadyExistsException;
import com.ecommers.exception.EmailAlreadyExistsException;
import com.ecommers.exception.UserAlreadyExistsException;
import com.ecommers.exception.UserNotFoundException;
import com.ecommers.repositories.UserRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;

@ApplicationScoped
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public UserEntity createUser(UserEntity userEntity) {

        if (userRepository.find("cpf", userEntity.getCpf()).count() > 0 && userRepository.find("email", userEntity.getEmail()).count() > 0) {
            throw new UserAlreadyExistsException("Ja existe um usuario com este email e cpf" + userEntity.getEmail() + userEntity.getCpf());
        } else if (userRepository.find("cpf", userEntity.getCpf()).count() > 0) {
            throw new CpfAlreadyExistsException("Já existe um usuario com este CPF" + userEntity.getCpf());
        } else if (userRepository.find("email", userEntity.getEmail()).count() > 0) {
            throw new EmailAlreadyExistsException("Ja existe um um usuário com este email." + userEntity.getEmail());
        } else {
            userRepository.persist(userEntity);
        }
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
