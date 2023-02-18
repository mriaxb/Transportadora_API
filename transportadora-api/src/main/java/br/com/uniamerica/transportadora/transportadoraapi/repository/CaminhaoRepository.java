package br.com.uniamerica.transportadora.transportadoraapi.repository;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Caminhao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CaminhaoRepository extends JpaRepository<Caminhao, Long>{

    @Query("SELECT caminhao FROM Caminhao caminhao WHERE caminhao.ativo = true" )
    public List<Caminhao> findByCaminhoesAtivos();

}
