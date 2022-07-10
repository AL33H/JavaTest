package br.com.KotlinTest.service

import br.com.KotlinTest.dto.CEP
import br.com.KotlinTest.dto.ConsultaDTO
import br.com.KotlinTest.dto.ResponseConsultaDTO
import br.com.KotlinTest.entity.ConsultaRealizada
import br.com.KotlinTest.repository.ConsultaRealizadaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.time.LocalDate


@Service
class ConsultaRealizadaService {

    @Autowired
    private val repository: ConsultaRealizadaRepository? = null

    @Autowired
    private lateinit var consultarCEP: ConsultarCepFeignClient;

    fun SalvarConsulta(consultaDTO: ConsultaDTO): ResponseConsultaDTO {

        val consultaRealizada: ConsultaRealizada = ConsultaDTOParaConsultaRealizada(consultaDTO);
        consultaRealizada.dataConsulta = LocalDate.now()
        consultaRealizada.vlTotalFrete = calcularValorTotalDoFrete(consultaDTO)
        consultaRealizada.dataPrevistaEntrega = calcularPrevisaoDeEntrega(consultaDTO, LocalDate.now());
        consultaRealizada.vlTotalFrete = calcularValorTotalDoFrete(consultaDTO)
        return ConsultaRealizadaParaResponseConsultaDTO(repository!!.save(consultaRealizada) as ConsultaRealizada)
    }

    fun ConsultaRealizadaParaResponseConsultaDTO(consultaRealizada: ConsultaRealizada): ResponseConsultaDTO {
        return ResponseConsultaDTO(
            consultaRealizada.cepOrigem,
            consultaRealizada.cepDestino,
            consultaRealizada.vlTotalFrete,
            consultaRealizada.dataPrevistaEntrega
        )
    }

    fun ConsultaDTOParaConsultaRealizada(consultaDTO: ConsultaDTO): ConsultaRealizada {
        return ConsultaRealizada(
            consultaDTO.cepOrigem,
            consultaDTO.cepDestino,
            consultaDTO.peso,
            consultaDTO.nomeDestinatario
        );
    }

    fun calcularValorTotalDoFrete(consultaDTO: ConsultaDTO): Double {
        val cepOrigem: CEP = consultarCEP.consultarCep(consultaDTO.cepOrigem.toString())
        val cepDestino: CEP = consultarCEP.consultarCep(consultaDTO.cepDestino.toString())
        return (consultaDTO.peso!! * CalcularDesconto(cepOrigem, cepDestino))
    }

    fun calcularPrevisaoDeEntrega(consultaDTO: ConsultaDTO, dataDaConsulta: LocalDate): LocalDate {
        val cepOrigem: CEP = consultarCEP.consultarCep(consultaDTO.cepOrigem.toString())
        val cepDestino: CEP = consultarCEP.consultarCep(consultaDTO.cepDestino.toString())
        val PrazoDeEntregaEmDias = calcularPrazoParaEntrega(cepOrigem, cepDestino)
        return dataDaConsulta.plusDays(PrazoDeEntregaEmDias)
    }

    fun CalcularDesconto(cepOrigem: CEP, cepDestino: CEP): Double {
        if (cepOrigem.uf == cepDestino.uf) {
            return 0.25
        }

        return if (cepOrigem.ddd == cepDestino.ddd) {
            0.5
        } else 1.0
    }

    fun calcularPrazoParaEntrega(cepOrigem: CEP, cepDestino: CEP): Long {
        if (cepOrigem.uf == cepDestino.uf) {
            return 1L
        }

        return if (cepOrigem.ddd == cepDestino.ddd) {
            3L
        } else 10L
    }
}