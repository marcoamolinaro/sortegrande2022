package net.scm.sortegrande.dto;

import java.io.Serializable;

public class RateioPremioDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String descricaoFaixa;
    private Integer numeroDeGanhadores;
    private Double valorPremio;

    public RateioPremioDTO() {}

    public RateioPremioDTO(String descricaoFaixa, Integer numeroDeGanhadores, Double valorPremio) {
        this.descricaoFaixa = descricaoFaixa;
        this.numeroDeGanhadores = numeroDeGanhadores;
        this.valorPremio = valorPremio;
    }

    public String getDescricaoFaixa() {
        return descricaoFaixa;
    }

    public void setDescricaoFaixa(String descricaoFaixa) {
        this.descricaoFaixa = descricaoFaixa;
    }

    public Integer getNumeroDeGanhadores() {
        return numeroDeGanhadores;
    }

    public void setNumeroDeGanhadores(Integer numeroDeGanhadores) {
        this.numeroDeGanhadores = numeroDeGanhadores;
    }

    public Double getValorPremio() {
        return valorPremio;
    }

    public void setValorPremio(Double valorPremio) {
        this.valorPremio = valorPremio;
    }
}
