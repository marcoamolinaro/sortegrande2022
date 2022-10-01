package net.scm.sortegrande.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.scm.sortegrande.dto.RateioPremioDTO;
import net.scm.sortegrande.dto.ResultadoCaixaDTO;
import net.scm.sortegrande.util.Util;
import org.json.JSONArray;
import org.springframework.boot.json.JsonParser;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping(value = "/resultados")
public class ResultadoCaixaController {

    @GetMapping
    public ResponseEntity<ResultadoCaixaDTO> getResultadoCaixa() {
        RestTemplate restTemplate = new RestTemplate();

        String loteria = "lotofacil";

        String uri = "https://www.lotodicas.com.br/api/v2/lotofacil/results/last?token=9107f866eb008e1a8df6b06f6f935582787a357a39d3606ef1ac7d63d1d0a642";

        Map<String, String> params = new HashMap<String, String>();
        params.put("loteria", loteria);

        String resultado = Objects.requireNonNull(restTemplate.getForObject(uri, String.class, params));

        ResultadoCaixaDTO resultadoCaixaDTO = Util.convertToResultado(resultado);

        return ResponseEntity.ok().body(resultadoCaixaDTO);
    }
}
