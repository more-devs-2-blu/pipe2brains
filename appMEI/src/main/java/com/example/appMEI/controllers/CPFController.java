package com.example.appMEI.controllers;

import com.example.appMEI.dtos.CPFDto;
import com.example.appMEI.services.CPFService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/consultacpf")
public class CPFController {
    public CPFService cpfService;

    public CPFController(CPFService cpfService){
        this.cpfService = cpfService;
    }

    /*@GetMapping("/")
    public List<TratamentoDTO> getTratamentos() throws ExecutionException, InterruptedException {
        return tratamentoService.getTratamentos();
    }*/

    @GetMapping("/{id}")
    public CPFDto getCpf(@PathVariable(value = "id") String id) throws InterruptedException, ExecutionException {
        return cpfService.getCpf(id);
    }
}
