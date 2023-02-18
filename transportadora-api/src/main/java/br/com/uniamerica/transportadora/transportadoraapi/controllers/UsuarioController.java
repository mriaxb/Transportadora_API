package br.com.uniamerica.transportadora.transportadoraapi.controllers;
import br.com.uniamerica.transportadora.transportadoraapi.entity.Usuario;

import br.com.uniamerica.transportadora.transportadoraapi.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/usuario")
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;


    @GetMapping
    public ResponseEntity<List<Usuario>> findAll()
    {
        return ResponseEntity.ok().body(this.usuarioRepository.findByUsuariosAtivos());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Usuario> findById(
            @RequestParam("id") final Long id
    ) {
        return ResponseEntity.ok().body(this.usuarioRepository.findById(id).orElse(new Usuario()));
    }

    @PostMapping
    public ResponseEntity<?> insert(
            @RequestBody Usuario usuario
    )
    {
        this.usuarioRepository.save(usuario);
        return ResponseEntity.ok().body("Usuario Cadastrado com Sucesso.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluir(
            @PathVariable final Long id,
            @RequestBody final Usuario usuario
    ){
        this.usuarioRepository.delete(usuario);
        return ResponseEntity.ok().body("Usuario Deletado com Sucesso");
    }


    @PutMapping("/{idUsuario}")
    public ResponseEntity<?> atualizar(
            @PathVariable final Long idUsuario,
            @RequestBody final Usuario usuario
    ){
        if (idUsuario.equals(usuario.getId())) {
            this.usuarioRepository.save(usuario);
        }
        else {
            return ResponseEntity.badRequest().body("id nao encontrado");
        }
        return ResponseEntity.ok().body("Registro atualizado com exito...");
    }


}
