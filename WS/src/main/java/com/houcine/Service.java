package com.houcine;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by hgasmi on 03/02/2017.
 */
@Component
public class Service {

    @Value("${message:World}")
    private String msg;

    public String message() {
        return this.msg;
    }

}
