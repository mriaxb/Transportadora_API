package br.com.uniamerica.transportadora.transportadoraapi.controllers;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import br.com.uniamerica.transportadora.transportadoraapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/estado")
public class EstadoController {


    @Autowired
    private EstadoRepository estadoRepository;


    @GetMapping
    public ResponseEntity<List<Estado>> findAll()
    {
        return ResponseEntity.ok().body(this.estadoRepository.findByEstadosAtivos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Estado> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.estadoRepository.findById(id).orElse(new Estado()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Estado estado
    )
    {
        this.estadoRepository.save(estado);
        return ResponseEntity.ok().body("Estado Cadastrado com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Estado estado
    ){
        this.estadoRepository.delete(estado);
        return ResponseEntity.ok().body("Estado Deletado com Sucesso");
    }

    @PutMapping("/{idEstado}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idEstado,
            @RequestBody final Estado estado
    ){
        if (idEstado.equals(estado.getId())) {
            this.estadoRepository.save(estado);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }




}
