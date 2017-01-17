package com.houcine.service;

import com.houcine.model.User;
import com.houcine.model.UserRole;
import com.houcine.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

/**
 * Created by hgasmi on 17/01/2017.
 */
@Service
public class UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    public Set<String> getAllRoles() {
        return StreamSupport.stream(userRoleRepository.findAll().spliterator(), false).map(UserRole::getRole).collect(Collectors.toSet());
    }

    public void addRolesTo(User user, List<String> roles) {
        userRoleRepository.save(roles.stream().map(role -> new UserRole(user, role)).collect(Collectors.toList()));
    }
}
