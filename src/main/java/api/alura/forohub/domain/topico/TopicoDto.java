package api.alura.forohub.domain.topico;

import java.time.LocalDateTime;

public record TopicoDto(
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        LocalDateTime fechaModificacion
) {
    public TopicoDto(Topico topico) {
        this(topico.getTitulo(), topico.getMensaje(), topico.getFechaCreacion(), topico.getFechaModificacion());
    }
}
