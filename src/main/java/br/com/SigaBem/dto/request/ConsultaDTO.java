package br.com.SigaBem.dto.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ConsultaDTO {

    /*
                        ATTRIBUTES
     */

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(max = 25, message = "Nome deve conter menos de 25 caracteres")
    private String nomeDestinatario;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(min = 8, max = 8, message = "CEP deve conter 8 dígitos")
    private String cepOrigem;

    @NotEmpty(message = "Preenchimento obrigatório!")
    @Size(min = 8, max = 8, message = "CEP deve conter 8 dígitos")
    private String cepDestino;

    @NotNull
    private Double peso;

    /*
                        CONSTRUCTORS
     */

    public ConsultaDTO() {
    }

    public ConsultaDTO(String nomeDestinatario, String cepOrigem, String cepDestino, Double peso) {
        this.nomeDestinatario = nomeDestinatario;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.peso = peso;
    }

    /*
                        GETTER'S AND SETTER'S
     */

    public String getNomeDestinatario() {
        return nomeDestinatario;
    }

    public void setNomeDestinatario(String nomeDestinatario) {
        this.nomeDestinatario = nomeDestinatario;
    }

    public String getCepOrigem() {
        return cepOrigem;
    }

    public void setCepOrigem(String cepOrigem) {
        this.cepOrigem = cepOrigem;
    }

    public String getCepDestino() {
        return cepDestino;
    }

    public void setCepDestino(String cepDestino) {
        this.cepDestino = cepDestino;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }
}
