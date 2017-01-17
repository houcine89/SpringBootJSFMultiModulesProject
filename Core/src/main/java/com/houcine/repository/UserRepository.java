package com.houcine.repository;

import com.houcine.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by houcinegasmi on 15/01/2017.
 */
public interface UserRepository extends CrudRepository<User, String> {
}
