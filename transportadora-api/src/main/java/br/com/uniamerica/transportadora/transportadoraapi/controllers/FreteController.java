package br.com.uniamerica.transportadora.transportadoraapi.controllers;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.FreteRepository;

import br.com.uniamerica.transportadora.transportadoraapi.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/api/frete")
public class FreteController {

    @Autowired
    private FreteRepository freteRepository;

    @Autowired
    private FreteService freteService;

    @GetMapping
    public ResponseEntity<List<Frete>> findAll() {
        return ResponseEntity.ok().body(this.freteRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Frete> findById(
            @PathVariable("id") final Long id
    ) {
        System.out.println(freteRepository.findAll());
        return ResponseEntity.ok().body(this.freteRepository.findById(id).orElse(new Frete()));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Frete frete
    ){
        frete.setStatusFrete(StatusFrete.CARGA);
        frete.setCadastro(LocalDateTime.now());
        this.freteRepository.save(frete);
        return ResponseEntity.ok().body("Frete Cadastrado com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Frete frete
    ) {
        this.freteRepository.delete(frete);
        return ResponseEntity.ok().body("Frete Deletado com Sucesso");
    }

    @PutMapping("/{idFrete}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idFrete,
            @RequestBody final Frete frete
    ){
        if (idFrete.equals(frete.getId())) {
            this.freteRepository.save(frete);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }

    @PutMapping("/status/faturado/{idFrete}")
    public ResponseEntity<?> atualizarStatusFaturado(
            @PathVariable Long idFrete,
            @RequestBody Frete frete
    ){
        try{
            this.freteService.atualizarStatusFaturado(idFrete, frete);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Frete faturado com sucesso.");
    }

    @PutMapping("/update/{idFrete}")
    public ResponseEntity<?> verificaUpdateFrete(
            @PathVariable Long idFrete,
            @RequestBody Frete frete
    ) {
        try {
            this.freteService.verificaUpdateFrete(idFrete, frete);
            return ResponseEntity.ok().body("Frete Atualizado com Sucesso.");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/status/interrompido/{idFrete}")
    public ResponseEntity<?> atualizarStatusInterrompido(
            @PathVariable final Long idFrete,
            @RequestBody Frete frete
    ){
        try{
            this.freteService.atualizarStatusInterrompido(idFrete, frete);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Frete interrompido com sucesso.");
    }

//    @PutMapping("/status/em_transporte/{idFrete}")
//    public ResponseEntity<?> atualizarStatusEmTransporte(@PathVariable("idFrete") final Long idFrete) {
//        try{
//            this.freteService.atualizarStatusEmTransporte(idFrete);
//        }
//        catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
//        return ResponseEntity.ok().body("Frete alterado para Em Transporte com sucesso.");
//    }
//
    @PutMapping("/status/em_transporte/{idFrete}")
    public ResponseEntity<?> atualizarStatusEmTransporte(
            @PathVariable final Long idFrete,
            @RequestBody Frete frete
    ){

        try {
            this.freteService.atualizarStatusEmTransporte(idFrete, frete);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Registro atualizado com sucesso");
    }

    @PutMapping("/status/cancelado/{idFrete}")
    public ResponseEntity<?> atualizarStatusCancelado(
            @PathVariable final Long idFrete,
            @RequestBody Frete frete

    ){
        try{
            this.freteService.atualizarStatusCancelado(idFrete, frete);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Frete cancelado com sucesso.");
    }

    @PutMapping("/status/descarga/{idFrete}")
    public ResponseEntity<?> atualizarStatusDescarga(
            @PathVariable final Long idFrete,
            @RequestBody Frete frete

    ){
        try{
            this.freteService.atualizarStatusDescarga(idFrete, frete);
        }
        catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return ResponseEntity.ok().body("Frete em Descarga.");
    }
}
