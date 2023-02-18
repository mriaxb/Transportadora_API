package br.com.uniamerica.transportadora.transportadoraapi.controllers;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Produto;
import br.com.uniamerica.transportadora.transportadoraapi.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/produto")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @GetMapping
    public ResponseEntity<List<Produto>> findAll()
    {
        return ResponseEntity.ok().body(this.produtoRepository.findByProdutosAtivos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.produtoRepository.findById(id).orElse(new Produto()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Produto produto
    )
    {
        this.produtoRepository.save(produto);
        return ResponseEntity.ok().body("Produto Cadastrado com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Produto produto
    ){
        this.produtoRepository.delete(produto);
        return ResponseEntity.ok().body("Produto Deletado com Sucesso");
    }


    @PutMapping("/{idProduto}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idProduto,
            @RequestBody final Produto produto
    ){
        if (idProduto.equals(produto.getId())) {
            this.produtoRepository.save(produto);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }

    private void produtoRepository(Produto produto) {
    }


}
