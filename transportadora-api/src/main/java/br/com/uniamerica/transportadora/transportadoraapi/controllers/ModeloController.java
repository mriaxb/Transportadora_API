package br.com.uniamerica.transportadora.transportadoraapi.controllers;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Modelo;
import br.com.uniamerica.transportadora.transportadoraapi.repository.ModeloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/modelo")
public class ModeloController {

    @Autowired
    private ModeloRepository modeloRepository;


    @GetMapping
    public ResponseEntity<List<Modelo>> findAll()
    {
        return ResponseEntity.ok().body(this.modeloRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Modelo> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.modeloRepository.findById(id).orElse(new Modelo()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Modelo modelo
    )
    {
        this.modeloRepository.save(modelo);
        return ResponseEntity.ok().body("Modelo Cadastrado com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Modelo modelo
    ){
        this.modeloRepository.delete(modelo);
        return ResponseEntity.ok().body("Modelo Deletado com Sucesso");
    }



    @PutMapping("/{idModelo}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idModelo,
            @RequestBody final Modelo modelo
    ){
        if (idModelo.equals(modelo.getId())) {
            this.modeloRepository.save(modelo);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }



    @GetMapping("/modelo/{idMarca}")
    public ResponseEntity<?> findByMarca(
            @PathVariable("idMarca") Long idMarca){
        return ResponseEntity.ok().body(this.modeloRepository.findByMarca(idMarca));
    }
}
