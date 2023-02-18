package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.HistoricoFrete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HistoricoFreteRepository extends JpaRepository<HistoricoFrete, Long> {

    public List<HistoricoFrete> findByAtivoTrue();

    @Query(value = "select * from transportadora.tb_historicos_fretes " +
            "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<HistoricoFrete> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);

    @Query("from HistoricoFrete historicoFrete where historicoFrete.frete.id =: freteId")
    public List<HistoricoFrete> findByFrete(@Param("freteId") final Long freteId);
}
