/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.middleware;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import com.mycompany.api.security.NoAuthenticationRequired;
import java.io.IOException;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;

/**
 *
 * @author manuelmsni
 */
@Provider
public class SessionMiddleware implements ContainerRequestFilter {

    @Context
    private ResourceInfo resourceInfo;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        
        // Utilizar ResourceInfo para acceder a la clase y al método del recurso
        boolean noAuthRequired = resourceInfo.getResourceMethod().isAnnotationPresent(NoAuthenticationRequired.class)
                                 || resourceInfo.getResourceClass().isAnnotationPresent(NoAuthenticationRequired.class);

        if (noAuthRequired) {
            return;
        }

        boolean sessionValid = checkSession();
        
        if (!sessionValid) {
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

    /**
     * Comprueva si la sesión es válida
     * @return true si es válida, false si no lo es
     */
    private boolean checkSession() {
        // TODO : Implementar JWT
        return true;
    }
}