package com.houcine;


import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

/**
 * Created by hgasmi on 03/02/2017.
 */


@Component
@Path("/reverse")
public class ReverseEndpoint {

    @GET
    public String reverse(@QueryParam("input") @NotNull String input) {
        return new StringBuilder(input).reverse().toString();
    }

}
