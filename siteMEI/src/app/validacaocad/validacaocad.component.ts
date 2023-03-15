import { Component, OnInit } from '@angular/core';
import { FormModel } from '../cadastro/formmodel';
import { DataService } from '../data.service';

@Component({
  selector: 'app-validacaocad',
  templateUrl: './validacaocad.component.html',
  styleUrls: ['./validacaocad.component.css']
})
export class ValidacaocadComponent implements OnInit {

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
    statusConsultaIPTU: false
  }

  constructor(
    private data: DataService
  ) { }

  ngOnInit() {
    this.data.requisicaoAtual.subscribe(requisicao => this.formModel = requisicao)
  }

}
