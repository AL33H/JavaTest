package br.com.SigaBem.controllers;

import br.com.SigaBem.entities.CEP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
public class ConsultarCEP {

    public CEP consultarCEP(String cep){
        RestTemplate template = new RestTemplate();

        UriComponents uri = UriComponentsBuilder.newInstance()
                .scheme("https")
                .host("viacep.com.br")
                .path("ws/"+cep+"/json")
                .build();

        ResponseEntity<CEP> response = template.getForEntity(uri.toUriString(), CEP.class);

        return response.getBody();
    }

}
