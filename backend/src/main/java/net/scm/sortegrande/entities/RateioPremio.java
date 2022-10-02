package net.scm.sortegrande.entities;

import javax.persistence.*;

@Entity
@Table(name="tb_rateio_premio")
public class RateioPremio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descricaoFaixa;
    private Integer faixa;
    private Integer numeroDeGanhadores;
    private Double valorPremio;

    @ManyToOne
    @JoinColumn(name="resultado_caixa_id")
    private ResultadoCaixa resultadoCaixa;

    public RateioPremio() {}

    public RateioPremio(
            Long id, String descricaoFaixa, Integer faixa,
            Integer numeroDeGanhadores, Double valorPremio,
            ResultadoCaixa resultadoCaixa) {
        this.id = id;
        this.descricaoFaixa = descricaoFaixa;
        this.faixa = faixa;
        this.numeroDeGanhadores = numeroDeGanhadores;
        this.valorPremio = valorPremio;
        this.resultadoCaixa = resultadoCaixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricaoFaixa() {
        return descricaoFaixa;
    }

    public void setDescricaoFaixa(String descricaoFaixa) {
        this.descricaoFaixa = descricaoFaixa;
    }

    public Integer getFaixa() {
        return faixa;
    }

    public void setFaixa(Integer faixa) {
        this.faixa = faixa;
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

    public ResultadoCaixa getResultadoCaixa() {
        return resultadoCaixa;
    }

    public void setResultadoCaixa(ResultadoCaixa resultadoCaixa) {
        this.resultadoCaixa = resultadoCaixa;
    }
}
