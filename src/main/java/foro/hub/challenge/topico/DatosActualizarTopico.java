package foro.hub.challenge.topico;

import jakarta.validation.constraints.NotNull;

//No se actualiza el correo ni nombre del curso
public record DatosActualizarTopico(
        @NotNull
        Long id,
        String nombreUsuario,
        String mensaje,
        String titulo
) {
}
