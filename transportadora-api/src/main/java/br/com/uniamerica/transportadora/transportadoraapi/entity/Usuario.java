package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;


@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_usuarios", schema = "transportadora")
public class Usuario extends AbstractEntity{

    @Getter @Setter
    @Column(name = "precGanho", nullable = false)
    private BigDecimal percGanho;

    @Getter @Setter
    @Column(name = "login", length = 25, nullable = false, unique = true)
    private String login;

    @Getter @Setter
    @Column(name = "senha", length = 25, nullable = false)
    private String senha;

    @Getter @Setter
        @Enumerated(EnumType.STRING)
    @Column(name = "grupo", length = 25, nullable = false)
    private Grupo grupo;

    @Getter @Setter
    @Column(name = "nome_usuario", length = 40, nullable = false)
    private String nome;

    @Getter @Setter
    @Column(name = "cpf", length = 12, nullable = false)
    private String cpf;

    @Getter @Setter
    @Column(name = "telefone", length = 15, nullable = false)
    private String telefone;

    @Getter @Setter
    @Column(name = "endereco", length = 30,nullable = false)
    private String endereco;

    @Getter @Setter
    @Column(name = "data_de_nascimento")
    private LocalDateTime dataDeNascimento;

    @Getter @Setter
    @Column(name = "observacao", length = 200)
    private String observacao;


}

