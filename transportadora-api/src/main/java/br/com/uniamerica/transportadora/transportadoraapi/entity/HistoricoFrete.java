package br.com.uniamerica.transportadora.transportadoraapi.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_historico_fretes", schema = "transportadora")
public class HistoricoFrete extends AbstractEntity{

    @Getter @Setter
    private LocalDateTime data;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "frete", nullable = false)
    private Frete frete;

    @Getter @Setter
    @Enumerated(EnumType.STRING)
    private StatusFrete statusFrete;

    @Getter @Setter
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    @JoinColumn(name = "executor", nullable = false)
    private Usuario executor;

}
