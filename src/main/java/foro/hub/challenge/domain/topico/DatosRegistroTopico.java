package foro.hub.challenge.domain.topico;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosRegistroTopico(
        @NotBlank
        String nombreUsuario,
        @NotBlank
        String mensaje,
        @NotBlank
        @Email
        String email,
        @NotNull
        NombreCurso nombreCurso,
        @NotBlank
        String titulo
) {
}
