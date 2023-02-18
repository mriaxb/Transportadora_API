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
@Table(name = "tb_marcas", schema = "transportadora")
public class Marca extends AbstractEntity{

    @Getter @Setter
    @Column(name = "marca", length = 20, nullable = false)
    private String marca;


}
