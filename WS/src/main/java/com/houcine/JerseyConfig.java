package com.houcine;


import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

/**
 * Created by hgasmi on 03/02/2017.
 */
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(Endpoint.class);
        register(ReverseEndpoint.class);
    }

}