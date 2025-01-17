package foro.hub.challenge.domain.usuarios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface UsuarioRepositoty extends JpaRepository<Usuario, Long> {

    UserDetails findByLogin(String username);
}
