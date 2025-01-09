package api.alura.forohub.controller;

import api.alura.forohub.domain.usuario.DatosUsuarioAutenticar;
import api.alura.forohub.domain.usuario.Usuario;
import api.alura.forohub.infra.security.DatosJWTtoken;
import api.alura.forohub.infra.security.TokenService;
import com.auth0.jwt.JWT;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacionController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity iniciarSesion(@RequestBody @Valid DatosUsuarioAutenticar datosUsuarioAutenticar) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(datosUsuarioAutenticar.login(),
                datosUsuarioAutenticar.clave());
        var usuarioAutenticado = authenticationManager.authenticate(authToken);
        var JWTtoken = tokenService.generarToken((Usuario) usuarioAutenticado.getPrincipal());
        return ResponseEntity.ok(new DatosJWTtoken(JWTtoken));
    }

}
