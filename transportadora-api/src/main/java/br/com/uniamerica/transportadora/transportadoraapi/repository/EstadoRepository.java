package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EstadoRepository extends JpaRepository< Estado, Long> {

    @Query("SELECT estado FROM Estado estado WHERE estado.ativo = true" )
    public List<Estado> findByEstadosAtivos();

}
