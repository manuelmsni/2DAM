/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.resources;

import com.mycompany.api.security.NoAuthenticationRequired;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author manuelmsni
 */
@Path("login")
@NoAuthenticationRequired // Todo el recurso es accesible sin autenticación
public class LoginResource {

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response loginUser(String credentials) {
        
        // TODO : Verificar credenciales
        
        return Response.ok("{\"message\":\"User logged in successfully\"}").build();
    }

}
