package api.alura.forohub.controller;

import api.alura.forohub.domain.topico.DatosNuevoTopico;
import api.alura.forohub.domain.topico.Topico;
import api.alura.forohub.domain.topico.TopicoDto;
import api.alura.forohub.domain.topico.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @GetMapping
    public ResponseEntity<Page<TopicoDto>> consultarTopicos(@PageableDefault(size = 10) Pageable paginacion) {
        return ResponseEntity.ok(topicoRepository.findAll(paginacion).map(TopicoDto::new));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<TopicoDto> crearTopico(@RequestBody @Valid DatosNuevoTopico datosNuevoTopico) {
        Topico topico = topicoRepository.save(new Topico(datosNuevoTopico.titulo(), datosNuevoTopico.mensaje()));
        return ResponseEntity.ok(new TopicoDto(topico));
    }
}
