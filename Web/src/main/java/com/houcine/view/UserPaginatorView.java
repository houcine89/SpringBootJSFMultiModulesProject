package com.houcine.view;

import com.houcine.dto.UserDTO;
import com.houcine.service.UserRoleService;
import com.houcine.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.primefaces.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
@ManagedBean(name = "userPaginatorView")
@Component
@ViewScoped
public class UserPaginatorView {
    private static final Logger LOG = LoggerFactory.getLogger(UserPaginatorView.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserRoleService userRoleService;


    public List<UserDTO> getUsers() {
        return userService.getAllUsers();
    }

    public Set<String> getRoles() {
        return userRoleService.getAllRoles();
    }

}
