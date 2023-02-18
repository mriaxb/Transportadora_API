package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.TipoDespesa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TipoDespesaRepository extends JpaRepository<TipoDespesa, Long> {

}
