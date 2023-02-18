package br.com.uniamerica.transportadora.transportadoraapi.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_caminhoes", schema = "transportadora", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"placa", "id_modelo"})
})
public class Caminhao extends AbstractEntity{

    @Getter
    @Setter
    @Column(name = "placa", length = 8, nullable = false,unique = true)
    private String placa;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_modelo", nullable = false)
    private Modelo modelo;

    @Getter @Setter
    @Column(name = "ano", nullable = false, unique = true)
    private int ano;

    @Getter @Setter
    @Column(length = 9)
    @Enumerated(EnumType.STRING)
    private Cor cor;

    @Getter
    @Setter
    @Column(name = "observação", length = 200)
    private String observacao;


}
