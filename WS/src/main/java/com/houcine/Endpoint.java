package com.houcine;

import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

/**
 * Created by hgasmi on 03/02/2017.
 */
@Component
@Path("/hello")
public class Endpoint {

    private final Service service;

    public Endpoint(Service service) {
        this.service = service;
    }

    @GET
    public String message() {
        return "Hello " + this.service.message();
    }

}
