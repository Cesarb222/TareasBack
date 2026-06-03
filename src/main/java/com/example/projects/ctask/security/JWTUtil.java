package com.example.projects.ctask.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
@Component
public class JWTUtil {

    //CREAMOS UNA VARIABLE SECRETA
    //PILLAMOS LOS BYTES DE ESA CLAVE
    //PONEMOS EL TIEMPO DE EXPIRACIÓN
    private final String SECRET_KEY = "a_todo_el_mundo_le_gusta_el_jamon";
    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    private final long EXPIRATION = 1000 * 60 * 60;

    //GENERAMOS TOKEN
    //identificamos el sujeto
    //setIssuedAt-> hace que nos indique el momento exacto que se ha creado
    //setExpiration -> pilla el tiempo inicial y le suma la expiracion.
    //signWith -> se firma con eso en el algoritmo HS256
    //y por ultimo se compacta
    /**
     * 
     * @param email
     * @return token
    
    */
    public String generarToken(String email){
        return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION))
        .signWith(key,SignatureAlgorithm.HS256)
        .compact();
    }

    public String obtenerUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    /**
     * 
     * @param token
     * @return true, si es valido
     * @return false, si no es valido
     */
    public boolean validarToken(String token){
        try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token);
            return true;
        } catch (JwtException e) {
            // TODO: handle exception
            return false;
        }
    }
}
