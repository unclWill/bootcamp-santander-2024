package me.dio.service;

import me.dio.domain.model.User;

/**
 * @author William
 * @date 29/07/2024
 */

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);

    boolean existsByAccountNumber(String accountNumber);
}
