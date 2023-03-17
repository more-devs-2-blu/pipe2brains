export interface FormModel {
    id: string,
    nome:string,
    cpf:string,
    statusCpf:string,       //verificar
    dataNascimento:string,  //verificar
    email:string, 
    telefone1:string, 
    telefone2:string, 
    cnaePrimario:string, 
    cnaePrimarioOcupacao:string,

    eFuncPublico:boolean,               //verificar
    eSocio:boolean,                     //verificar
    eMeiAtivo:boolean,                  //verificar
    temAposentadoriaInvalidez:boolean,  //verificar (só alerta)
    temAuxilioDoenca:boolean,           //verificar (só alerta)
    temSalarioMaternidade:boolean,      //verificar (só alerta)
    temSegDesemprego:boolean,           //verificar (só alerta)
    temBpcLoas:boolean,                 //verificar (só alerta)
    temProuni:boolean,                  //verificar (só alerta)
    temFies:boolean,                    //verificar (só alerta)
    temBolsaFamilia:boolean,            //verificar (só alerta)
    temFiliais:boolean,                 //verificar

    previsaoFaturamento:number, //verificar
    previsaoCustos:number,      //verificar
    nrFuncionarios:number,      //verificar

    nrCadastroIPTU:string,
    enderecoIPTU:string,
    areaEmpreend: number,

    statusConsultaMEI:boolean,  //verificar - true se aprovado no MEI
    statusConsultaIPTU:boolean,  //verificar - altera status quando processou consulta pra estabelecer
    codStatusConsultaIPTU:number,

    dataConsulta:string
}