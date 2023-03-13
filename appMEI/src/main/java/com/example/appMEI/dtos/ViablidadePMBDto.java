// Estrutura do objeto ViabilidadePMBDto
package com.example.appMEI.dtos;

import lombok.Data;

@Data
public class ViablidadePMBDto {
    private String grupoNaturezaJur;
    private String naturezaJur;
    private String objConsulta;
    private String tipoEstabelecimento;
    private String cnaePrincipal;
    private String cpf;
    private String inscrCadIPTU;
    private String areaEmpreendimento;
}