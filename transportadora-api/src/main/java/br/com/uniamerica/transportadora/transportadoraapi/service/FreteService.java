package br.com.uniamerica.transportadora.transportadoraapi.service;

import br.com.uniamerica.transportadora.transportadoraapi.entity.Frete;
import br.com.uniamerica.transportadora.transportadoraapi.entity.StatusFrete;
import br.com.uniamerica.transportadora.transportadoraapi.repository.DespesaRepository;
import br.com.uniamerica.transportadora.transportadoraapi.repository.FreteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class FreteService {

    @Autowired
    public FreteRepository freteRepository;
    @Autowired
    private DespesaRepository despesaRepository;
    @Autowired
    private HistoricoFreteService historicoFreteService;

    public Frete findById(Long id) {
        return this.freteRepository.findById(id).orElse(new Frete());
    }

    @Transactional
    public void verificaCadastroFrete(Frete frete) {
        //validação do cadastro de frete
        if("".equals(frete.getProduto()) || "".equals(frete.getCidadeOrigem()) || "".equals(frete.getMotorista()) ||
                "".equals(frete.getCaminhao()) || "".equals(frete.getQuilometragemIni()) ||
                "".equals(frete.getQuilometragemFim())|| "".equals(frete.getTotalBrutoRecebido()) ||
                "".equals(frete.getTotalLiquidoRecebido()) ||
                "".equals(frete.getPesoFinal()) || "".equals(frete.getPesoInicial()) ||
                "".equals(frete.getPesoFinalTransportado()) ||
                "".equals(frete.getPrecoTonelada())
        ){
            throw new RuntimeException("Preencha todos os campos!");
        }
        else{
            throw  new RuntimeException("Cadastro realizado com sucesso!");
        }
    }

    @Transactional
    public void verificaUpdateFrete(Long idFrete, Frete frete) {
        //validação da edição de frete
        if("".equals(frete.getProduto()) || "".equals(frete.getCidadeOrigem()) || "".equals(frete.getMotorista()) ||
                "".equals(frete.getCaminhao()) || "".equals(frete.getQuilometragemIni()) ||
                "".equals(frete.getQuilometragemFim())|| "".equals(frete.getTotalBrutoRecebido()) ||
                "".equals(frete.getTotalLiquidoRecebido()) ||
                "".equals(frete.getPesoFinal()) || "".equals(frete.getPesoInicial()) ||
                "".equals(frete.getPesoFinalTransportado()) ||
                "".equals(frete.getPrecoTonelada())
        ){
            throw new RuntimeException("Preencha todos os campos!");
        }
        else{
            throw  new RuntimeException("Edição realizado com sucesso!");
        }
    }

    @Transactional
    public void atualizarStatusFaturado(final Long idFrete,final Frete frete ){
        final Frete freteCadastrado = this.freteRepository.findById(idFrete).orElseThrow();

        Assert.isTrue(frete.getStatusFrete().equals(StatusFrete.DESCARGA),
                "Não é possivel faturar um frete que não está com o status de descarga");

//        final List<Despesa> despesas = this.despesaRepository.findByFreteAndAprovadorIsNull(frete.getId());
//
//        Assert.isTrue(despesas.size() > 0,
//                "Não é possível faturar um frete com despesas abertas");


        freteCadastrado.setStatusFrete(StatusFrete.FATURADO);
        freteCadastrado.setPesoFinal(frete.getPesoFinal());
        freteCadastrado.setPesoFinalTransportado(frete.getPesoFinalTransportado());
        freteCadastrado.setQuilometragemFim(frete.getQuilometragemFim());
        freteCadastrado.setTotalBrutoRecebido(frete.getTotalBrutoRecebido());
        freteCadastrado.setTotalLiquidoRecebido(frete.getTotalLiquidoRecebido());

        this.freteRepository.save(freteCadastrado);

//        Assert.isTrue(frete == null && frete.getId() == null,
//                "não foi possível localizar o frete");

        //msm coisa q o Assert d cima
//        if(frete == null && frete.getId() == null){
//            throw new RuntimeException("Não foi possivel localizar o frete");
//        }

        this.historicoFreteService.cadastrar(frete, StatusFrete.FATURADO);
    }

    @Transactional
    public void atualizarStatusEmTransporte(final Long id, final Frete frete){
//        Assert.isTrue(frete == null || frete.getId() == null,
//                "Não foi possível localizar o frete informado.");
//
//        Assert.isTrue(!frete.getStatusFrete().equals(StatusFrete.INTERROMPIDO),
//                "Não é possível iniciar o transporte do frete, " +
//                "pois seu status é diferente de INTERROMPIDO.");

        final Frete freteCadastrado = this.freteRepository.findById(id).orElseThrow();

        freteCadastrado.setStatusFrete(StatusFrete.EM_TRANSPORTE);
        freteCadastrado.setPesoInicial(frete.getPesoInicial());
        freteCadastrado.setQuilometragemIni(frete.getQuilometragemIni());

        this.freteRepository.save(freteCadastrado);

//
//        if(id.equals(frete.getId()) && !this.freteRepository.findById(id).isEmpty()){
//            if(frete.getStatusFrete() == StatusFrete.CARGA){
//                frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
//                this.freteRepository.save(frete);
//            }
//        }else{
//            throw new RuntimeException("Frete nao encontrado");
//        }
//        this.historicoFreteService.cadastrar(frete, StatusFrete.EM_TRANSPORTE);
    }
//    @Transactional
//    public void atualizarStatusEmTransporte(final Long id){
//        if (id.equals(frete.getId()) && !this.freteRepository.findById(id).isEmpty()){
//            if (frete.getStatusFrete() == StatusFrete.CARGA){
//                frete.setStatusFrete(StatusFrete.EM_TRANSPORTE);
//                this.historicoFreteService.cadastrar(frete,StatusFrete.EM_TRANSPORTE);
//                this.freteRepository.save(frete);
//            }
//        }else{
//            throw new RuntimeException("Frete não encontrado");
//        }
//    }

    @Transactional
    public void atualizarStatusInterrompido(final Long idFrete, final Frete frete){

//        Assert.isTrue(frete == null && frete.getId() == null,
//                "não foi possível localizar o frete")

        final Frete freteCadastrado = this.freteRepository.findById(idFrete).orElseThrow();

        freteCadastrado.setStatusFrete(StatusFrete.INTERROMPIDO);
        freteCadastrado.setObservacao(frete.getObservacao());

        this.freteRepository.save(freteCadastrado);

        this.historicoFreteService.cadastrar(frete, StatusFrete.INTERROMPIDO);
    }

    @Transactional
    public void atualizarStatusCancelado(final Long idFrete, final Frete frete){
        final Frete freteCadastrado = this.freteRepository.findById(idFrete).orElseThrow();

        freteCadastrado.setStatusFrete(StatusFrete.CANCELADO);
        freteCadastrado.setObservacao(frete.getObservacao());

        this.freteRepository.save(freteCadastrado);

        this.historicoFreteService.cadastrar(frete, StatusFrete.CANCELADO);
    }

    @Transactional
    public void atualizarStatusDescarga(final Long idFrete, final Frete frete){
        final Frete freteCadastrado = this.freteRepository.findById(idFrete).orElseThrow();

        freteCadastrado.setStatusFrete(StatusFrete.DESCARGA);
        freteCadastrado.setObservacao(frete.getObservacao());

        this.freteRepository.save(freteCadastrado);

        this.historicoFreteService.cadastrar(frete, StatusFrete.DESCARGA);

    }
}
