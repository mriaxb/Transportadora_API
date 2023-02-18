package br.com.uniamerica.transportadora.transportadoraapi.controllers;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/cidade")
public class CidadeController {

    @Autowired
    private CidadeRepository cidadeRepository;


    @GetMapping
    public ResponseEntity<List<Cidade>> findAll()
    {
        return ResponseEntity.ok().body(this.cidadeRepository.findByCidadesAtivos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Cidade> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.cidadeRepository.findById(id).orElse(new Cidade()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Cidade cidade
    )
    {
        this.cidadeRepository.save(cidade);
        return ResponseEntity.ok().body("Cidade Cadastrada com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Cidade cidade
    ){
        this.cidadeRepository.delete(cidade);
        return ResponseEntity.ok().body("Cidade Deletada com Sucesso");
    }


    @PutMapping("/{idCidade}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idCidade,
            @RequestBody final Cidade cidade
    ){
        if (idCidade.equals(cidade.getId())) {
            this.cidadeRepository.save(cidade);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }


    @GetMapping("/cidade/{idEstado}")
    public ResponseEntity<?> findByEstado(@PathVariable("idEstado") Long idEstado){
        return ResponseEntity.ok().body(this.cidadeRepository.findByEstado(idEstado));
    }

}
