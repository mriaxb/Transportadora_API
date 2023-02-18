package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.HistoricoFrete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;
import br.com.uniamerica.transportadora.transportadoraapi.repository.HistoricoFreteRepository;
import br.com.uniamerica.transportadora.transportadoraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Service
public class HistoricoFreteService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private HistoricoFreteRepository historicoFreteRepository;

    @Transactional
    public void cadastrar(final Frete frete, StatusFrete faturado){

        final Usuario usuario = this.usuarioRepository.findById(1L).orElse(null);

        final HistoricoFrete historicoFrete = new HistoricoFrete();
        historicoFrete.setStatusFrete(faturado);
        historicoFrete.setData(LocalDateTime.now());
        historicoFrete.setFrete(frete);
        historicoFrete.setExecutor(usuario);

        this.historicoFreteRepository.save(historicoFrete);
    }

}
