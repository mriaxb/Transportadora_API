package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_tipo_de_despesas", schema = "transportadora")
public class TipoDespesa extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "nome_despesa", length = 30)
    private String nome;

}
