package br.com.uniamerica.transportadora.transportadoraapi.controllers;
import br.com.uniamerica.transportadora.transportadoraapi.repository.HistoricoFreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/historicoFrete")
public class HistoricoFreteController {

    @Autowired
    public HistoricoFreteRepository historicoFreteRepository;

    @GetMapping("/historicoFrete/{idFrete}")
    public ResponseEntity<?> findByFrete(@PathVariable("freteId") Long freteId){
        return ResponseEntity.ok().body(this.historicoFreteRepository.findByFrete(freteId));
    }
}
