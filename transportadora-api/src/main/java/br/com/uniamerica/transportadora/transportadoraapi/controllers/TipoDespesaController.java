package br.com.uniamerica.transportadora.transportadoraapi.controllers;
import br.com.uniamerica.transportadora.transportadoraapi.entity.TipoDespesa;

import br.com.uniamerica.transportadora.transportadoraapi.repository.TipoDespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/tipoDespesa")
public class TipoDespesaController {

    @Autowired
    private TipoDespesaRepository tipoDespesaRepository;


    @GetMapping
    public ResponseEntity<List<TipoDespesa>> findAll()
    {
        return ResponseEntity.ok().body(this.tipoDespesaRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<TipoDespesa> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.tipoDespesaRepository.findById(id).orElse(new TipoDespesa()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody TipoDespesa tipoDespesa
            )
    {
        this.tipoDespesaRepository.save(tipoDespesa);
        return ResponseEntity.ok().body("Tipo de Despesa Cadastrada com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final TipoDespesa tipoDespesa
    ){
        this.tipoDespesaRepository.delete(tipoDespesa);
        return ResponseEntity.ok().body("Tipo de Despesa Deletada com Sucesso");
    }


    @PutMapping("/{idTipoDespesa}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idTipoDespesa,
            @RequestBody final TipoDespesa tipoDespesa
    ){
        if (idTipoDespesa.equals(tipoDespesa.getId())) {
            this.tipoDespesaRepository.save(tipoDespesa);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }


}
