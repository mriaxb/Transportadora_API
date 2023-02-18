package br.com.uniamerica.transportadora.transportadoraapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_cidades", schema = "transportadora")
public class Cidade extends AbstractEntity{

    @Getter @Setter
    private String nome;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "estado", nullable = false)
    private Estado estado;


}
