package me.dio.controller;

import me.dio.domain.model.User;
import me.dio.dto.UserDTO;
import me.dio.mapper.UserMapper;
import me.dio.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

/**
 * @author William
 * @date 29/07/2024
 */

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> findById(@PathVariable Long id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(UserMapper.toDTO(user));
    }

    @PostMapping
    public ResponseEntity<UserDTO> create(@RequestBody UserDTO userToCreateDTO) {
        User userToCreate = UserMapper.toEntity(userToCreateDTO);
        User userCreated = userService.create(userToCreate);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(userCreated.getId())
                .toUri();
        return ResponseEntity.created(location).body(UserMapper.toDTO(userCreated));
    }
}
