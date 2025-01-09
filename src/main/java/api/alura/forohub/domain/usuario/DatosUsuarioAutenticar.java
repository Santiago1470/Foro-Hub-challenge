package api.alura.forohub.domain.usuario;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosUsuarioAutenticar (

        @NotNull
        @NotBlank
        String login,

        @NotNull
        @NotBlank
        String clave
){
}
