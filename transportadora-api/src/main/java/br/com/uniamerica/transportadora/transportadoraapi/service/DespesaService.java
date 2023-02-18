package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.DespesaRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class DespesaService {

    @Autowired
    private DespesaRepository despesaRepository;

    public Despesa findById(Long id) {
        return this.despesaRepository.findById(id).orElse(new Despesa());
    }
}
