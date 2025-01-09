package api.alura.forohub.domain.topico;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "Topico")
@Table(name = "topicos")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String titulo;

    @NotNull
    @NotBlank
    @Column(unique = true)
    private String mensaje;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaCreacion;

    @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm")
    private LocalDateTime fechaModificacion;

}
