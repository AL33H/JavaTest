package br.com.KotlinTest.dto

import lombok.Data
import org.hibernate.validator.constraints.Range
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

@Data
class ConsultaDTO {

    var nomeDestinatario: @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(
        max = 55,
        message = "Nome deve conter menos de 55 caracteres"
    ) String? = null
    var cepOrigem: @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(
        min = 8,
        max = 8,
        message = "CEP deve conter 8 dígitos"
    ) String? = null
    var cepDestino: @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(
        min = 8,
        max = 8,
        message = "CEP deve conter 8 dígitos"
    ) String? = null
    var peso: @NotNull @Range(min = 0, message = "Peso não pode ser negativo!")
    Double? = null
}