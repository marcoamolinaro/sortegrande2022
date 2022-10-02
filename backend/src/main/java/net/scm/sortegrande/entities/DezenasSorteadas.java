package net.scm.sortegrande.entities;

import javax.persistence.*;

@Entity
@Table(name = "dezenas_sorteadas")
public class DezenasSorteadas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer dezena;

    @ManyToOne
    @JoinColumn(name = "resultado_caixa_id")
    private ResultadoCaixa resultadoCaixa;

    public ResultadoCaixa getResultadoCaixa() {
        return resultadoCaixa;
    }

    public void setResultadoCaixa(ResultadoCaixa resultadoCaixa) {
        this.resultadoCaixa = resultadoCaixa;
    }

    public DezenasSorteadas() {}

    public DezenasSorteadas(Long id, Integer dezena, ResultadoCaixa resultadoCaixa) {
        this.id = id;
        this.dezena = dezena;
        this.resultadoCaixa = resultadoCaixa;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getDezena() {
        return dezena;
    }

    public void setDezena(Integer dezena) {
        this.dezena = dezena;
    }
}