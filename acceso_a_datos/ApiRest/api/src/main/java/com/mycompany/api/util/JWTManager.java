/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.api.util;


import com.mycompany.api.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import java.util.Date;

/**
 *
 * @author manuelmsni
 */
public class JWTManager {

    // Clave secreta para firmar y verificar JWT (deberías cambiar esto en producción)
    private static final Key KEY = Keys.secretKeyFor(io.jsonwebtoken.SignatureAlgorithm.HS256);
    
    // Duración del token (1 día en milisegundos)
    private static final long TOKEN_VALIDITY = 24 * 60 * 60 * 1000; // 1 día

    public static String generateToken(User user) {
        // Calcula la fecha de expiración del token
        Date expiration = new Date(System.currentTimeMillis() + TOKEN_VALIDITY);

        // Construye el token JWT con el ID de usuario codificado
        return Jwts.builder()
                .setSubject(String.valueOf(user.getId())) // Codifica el ID de usuario como el "subject" del token
                .setExpiration(expiration) // Establece la fecha de expiración del token
                .signWith(KEY, SignatureAlgorithm.HS256) // Firma el token con la clave secreta
                .compact(); // Compacta el token en una cadena
    }

    public static boolean verifyToken(String jwtToken) {
        try {
            Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(jwtToken);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static Claims decodeToken(String jwtToken) {
        return Jwts.parserBuilder().setSigningKey(KEY).build().parseClaimsJws(jwtToken).getBody();
    }
}