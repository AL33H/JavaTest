package br.com.KotlinTest.dto

import lombok.Data
import java.time.LocalDate

@Data
class ResponseConsultaDTO {
    constructor(cepOrigem: String?, cepDestino: String?, vlTotalFrete: Double?, dataPrevistaEntrega: LocalDate?) {
        this.cepOrigem = cepOrigem
        this.cepDestino = cepDestino
        this.vlTotalFrete = vlTotalFrete
        this.dataPrevistaEntrega = dataPrevistaEntrega
    }

    var cepOrigem: String? = null
    var cepDestino: String? = null
    var dataPrevistaEntrega: LocalDate? = null
    var vlTotalFrete: Double? = null
}
