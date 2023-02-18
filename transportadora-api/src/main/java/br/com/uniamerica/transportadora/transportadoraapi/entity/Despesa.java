package br.com.uniamerica.transportadora.transportadoraapi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "tb_despesas", schema = "transportadora")
public class Despesa extends AbstractEntity{


    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_tipoDespesa", nullable = false)
    private TipoDespesa tipoDespesa;

    @Getter @Setter
    @Column(name = "valor", nullable = false, scale = 3, precision = 6)
    private BigDecimal valor;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_motorista", nullable = false)
    private Usuario motorista;

    @Getter @Setter
    @Column(name = "data")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss" )
    private LocalDateTime data;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_aprovador", nullable = true)
    private Usuario aprovador;

    @Getter @Setter
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_frete")
    private Frete frete;



}
