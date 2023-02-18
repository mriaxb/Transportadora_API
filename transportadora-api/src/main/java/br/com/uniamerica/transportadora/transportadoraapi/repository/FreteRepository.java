package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FreteRepository extends JpaRepository<Frete, Long> {

    @Query(value = "select * from transportadora.tb_fretes where id = :id", nativeQuery = true)
    public Optional<Frete> findById(@Param("id") final Long id);

    public List<Frete> findByAtivoTrue();
}
