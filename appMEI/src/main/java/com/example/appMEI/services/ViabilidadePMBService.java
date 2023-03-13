// Serviços:
// 1) getListaCadIPTU - retorna todos os objetos ViabilidadePMBDto na lista do tipo Listas
// 2) getCadIPTU - retorna um objeto ViabilidadePMBDto identificado por cadAux (cadastro IPTU)
// 3) consultaViabilidadePMB - recebe um objeto contendo todos os dados necessários para consulta de viabilidade
//                             e retorna um status 0, 1, 2 ou 3 de acordo com o resultado
package com.example.appMEI.services;

import com.example.appMEI.classes.Listas;
import com.example.appMEI.dtos.CadIPTUDto;
import com.example.appMEI.dtos.ViablidadePMBDto;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
public class ViabilidadePMBService {
    private Listas listas = new Listas();

    public List<CadIPTUDto> getListaCadIPTU() throws ExecutionException, InterruptedException {
       return listas.getListaCadIPTU();
    }

    public CadIPTUDto getCadIPTU(String cadAux) throws ExecutionException, InterruptedException {
        CadIPTUDto cadIPTUDto = listas.buscaCadIPTU(cadAux);
        return cadIPTUDto;
    }

    public Character consultaViabilidadePMB(ViablidadePMBDto viabilidadePMBDtoAux){
        CadIPTUDto cadIPTUDto = listas.buscaCadIPTU(viabilidadePMBDtoAux.getInscrCadIPTU());
        if (cadIPTUDto != null) {
            if (!cadIPTUDto.isStatusCadIPTU()) return '2';
            else if (cadIPTUDto.getCnaesProibidos().contains(viabilidadePMBDtoAux.getCnaePrincipal())) return '1';
                else return '0';
        }
        return '3';
    }
}