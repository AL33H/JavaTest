package br.com.SigaBem.entities.DAO;

import br.com.SigaBem.dto.request.ConsultaDTO;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_consultas")
public class ConsultaRealizada {

    /*
                        ATTRIBUTES
     */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long Id;

    private String nomeDestinatario;
    private String cepOrigem;
    private String cepDestino;
    private Double peso;
    private Double vlTotalFrete;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataConsulta;

    /*
                        CONSTRUCTORS
     */

    public ConsultaRealizada() {
    }

    public ConsultaRealizada(long id, String nomeDestinatario, String cepOrigem, String cepDestino, Double peso, Double vlTotalFrete, LocalDate dataPrevistaEntrega, LocalDate dataConsulta) {
        Id = id;
        this.nomeDestinatario = nomeDestinatario;
        this.cepOrigem = cepOrigem;
        this.cepDestino = cepDestino;
        this.peso = peso;
        this.vlTotalFrete = vlTotalFrete;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.dataConsulta = dataConsulta;
    }

    /*
                        GETTER'S AND SETTER'S
     */

    public long getId() {
        return Id;
    }

    public void setId(long id) {
        Id = id;
    }

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

    public Double getVlTotalFrete() {
        return vlTotalFrete;
    }

    public void setVlTotalFrete(Double vlTotalFrete) {
        this.vlTotalFrete = vlTotalFrete;
    }

    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public LocalDate getDataConsulta() {
        return dataConsulta;
    }

    public void setDataConsulta(LocalDate dataConsulta) {
        this.dataConsulta = dataConsulta;
    }



    /*
                        METHODS
     */


}
