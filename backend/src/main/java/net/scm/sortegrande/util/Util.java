package net.scm.sortegrande.util;

import net.scm.sortegrande.dto.RateioPremioDTO;
import net.scm.sortegrande.dto.ResultadoCaixaDTO;
import com.jayway.jsonpath.JsonPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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

        Set<RateioPremioDTO> rateioPremioDTOS = new HashSet<>();

        for (int i=0; i < rateio; i++) {
            RateioPremioDTO rateioPremioDTO = new RateioPremioDTO();

            String acertos = JsonPath.read(resultado, "$.data.prizes[" + i + "].name");
            Double valor = JsonPath.read(resultado, "$.data.prizes[" + i + "].prize");
            Integer numDeVencedor = JsonPath.read(resultado, "$.data.prizes[" + i + "].winners");

            rateioPremioDTO.setValorPremio(valor);
            rateioPremioDTO.setDescricaoFaixa(acertos);
            rateioPremioDTO.setNumeroDeGanhadores(numDeVencedor);

            rateioPremioDTOS.add(rateioPremioDTO);
        }

        resultadoCaixaDTO.setRateioPremio(rateioPremioDTOS);

        return resultadoCaixaDTO;
    }

    public static String getResultado(String concurso, String url, String token, String loteria, String tipo) {

        RestTemplate restTemplate = new RestTemplate();

        String uri = url + concurso + token;

        Map<String, String> params = new HashMap<String, String>();
        params.put(loteria, tipo);

        return Objects.requireNonNull(restTemplate.getForObject(uri, String.class, params));
    }
}

