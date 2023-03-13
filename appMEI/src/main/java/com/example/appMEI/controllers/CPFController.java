// Rota: /consultacpf
// Opções: / - Retorna lista com todos os dados dos individuo contidos no objeto Listas
//         /(cpf) - Retorna objeto contendo os dados de um individuo por CPF
package com.example.appMEI.controllers;

import com.example.appMEI.dtos.CPFDto;
import com.example.appMEI.services.CPFService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/consultacpf")
public class CPFController {
    public CPFService cpfService;

    public CPFController(CPFService cpfService){
        this.cpfService = cpfService;
    }

    @GetMapping("/")
    public List<CPFDto> getListaCpf() throws ExecutionException, InterruptedException {
        return cpfService.getListaCpf();
    }

    @GetMapping("/{cpf}")
    public CPFDto getCpf(@PathVariable(value = "cpf") String niAux) throws InterruptedException, ExecutionException {
        return cpfService.getCpf(niAux);
    }
}