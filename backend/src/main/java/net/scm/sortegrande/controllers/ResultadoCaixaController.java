package net.scm.sortegrande.controllers;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.scm.sortegrande.dto.RateioPremioDTO;
import net.scm.sortegrande.dto.ResultadoCaixaDTO;
import net.scm.sortegrande.util.Util;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.json.JsonParser;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@RestController
@RequestMapping(value = "/resultados")
public class ResultadoCaixaController {

    @Autowired
    private Environment env;

    @GetMapping
    public ResponseEntity<ResultadoCaixaDTO> getResultadoCaixa() {

        String url_resultados = env.getProperty("user.url_resultados");
        String token = env.getProperty("user.url_token");
        String loteria = env.getProperty("user.loteria");
        String tipo_loteria = env.getProperty("user.tipo_loteria");

        String resultado = Util.getResultado("last", url_resultados, token, loteria, tipo_loteria);

        ResultadoCaixaDTO resultadoCaixaDTO =
                Util.convertToResultado(resultado);

        return ResponseEntity.ok().body(resultadoCaixaDTO);
    }


}
