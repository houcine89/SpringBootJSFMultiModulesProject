package com.houcine.view;

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
import java.util.stream.Collectors;

/**
 * Created by houcinegasmi on 18/01/2017.
 */
@ManagedBean(name = "userCreatorView")
@Component
@ViewScoped
public class UserCreatorView {

    private static final Logger LOG = LoggerFactory.getLogger(UserCreatorView.class);

    @Autowired
    private UserService userService;

    private String username;

    private String password;

    private List<String> selectedRoles;

    public void save() {
        LOG.info("save user: username=" + username + ", selectedRoles=" + selectedRoles.stream().collect(Collectors.joining(",")));
        if (StringUtils.isNotEmpty(username) && StringUtils.isNotEmpty(password) && !CollectionUtils.isEmpty(selectedRoles)) {
            userService.createUser(username, password, selectedRoles);
            RequestContext.getCurrentInstance().reset("form:panel");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Data Saved"));
        }

    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSelectedRoles() {
        return selectedRoles;
    }

    public void setSelectedRoles(List<String> selectedRoles) {
        this.selectedRoles = selectedRoles;
    }
}
