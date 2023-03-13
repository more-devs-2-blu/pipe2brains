// Serviços:
// 1) getListaCPF - retorna todos os objetos CPFDto na lista do tipo Listas
// 2) getCpf - retorna um objeto CPFDto identificado por niAux (cpf)
package com.example.appMEI.services;

import com.example.appMEI.classes.Listas;
import com.example.appMEI.dtos.CPFDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class CPFService {
    private Listas listas = new Listas();


    public List<CPFDto> getListaCpf() throws ExecutionException, InterruptedException {
       return listas.getListaCpf();
    }

    public CPFDto getCpf(String niAux) throws ExecutionException, InterruptedException {
        CPFDto cpfDTO = listas.buscaCpf(niAux);
        return cpfDTO;
    }
}