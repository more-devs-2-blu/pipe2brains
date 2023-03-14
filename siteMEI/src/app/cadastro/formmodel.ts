export interface FormModel {
    nome:string,
    cpf:string,
    statusCpf:string, 
    dataNascimento:string,
    email:string,
    telefone1:string,
    telefone2:string,
    cnaePrimario:string,
    cnaePrimarioOcupacao:string,

    eFuncPublico:boolean,
    eSocio:boolean,
    eMeiAtivo:boolean,
    temAposentadoriaInvalidez:boolean,
    temAuxilioDoenca:boolean,
    temSalarioMaternidade:boolean,
    temSegDesemprego:boolean,
    temBpcLoas:boolean,
    temProuni:boolean,
    temFies:boolean,
    temBolsaFamilia:boolean,
    temFiliais:boolean,

    previsaoFaturamento:number,
    previsaoCustos:number,
    nrFuncionarios:number,

    nrCadastroIPTU:string,
    enderecoIPTU:string,
    areaEmpreendimento: number,

    statusConsultaMEI:boolean,
    statusConsultaIPTU:boolean
}