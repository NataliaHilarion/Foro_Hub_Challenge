package foro.hub.challenge.infra.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import foro.hub.challenge.domain.usuarios.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.secret}")
    private String apiSecret;

    public String generarToken(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            return JWT.create()
                    .withIssuer("foro hub")
                    .withSubject(usuario.getLogin())
                    .withClaim("id", usuario.getId())
                    .withExpiresAt(generarFechaExpiracion())
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            throw new RuntimeException();
        }
    }

    public String getSubject(String token) {
        if (token == null) {
            throw new RuntimeException("El token es nulo");
        }

        try {
            Algorithm algorithm = Algorithm.HMAC256(apiSecret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer("foro hub")
                    .build();
            DecodedJWT decodedJWT = verifier.verify(token); // Verifica el token
            return decodedJWT.getSubject(); // Obtiene el subject
        } catch (JWTVerificationException exception) {
            if (exception.getMessage().contains("The Token has expired")) {
                throw new RuntimeException("El token ha expirado, por favor solicite uno nuevo.");
            }
            throw new RuntimeException("Error al verificar el token: " + exception.getMessage());
        }
    }



    private Instant generarFechaExpiracion() {
        return LocalDateTime.now().plusDays(1).toInstant(ZoneOffset.of("-05:00"));
    }


}
