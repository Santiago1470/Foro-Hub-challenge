package api.alura.forohub.controller;

import api.alura.forohub.domain.topico.*;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Optional;

@RestController
@RequestMapping("/topicos")
@SecurityRequirement(name = "bearer-key")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping("/{id}")
    public ResponseEntity<TopicoDto> consultarPorId(@PathVariable Long id) {
        Topico topico = topicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @GetMapping
    public ResponseEntity<Page<TopicoDto>> consultarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(TopicoDto::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> crearTopico(@RequestBody @Valid DatosNuevoTopico datosNuevoTopico,
                                                 UriComponentsBuilder uriComponentsBuilder) {
        Topico topico = topicoRepository.save(new Topico(datosNuevoTopico.titulo(), datosNuevoTopico.mensaje()));
        var uri = uriComponentsBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new TopicoDto(topico));
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<TopicoDto> modificarTopico(@PathVariable Long id,
                                                     @RequestBody DatosActualizarTopico datosActualizarTopico) {
        Topico topico = topicoRepository.getReferenceById(id);
        topico.actualizarDatos(datosActualizarTopico);
        return ResponseEntity.ok(new TopicoDto(topico));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity ocultarTopico(@PathVariable Long id) {
        Optional<Topico> topico = topicoRepository.findById(id);
        if(topico.isEmpty()) {
            throw new EntityNotFoundException();
        }
        topicoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
