import { Component, OnInit } from '@angular/core';
import { CpfModel } from '../cadastro/cpfmodel';
import { FormModel } from '../cadastro/formmodel';
import { DataService } from '../data.service';

@Component({
  selector: 'app-validacaocad',
  templateUrl: './validacaocad.component.html',
  styleUrls: ['./validacaocad.component.css']
})
export class ValidacaocadComponent implements OnInit {

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
    nome: '',
    cpf: '',
    statusCpf: '',
    dataNascimento: '',
    email: '',
    telefone1: '',
    telefone2: '',
    cnaePrimario: '',
    cnaePrimarioOcupacao: '',

    eFuncPublico: false,
    eSocio: false,
    eMeiAtivo: false,
    temAposentadoriaInvalidez: false,
    temAuxilioDoenca: false,
    temSalarioMaternidade: false,
    temSegDesemprego: false,
    temBpcLoas: false,
    temProuni: false,
    temFies: false,
    temBolsaFamilia: false,
    temFiliais: false,

    previsaoFaturamento: 0,
    previsaoCustos: 0,
    nrFuncionarios: 0,

    nrCadastroIPTU: '',
    enderecoIPTU: '',
    areaEmpreend: 0,

    statusConsultaMEI: false,
    statusConsultaIPTU: false,
    codStatusConsultaIPTU: 9
  }

  constructor(
    private data: DataService
  ) { }

  ngOnInit() {
    this.data.requisicaoAtual.subscribe(requisicao => this.formModel = requisicao);
    this.data.cpfAtual.subscribe(cpf => this.cpfModel = cpf);
  }

  //alterar as datas para tipo data e refazer essa verificacao usando a data atual do sistema
  public calculaIdade(nasc: string): number{
    return 2023 - (parseInt(nasc[4]+nasc[5]+nasc[6]+nasc[7])) 
  }
  
  verificaFaturamento():boolean{
    if(
      this.formModel.cnaePrimario == '4930-2/01' || 
      this.formModel.cnaePrimario == '4930-2/02' ||
      this.formModel.cnaePrimario == '4930-2/03' ||
      this.formModel.cnaePrimario == '4930-2/04'
    ){
      if(this.formModel.previsaoFaturamento <= 251600){
        return true;
      } else {
        return false;
      }
    } else {
      if(this.formModel.previsaoFaturamento <= 81000){
        return true;
      } else {
        return false;
      }
    }
  }

  verificaCustos():boolean{
    if((this.formModel.previsaoCustos/this.formModel.previsaoFaturamento) < 0.8){
      return true;
    } else {
      return false;
    }
  }






}
