// Rota: /consultaviabilidadepmb
// Opções: GET - / - Retorna lista com todos os cadastros de IPTU contidos no objeto Listas
//         GET - /(cadiptu) - Retorna objeto contendo os dados de IPTU de um registro pelo nr de cadastro
//         POST - / - Envia objeto json contendo dados necessário para consulta de viabilidade e retorna:
//              1 - Viabilidade OK
//              2 - Atividade não permitida no local
//              3 - Cadastro com restrição
//              4 - Cadastro inválido
package com.example.appMEI.controllers;

import com.example.appMEI.dtos.CadIPTUDto;
import com.example.appMEI.dtos.ViablidadePMBDto;
import com.example.appMEI.services.ViabilidadePMBService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/consultaviabilidadepmb")
public class ViabilidadePMBController {
    public ViabilidadePMBService viabilidadePMBService;

    public ViabilidadePMBController(ViabilidadePMBService viabilidadePMBService){
        this.viabilidadePMBService = viabilidadePMBService;
    }

    @PostMapping("/")
    public Character consultaViabilidadePMB(@RequestBody ViablidadePMBDto viabilidadePMBDto) throws InterruptedException, ExecutionException {
        return viabilidadePMBService.consultaViabilidadePMB(viabilidadePMBDto);
    }

    @GetMapping("/")
    public List<CadIPTUDto> getListaCadIPTU() throws ExecutionException, InterruptedException {
        return viabilidadePMBService.getListaCadIPTU();
    }

    @GetMapping("/{cadiptu}")
    public CadIPTUDto getCadIPTU(@PathVariable(value = "cadiptu") String cadAux) throws InterruptedException, ExecutionException {
        return viabilidadePMBService.getCadIPTU(cadAux);
    }
}