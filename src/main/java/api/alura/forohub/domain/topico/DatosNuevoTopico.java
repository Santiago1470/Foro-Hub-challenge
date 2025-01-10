package api.alura.forohub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosNuevoTopico(
        @NotBlank
        @NotNull
        String titulo,

        @NotBlank
        @NotNull
        String mensaje
) {
}
