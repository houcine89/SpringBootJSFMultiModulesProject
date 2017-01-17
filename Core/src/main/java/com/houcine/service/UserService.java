package com.houcine.service;

import com.houcine.dto.UserDTO;
import com.houcine.model.User;
import com.houcine.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleService userRoleService;

    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<>();
        userRepository.findAll().forEach(user -> users.add(new UserDTO(user)));
        return users;
    }

    public void createUser(String username, String password, List<String> roles) {
        User user = userRepository.save(new User(username, password, false));
        userRoleService.addRolesTo(user, roles);
    }
}
