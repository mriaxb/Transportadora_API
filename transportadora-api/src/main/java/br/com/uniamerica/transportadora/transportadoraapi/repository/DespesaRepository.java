package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Despesa;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DespesaRepository extends JpaRepository<Despesa, Long> {

    @Query(value = "select * from transportadora.tb_despesas where id = :id", nativeQuery = true)
    public Optional<Despesa> findById(@Param("id") final Long id);

//    @Query("" +
//            " from Despesa despesa" +
//            " where 1 = 1 " +
//            " and despesa.frete.id = :IdFrete " +
//            " and despesa.ativo = true " +
//            " and despesa.aprovador.id is null")
//    public List<Despesa> findByFreteAndAprovadorIsNull(@Param("IdFrete") Long idFrete);



}
