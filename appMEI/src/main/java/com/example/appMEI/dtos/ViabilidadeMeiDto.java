package com.example.appMEI.dtos;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ViabilidadeMeiDto {
    private String nome;                    //API CPF
    private String cpf;                     //API CPF
    private String statusCpf;               //API CPF
    private String dataNascimento;          //API CPF
    private String email;         //USUARIO
    private String telefone1;    //USUARIO
    private String telefone2;    //USUARIO

    private String cnaePrimario;  //USUARIO
    private String cnaePrimarioOcupacao;    //JSON ATIVIDADES MEI

    private boolean eFuncPublico;           //API CPF
    private boolean eSocio;                 //API CPF
    private boolean eMeiAtivo;              //API CPF

    private boolean temAposentadoriaInvalidez;  //USUARIO
    private boolean temAuxilioDoenca;           //USUARIO
    private boolean temSalarioMaternidade;      //USUARIO
    private boolean temSegDesemprego;           //USUARIO
    private boolean temBpcLoas;                 //USUARIO
    private boolean temProuni;                  //USUARIO
    private boolean temFies;                    //USUARIO
    private boolean temBolsaFamilia;            //USUARIO

    private boolean temFiliais;                 //USUARIO
    private long previsaoFaturamento; //USUARIO
    private long previsaoCustos;      //USUARIO
    private int nrFuncionarios;       //USUARIO

    private String nrCadastroIPTU;    //USUARIO
    private String enderecoIPTU;                //API VIABILIDADE PMB
    private Integer areaEmpreend;     //USUARIO

    private LocalDateTime dataConsulta;     //API VIABILIDADE MEI
    private boolean statusConsultaMEI;      //FORM
    private boolean statusConsultaIPTU;     //API VIABILIDADE PMB
    private Integer codStatusConsultaIPTU;   //API VIABILIDADE PMB
}
