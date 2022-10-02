package net.scm.sortegrande.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="tb_resultado_caixa")
public class ResultadoCaixa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Boolean acumulado;
    private String dataApuracao;
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "resultadoCaixa")
    private List<DezenasSorteadas> listaDezenas = new ArrayList<>();

    @OneToMany(mappedBy = "resultadoCaixa")
    private Set<RateioPremio> rateio_premio = new HashSet<>();

    public ResultadoCaixa() {}

    public ResultadoCaixa(Long id, Boolean acumulado, String dataApuracao) {
        this.id = id;
        this.acumulado = acumulado;
        this.dataApuracao = dataApuracao;
    }

    public Long getId() {
        return id;
    }

    public Boolean getAcumulado() {
        return acumulado;
    }

    public String getDataApuracao() {
        return dataApuracao;
    }

    public void setId(Long d) {
        this.id = id;
    }

    public void setAcumulado(Boolean acumulado) {
        this.acumulado = acumulado;
    }

    public void setDataApuracao(String dataApuracao) {
        this.dataApuracao = dataApuracao;
    }

    public Set<RateioPremio> getRateio_premio() {
        return rateio_premio;
    }

    public void setRateio_premio(Set<RateioPremio> rateio_premio) {
        this.rateio_premio = rateio_premio;
    }

    public List<DezenasSorteadas> getListaDezenas() {
        return listaDezenas;
    }

    public void setListaDezenas(List<DezenasSorteadas> listaDezenas) {
        this.listaDezenas = listaDezenas;
    }
}

