// Estrutura do objeto SituacaoDTo complementar ao objeto CPFDto
package com.example.appMEI.dtos;

import lombok.Data;

@Data
public class SituacaoDto {
    private String codigo;
    private String descricao;
    public SituacaoDto() {}

    public SituacaoDto(String codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }
}