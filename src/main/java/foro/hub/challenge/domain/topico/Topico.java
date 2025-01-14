package foro.hub.challenge.domain.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Table(name = "topicos")
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombreUsuario;
    private String mensaje;
    private String email;
    @Enumerated(EnumType.STRING)
    private NombreCurso nombreCurso;
    private String titulo;
    private boolean activo;

    public Topico(DatosRegistroTopico datosRegistroTopico){
        this.activo = true;
        this.nombreUsuario = datosRegistroTopico.nombreUsuario();
        this.email = datosRegistroTopico.email();
        this.mensaje = datosRegistroTopico.mensaje();
        this.nombreCurso = datosRegistroTopico.nombreCurso();
        this.titulo = datosRegistroTopico.titulo();
    }

    public void actualizarDatos(DatosActualizarTopico datosActualizarTopico) {

        if(datosActualizarTopico.mensaje()!= null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if(datosActualizarTopico.nombreUsuario()!=null){
            this.nombreUsuario = datosActualizarTopico.nombreUsuario();
        }
        if(datosActualizarTopico.titulo()!=null){
            this.titulo = datosActualizarTopico.titulo();
        }
    }


    public void desactivarTopico() {
        this.activo = false;
    }
}
