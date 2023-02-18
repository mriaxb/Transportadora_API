package br.com.uniamerica.transportadora.transportadoraapi.controllers;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/api/despesa")
public class DespesaController {

    @Autowired
    private DespesaRepository despesaRepository;



    @GetMapping
    public ResponseEntity<List<Despesa>> findAll()
    {
        return ResponseEntity.ok().body(this.despesaRepository.findAll());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Despesa> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.despesaRepository.findById(id).orElse(new Despesa()));
    }

    @PostMapping
    public ResponseEntity<?> cadastrar(
            @RequestBody Despesa despesa
    ){
        System.out.println("despesa aqui: " + despesa.getFrete().getProduto().getNome());

        despesa.setData(LocalDateTime.now());
        this.despesaRepository.save(despesa);
        return ResponseEntity.ok().body("Despesa Cadastrada com Sucesso.");
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> Delete(@PathVariable final Long id){
        try{
            Optional<Despesa> res = this.despesaRepository.findById(id);
            Despesa despesa = res.orElseThrow(() -> new Exception("Not Found"));

            this.despesaRepository.delete(despesa);
            return ResponseEntity.ok().body("No Content");
        } catch (Exception e){
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }



//    @DeleteMapping("/{id}")
//    public ResponseEntity<?> excluir(
//            @PathVariable final Long id,
//            @RequestBody final Despesa despesa
//    ){
//        this.despesaRepository.delete(despesa);
//        return ResponseEntity.ok().body("Despesa Deletada com Sucesso");
//    }


    @PutMapping("/{idDespesa}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idDespesa,
            @RequestBody final Despesa despesa
    ){
        if (idDespesa.equals(despesa.getId())) {
            this.despesaRepository.save(despesa);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }


//    @GetMapping("/despesa/{idAprovador}")
//    public ResponseEntity<?> findByAprovador(
//            @PathVariable("IdAprovador") Long IdAprovador){
//        return ResponseEntity.ok().body(this.despesaRepository.findByFreteAndAprovadorIsNull(IdAprovador));
//    }

}
