package br.com.SigaBem.services;


import br.com.SigaBem.dto.request.ConsultaDTO;
import br.com.SigaBem.dto.response.ResponseConsultaDTO;
import br.com.SigaBem.entities.CEP;
import br.com.SigaBem.entities.DAO.ConsultaRealizada;
import br.com.SigaBem.repository.ConsultaRealizadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.Objects;

@Service
public class ConsultaRealizadaService {

    @Autowired
    private ConsultaRealizadaRepository repository;

    @Autowired
    private ConsultarCEP consultarCEP;



    public ResponseConsultaDTO SalvarConsulta(ConsultaDTO consultaDTO) {

            ConsultaRealizada consultaRealizada = ConsultaDTOParaConsultaRealizada(consultaDTO);

            consultaRealizada.setDataConsulta(LocalDate.now());

            consultaRealizada.setVlTotalFrete(calcularValorTotalDoFrete(consultaDTO));

            consultaRealizada.setDataPrevistaEntrega(calcularPrevisaoDeEntrega(consultaDTO, consultaRealizada.getDataConsulta()));

            return ConsultaRealizadaParaResponseConsultaDTO((ConsultaRealizada) repository.save(consultaRealizada));
    }

    public ResponseConsultaDTO ConsultaRealizadaParaResponseConsultaDTO(ConsultaRealizada consultaRealizada){
        ResponseConsultaDTO responseConsultaDTO = new ResponseConsultaDTO();

        responseConsultaDTO.setCepOrigem(consultaRealizada.getCepOrigem());
        responseConsultaDTO.setCepDestino(consultaRealizada.getCepDestino());
        responseConsultaDTO.setVlTotalFrete(consultaRealizada.getVlTotalFrete());
        responseConsultaDTO.setDataPrevistaEntrega(consultaRealizada.getDataPrevistaEntrega());

        return responseConsultaDTO;
    }

    public ConsultaRealizada ConsultaDTOParaConsultaRealizada(ConsultaDTO consultaDTO){
       ConsultaRealizada consultaRealizada = new ConsultaRealizada();

       consultaRealizada.setNomeDestinatario(consultaDTO.getNomeDestinatario());
       consultaRealizada.setCepOrigem(consultaDTO.getCepOrigem());
       consultaRealizada.setCepDestino(consultaDTO.getCepDestino());
       consultaRealizada.setPeso(consultaDTO.getPeso());

        return consultaRealizada;
   }

    public Double calcularValorTotalDoFrete(ConsultaDTO consultaDTO){
        CEP cepOrigem = consultarCEP.consultarCEP(consultaDTO.getCepOrigem());
        CEP cepDestino = consultarCEP.consultarCEP(consultaDTO.getCepDestino());

        return consultaDTO.getPeso() * CalcularDesconto(cepOrigem, cepDestino);
    }

    public LocalDate calcularPrevisaoDeEntrega(ConsultaDTO consultaDTO, LocalDate dataDaConsulta){

        CEP cepOrigem = consultarCEP.consultarCEP(consultaDTO.getCepOrigem());
        CEP cepDestino = consultarCEP.consultarCEP(consultaDTO.getCepDestino());
        Long PrazoDeEntregaEmDias = calcularPrazoParaEntrega(cepOrigem, cepDestino);

        return dataDaConsulta.plusDays(PrazoDeEntregaEmDias);
    }

    public Double CalcularDesconto(CEP cepOrigem, CEP cepDestino){

        //Verifica se Uf são iguais, desconto de 75%
        if(Objects.equals(cepOrigem.getUf(), cepDestino.getUf())){
            return 0.25;
        }

       //Verifica se DDD são iguais, desconto de 50%
        if(Objects.equals(cepOrigem.getDdd(), cepDestino.getDdd())){
            return 0.5;
        }

        return 1.0;
    }

    public Long calcularPrazoParaEntrega(CEP cepOrigem, CEP cepDestino){

        //Verifica se Uf são iguais, prazo de 1 dia
        if(Objects.equals(cepOrigem.getUf(), cepDestino.getUf())){
            return 1L;
        }

        //Verifica se DDD são iguais, prazo de 3 dias
        if(Objects.equals(cepOrigem.getDdd(), cepDestino.getDdd())){
            return 3L;
        }

        return 10L;
    }
}
