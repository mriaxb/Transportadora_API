package br.com.uniamerica.transportadora.transportadoraapi.controllers;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import br.com.uniamerica.transportadora.transportadoraapi.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/caminhoes")
public class CaminhaoController {

    @Autowired
    private CaminhaoRepository caminhaoRepository;



    @GetMapping
    public ResponseEntity<List<Caminhao>> findAll()
    {
        return ResponseEntity.ok().body(this.caminhaoRepository.findByCaminhoesAtivos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Caminhao> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.caminhaoRepository.findById(id).orElse(new Caminhao()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Caminhao caminhao
    )
    {
        this.caminhaoRepository.save(caminhao);
        return ResponseEntity.ok().body("Caminhao Cadastrado com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Caminhao caminhao
    ){
        this.caminhaoRepository.delete(caminhao);
        return ResponseEntity.ok().body("Caminhao Deletado com Sucesso");
    }

    @PutMapping("/{idCaminhao}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idCaminhao,
            @RequestBody final Caminhao caminhao
    ){
        if (idCaminhao.equals(caminhao.getId())) {
            this.caminhaoRepository.save(caminhao);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }








}

