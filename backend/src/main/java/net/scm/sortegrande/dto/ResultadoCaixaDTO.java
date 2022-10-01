package net.scm.sortegrande.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ResultadoCaixaDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String data;
    private Integer concurso;
    private List<Integer> dezenas;
    private Boolean temVencedor;
    private Set<RateioPremioDTO> rateioPremio = new HashSet<>();

    public ResultadoCaixaDTO() {}

    public ResultadoCaixaDTO(String data, Integer concurso, List<Integer> dezenas, Boolean temVencedor, Set<RateioPremioDTO> rateioPremio) {
        this.data = data;
        this.concurso = concurso;
        this.dezenas = dezenas;
        this.temVencedor = temVencedor;
        this.rateioPremio = rateioPremio;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Integer getConcurso() {
        return concurso;
    }

    public void setConcurso(Integer concurso) {
        this.concurso = concurso;
    }

    public List<Integer> getDezenas() {
        return dezenas;
    }

    public void setDezenas(List<Integer> dezenas) {
        this.dezenas = dezenas;
    }

    public Boolean getTemVencedor() {
        return temVencedor;
    }

    public void setTemVencedor(Boolean temVencedor) {
        this.temVencedor = temVencedor;
    }

    public Set<RateioPremioDTO> getRateioPremio() {
        return rateioPremio;
    }

    public void setRateioPremio(Set<RateioPremioDTO> rateioPremio) {
        this.rateioPremio = rateioPremio;
    }
}
