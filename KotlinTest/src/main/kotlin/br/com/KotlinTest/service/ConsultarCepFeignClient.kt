package br.com.KotlinTest.service

import br.com.KotlinTest.dto.CEP
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam


@FeignClient(value = "CEP", url = "https://viacep.com.br/ws/")
interface ConsultarCepFeignClient {

    @GetMapping("{cep}/json")
    fun consultarCep(@RequestParam("cep") cep: String): CEP
}

