package foro.hub.challenge.domain.topico;

public record DatosRespuestaTopico(
        Long id,
        String nombreUsuario,
        String titulo,
        String mensaje
) {
}
