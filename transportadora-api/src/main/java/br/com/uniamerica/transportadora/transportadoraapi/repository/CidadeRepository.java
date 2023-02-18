package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Cidade;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

    public List<Cidade> findByAtivoTrue();

    @Query("SELECT cidade FROM Cidade cidade WHERE cidade.ativo = true" )
    public List<Cidade> findByCidadesAtivos();



    @Query(value = "select * from transportadora.tb_cidades " +
            "where nome ilike '%' || :nome || '%' ", nativeQuery = true)
    public List<Cidade> findByLikeNomeAndAtivoTrue(@Param("nome") final String nome);


    @Query("from Cidade cidade where cidade.estado.id = :estadoId")
    public List<Cidade> findByEstado(@Param("estadoId") final Long estadoId);

}
