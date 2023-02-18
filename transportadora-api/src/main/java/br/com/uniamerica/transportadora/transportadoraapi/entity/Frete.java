package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_fretes", schema = "transportadora")
public class Frete extends AbstractEntity{


    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "produto", nullable = false)
    private Produto produto;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "cidadeOrigem", nullable = false)
    private Cidade cidadeOrigem;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "cidadeDestino", nullable = false)
    private Cidade cidadeDestino;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "motorista", nullable = false)
    private Usuario motorista;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "caminhao")
    private Caminhao caminhao;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusFrete statusFrete;

    @Getter @Setter
    @Column(name = "quilometragem_inicial", nullable = true, scale = 1, precision = 6)
    private BigDecimal quilometragemIni;


    @Getter @Setter
    @Column(name = "quilometragem_final", nullable = true, scale = 1, precision = 6)
    private BigDecimal quilometragemFim;

    @Getter @Setter
    @Column(name = "total_bruto_recebido", nullable = true,scale = 3, precision = 6)
    private BigDecimal totalBrutoRecebido;

    @Getter @Setter
    @Column(name = "total_liquido_recebido", nullable = true, scale = 3, precision = 6)
    private BigDecimal totalLiquidoRecebido;

    @Getter @Setter
    @Column(name = "peso_inicial", scale = 3, precision = 6)
    private BigDecimal pesoInicial;

    @Getter @Setter
    @Column(name = "peso_final", nullable = true, scale = 2, precision = 5)
    private BigDecimal pesoFinal;

    @Getter @Setter
    @Column(name = "peso_final_transportado", nullable = true, scale = 2, precision = 5)
    private BigDecimal pesoFinalTransportado;

    @Getter @Setter
    @Column(name = "preco_tonelada", nullable = true, scale = 3, precision = 6)
    private BigDecimal precoTonelada;

    @Getter @Setter
    @Column(name = "observacao", length = 255, nullable = true)
    private String observacao;

}
