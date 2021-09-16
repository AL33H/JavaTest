package br.com.SigaBem.controllers;


import br.com.SigaBem.dto.request.ConsultaDTO;
import br.com.SigaBem.dto.response.ResponseConsultaDTO;
import br.com.SigaBem.services.ConsultaRealizadaService;
import br.com.SigaBem.util.ExceptionHandler.StandardError;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.annotations.Authorization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/consulta")
public class ConsultaRealizadaController {


    /*
                        CONSTRUCTOR
     */

    @Autowired
    private ConsultaRealizadaService service;

    /*
                        METHODS
     */


    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ResponseConsultaDTO> consultarEntrega(@Valid @RequestBody ConsultaDTO consultaDTO){
        return ResponseEntity.ok().body(service.SalvarConsulta(consultaDTO));
    }
}
