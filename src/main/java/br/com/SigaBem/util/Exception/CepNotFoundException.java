package br.com.SigaBem.util.Exception;

public class CepNotFoundException extends RuntimeException{
    public CepNotFoundException(String cep) {
        super("CEP: "+cep+" inválido");
    }
}
