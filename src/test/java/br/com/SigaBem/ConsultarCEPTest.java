package br.com.SigaBem;

import br.com.SigaBem.entities.CEP;
import br.com.SigaBem.controllers.ConsultarCEP;

import org.junit.jupiter.api.Test;


public class ConsultarCEPTest {

    @Test
    public void consultarCEPeRetornar200(){

     ConsultarCEP consultarCEP = new ConsultarCEP();

        CEP cep = consultarCEP.consultarCEP("62960000");


        System.out.println(cep.getCep());
        System.out.println(cep.getDdd());
        System.out.println(cep.getUf());


    }
}
