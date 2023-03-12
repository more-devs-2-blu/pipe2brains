package com.example.appMEI.services;

import com.example.appMEI.dtos.CPFDto;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutionException;

@Service
public class CPFService {

    public CPFDto getCpf(String id) throws ExecutionException, InterruptedException {
        CPFDto cpfDTO = new CPFDto();
        cpfDTO.setNi("123");
        cpfDTO.setNome("Juca");
        cpfDTO.setNascimento("12/12/1999");
        cpfDTO.setSituacao("Regular");
        cpfDTO.setNaturezaOcupacao("999");

        return cpfDTO;
    }
}
