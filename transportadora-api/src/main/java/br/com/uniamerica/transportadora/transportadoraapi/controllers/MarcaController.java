package br.com.uniamerica.transportadora.transportadoraapi.controllers;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Marca;
import br.com.uniamerica.transportadora.transportadoraapi.repository.MarcaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/marca")
public class MarcaController {

    @Autowired
    private MarcaRepository marcaRepository;


    @GetMapping
    public ResponseEntity<List<Marca>> findAll()
    {
        return ResponseEntity.ok().body(this.marcaRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Marca> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.marcaRepository.findById(id).orElse(new Marca()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Marca marca
    )
    {
        this.marcaRepository.save(marca);
        return ResponseEntity.ok().body("Marca Cadastrada com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Marca marca
    ){
        this.marcaRepository.delete(marca);
        return ResponseEntity.ok().body("Marca Deletada com Sucesso");
    }



    @PutMapping("/{idMarca}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idMarca,
            @RequestBody final Marca marca
    ){
        if (idMarca.equals(marca.getId())) {
            this.marcaRepository.save(marca);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }




}
