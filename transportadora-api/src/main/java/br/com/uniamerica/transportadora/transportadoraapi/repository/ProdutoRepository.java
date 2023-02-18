package br.com.uniamerica.transportadora.transportadoraapi.repository;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Estado;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Produto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    public List<Produto> findByAtivo(final boolean ativo);

    @Query("SELECT produto FROM Produto produto WHERE produto.ativo = true" )
    public List<Produto> findByProdutosAtivos();


    public List<Produto> findByNomeAndAtivo(final String nome, final boolean ativo);

}
