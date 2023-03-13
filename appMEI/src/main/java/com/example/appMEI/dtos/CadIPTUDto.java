//Estrutura do objeto CadIPTUDto
package com.example.appMEI.dtos;

import lombok.Data;
import java.util.ArrayList;

@Data
public class CadIPTUDto {
    private String cad;
    private ArrayList<String> cnaesProibidos;
    private boolean statusCadIPTU;

    public CadIPTUDto() {
    }

    public CadIPTUDto(String cad, ArrayList<String> cnaesProibidos, boolean statusCadIPTU) {
        this.cad = cad;
        this.cnaesProibidos = cnaesProibidos;
        this.statusCadIPTU = statusCadIPTU;
    }
}