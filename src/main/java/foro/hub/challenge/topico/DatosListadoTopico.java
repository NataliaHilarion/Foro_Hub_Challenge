package foro.hub.challenge.topico;

public record DatosListadoTopico(
        Long id,
        String nombreUsuario,
        String titulo,
        String mensaje,
        NombreCurso nombreCurso
)
{
    public DatosListadoTopico(Topico topico){
        this(topico.getId(), topico.getNombreUsuario(), topico.getTitulo(), topico.getMensaje(), NombreCurso.valueOf(topico.getNombreCurso().toString()));
    }


}
