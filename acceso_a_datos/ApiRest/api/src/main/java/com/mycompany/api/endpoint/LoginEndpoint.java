/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.endpoint;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.mycompany.api.annotation.NoSessionRequired;

/**
 *
 * @author manuelmsni
 */
@Path("login")
@NoSessionRequired // Todo el recurso es accesible sin autenticación // Todo el recurso es accesible sin autenticación
public class LoginEndpoint {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(String credentials) {
        
        // TODO : Verificar credenciales
        
        return Response.ok("{\"message\":\"User logged in successfully\"}").build();
    }

}
