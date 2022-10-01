package net.scm.sortegrande.util;

import net.scm.sortegrande.dto.RateioPremioDTO;
import net.scm.sortegrande.dto.ResultadoCaixaDTO;
import com.jayway.jsonpath.JsonPath;
import org.springframework.web.client.RestTemplate;

import java.util.*;

public class Util {
    public static ResultadoCaixaDTO convertToResultado(String resultado) {
        ResultadoCaixaDTO resultadoCaixaDTO = new ResultadoCaixaDTO();

        String dataConcurso = JsonPath.read(resultado, "$.data.draw_date");
        Integer concurso = JsonPath.read(resultado, "$.data.draw_number");
        List<Integer> dezenas = JsonPath.read(resultado, "$.data.drawing.draw");
        Boolean temVencedor = JsonPath.read(resultado, "$.data.has_winner");

        resultadoCaixaDTO.setData(dataConcurso);
        resultadoCaixaDTO.setConcurso(concurso);
        resultadoCaixaDTO.setTemVencedor(temVencedor);
        resultadoCaixaDTO.setDezenas(dezenas);

        Object rateioPremio = JsonPath.read(resultado, "$.data.prizes");

        Integer rateio = JsonPath.read(resultado, "$.data.prizes.length()");

        System.out.println("Data do Concurso: " + dataConcurso);
        System.out.println("Num. do Concurso: " + concurso);
        System.out.println("Dezenas         : " + dezenas.toString());
        System.out.println("Tem Vencedor    : " + temVencedor);
        System.out.println("Rateio          : " + rateioPremio.toString());
        System.out.println("Num. Rateios    : " + rateio);

        Set<RateioPremioDTO> rateioPremioDTOS = new HashSet<>();

        for (int i=0; i < rateio; i++) {
            RateioPremioDTO rateioPremioDTO = new RateioPremioDTO();

            String acertos = JsonPath.read(resultado, "$.data.prizes[" + i + "].name");
            System.out.println("Acertos      : " + acertos);
            Double valor = JsonPath.read(resultado, "$.data.prizes[" + i + "].prize");
            System.out.println("Valor        : " + valor);
            Integer numDeVencedor = JsonPath.read(resultado, "$.data.prizes[" + i + "].winners");
            System.out.println("Vencedores   : " + numDeVencedor);

            rateioPremioDTO.setValorPremio(valor);
            rateioPremioDTO.setDescricaoFaixa(acertos);
            rateioPremioDTO.setNumeroDeGanhadores(numDeVencedor);

            rateioPremioDTOS.add(rateioPremioDTO);
        }

        resultadoCaixaDTO.setRateioPremio(rateioPremioDTOS);

        return resultadoCaixaDTO;
    }
}
