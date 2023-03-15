import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { CpfModel } from './cadastro/cpfmodel';
import { FormModel } from './cadastro/formmodel';

@Injectable({
  providedIn: 'root'
})
export class DataService {

  public cpfModel: CpfModel = {
    ni: "",
    nome: "",
    situacao: {
        codigo: "",
        descricao: ""
    },
    nascimento: "",
    naturezaOcupacao: ""
  }

  public formModel: FormModel = {
    nome:'',
    cpf:'',
    statusCpf:'', 
    dataNascimento:'',
    email:'',
    telefone1:'',
    telefone2:'',
    cnaePrimario:'',
    cnaePrimarioOcupacao:'',

    eFuncPublico:false,
    eSocio:false,
    eMeiAtivo:false,
    temAposentadoriaInvalidez:false,
    temAuxilioDoenca:false,
    temSalarioMaternidade:false,
    temSegDesemprego:false,
    temBpcLoas:false,
    temProuni:false,
    temFies:false,
    temBolsaFamilia:false,
    temFiliais:false,

    previsaoFaturamento:0,
    previsaoCustos:0,
    nrFuncionarios:0,

    nrCadastroIPTU:'',
    enderecoIPTU:'',
    areaEmpreend: 0,

    statusConsultaMEI:false,
    statusConsultaIPTU:false,
    codStatusConsultaIPTU: 9
  }

  private requisicao = new BehaviorSubject<FormModel>(this.formModel);
  requisicaoAtual = this.requisicao.asObservable();

  private cpf = new BehaviorSubject<CpfModel>(this.cpfModel);
  cpfAtual = this.cpf.asObservable();

  constructor() {}

  setRequisicao(req: FormModel) {
    this.requisicao.next(req);
  }

  setCpf(cpf: CpfModel){
    this.cpf.next(cpf);
  }
}
