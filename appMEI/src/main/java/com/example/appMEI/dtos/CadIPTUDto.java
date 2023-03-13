//Estrutura do objeto CadIPTUDto
package com.example.appMEI.dtos;

import lombok.Data;
import java.util.ArrayList;

@Data
public class CadIPTUDto {
    private String cad;
    private ArrayList<String> cnaesProibidos;
    private String endereco;
    private boolean statusCadIPTU;

    public CadIPTUDto() {
    }

    public CadIPTUDto(String cad, ArrayList<String> cnaesProibidos, String endereco, boolean statusCadIPTU) {
        this.cad = cad;
        this.cnaesProibidos = cnaesProibidos;
        this.endereco = endereco;
        this.statusCadIPTU = statusCadIPTU;
    }
}