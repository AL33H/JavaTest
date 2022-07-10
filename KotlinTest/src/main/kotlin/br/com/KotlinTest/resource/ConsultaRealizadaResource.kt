package br.com.KotlinTest.resource

import br.com.KotlinTest.dto.ConsultaDTO
import br.com.KotlinTest.dto.ResponseConsultaDTO
import br.com.KotlinTest.service.ConsultaRealizadaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RestController
@RequestMapping("buscar")
class ConsultaRealizadaResource {

    @Autowired
    private lateinit var consultarCepService: ConsultaRealizadaService

    @GetMapping()
    fun consultarCep(@RequestBody consultaDTO: @Valid ConsultaDTO?): ResponseEntity<ResponseConsultaDTO> {
        val salvarConsulta = consultarCepService.SalvarConsulta(consultaDTO!!)
        return ResponseEntity.ok().body(salvarConsulta)
    }
}
