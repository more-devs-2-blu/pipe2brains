export interface CpfModel {
    ni: string,
    nome: string,
    situacao: {
        codigo: string,
        descricao: string
    },
    nascimento: string,
    naturezaOcupacao: string
}