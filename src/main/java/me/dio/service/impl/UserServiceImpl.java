package me.dio.service.impl;

import me.dio.domain.model.User;
import me.dio.domain.repository.UserRepository;
import me.dio.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author William
 * @date 29/07/2024
 */

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    @Transactional
    public User create(User userToCreate) {
        if (existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new RuntimeException("Account number already exists");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public boolean existsByAccountNumber(String accountNumber) {
        return userRepository.existsByAccountNumber(accountNumber);
    }
}