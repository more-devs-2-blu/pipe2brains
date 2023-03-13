//Estrutura do objeto CPFDto
package com.example.appMEI.dtos;

import lombok.Data;

@Data
public class CPFDto {
    private String ni;
    private String nome;
    private SituacaoDto situacao;
    private String nascimento;
    private String naturezaOcupacao;

    public CPFDto() {
    }

    public CPFDto(String ni, String nome, SituacaoDto situacao, String nascimento, String naturezaOcupacao) {
        this.ni = ni;
        this.nome = nome;
        this.situacao = situacao;
        this.nascimento = nascimento;
        this.naturezaOcupacao = naturezaOcupacao;
    }
}