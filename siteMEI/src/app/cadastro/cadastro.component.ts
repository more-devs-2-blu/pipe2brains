import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import cnaeImport from '../atividadesMEI.json';
import { Cnae } from '../cnae';
import { DataService } from '../data.service';
import { HttpCpfService } from '../httpcpf.service';
import { HttpIptuService } from '../httpiptu.service';
import { HttpMeiService } from '../httpmei.service';
import { CpfModel } from './cpfmodel';
import { FormModel } from './formmodel';
import { IptuResponseModel } from './ipturesponse';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent implements OnInit {

  public cnaeList: Cnae[] = cnaeImport;
  public cnaeResultadoBusca: Cnae[] = this.cnaeList;
  public iptuResponse: IptuResponseModel;

  public cpfAtual: CpfModel = {
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
    id: '',
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
    codStatusConsultaIPTU: 9,
    dataConsulta: ''
  }

  constructor(
    private httpCpfService: HttpCpfService,
    private httpIptuService: HttpIptuService,
    private httpMeiService: HttpMeiService,
    private data: DataService,
    private router: Router
  ) { }

  ngOnInit() {
    this.data.requisicaoAtual.subscribe(requisicao => this.formModel = requisicao)
  }

  buscaCNAE(key: string) {
    const results: Cnae[] = [];
    for (const cnae of this.cnaeList) {
      if (cnae.ocupacao.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1
        || cnae.cnae.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1) {
        results.push(cnae);
      }
    }
    this.cnaeResultadoBusca = results
  }

  getCPF(cpf: string) {
    cpf = cpf.replace(/[^0-9]/g, '')

    if (cpf) {
      this.httpCpfService.getRequest(cpf).subscribe((response) => {
        this.cpfAtual = response;
        this.formModel.nome = this.cpfAtual.nome;
        this.formModel.dataNascimento = this.cpfAtual.nascimento;
        this.formModel.statusCpf = this.cpfAtual.situacao.descricao;
        this.formModel.cpf = cpf;
      })
    }
  }

  getIPTU(nrCadastroIPTU: string) {
    nrCadastroIPTU = nrCadastroIPTU.replace(/[^0-9]/g, '');
    if (nrCadastroIPTU) {
      this.httpIptuService.getRequest(nrCadastroIPTU).subscribe((response) => {
        this.iptuResponse = response;
        this.formModel.enderecoIPTU = this.iptuResponse.endereco;
      })
    }
  }

  postMEI(formModel: FormModel) {
    this.httpMeiService.postRequest(formModel).subscribe((response) => {
      console.log('resposta do post');
      console.log(response);

      this.formModel.id = response.id
      this.formModel.dataConsulta = response.dataConsulta
      this.router.navigate(['/validacaocad'])

      if (response.id) {
        alert('Cadastro enviado com sucesso!')
      }
    })
    this.data.setRequisicao(this.formModel)
  }

  atribuiCnae(elem: any) {
    this.formModel.cnaePrimario = elem.value
    this.formModel.cnaePrimarioOcupacao = elem.dataset.ocup
  }

  onSubmit() {
    this.data.setCpf(this.cpfAtual)
    this.postMEI(this.formModel)
  }

  // funcionalidade de carousel

  public slideAtivo: number = 1;

  nextButtonClick() {
    if (this.slideAtivo < 1 || this.slideAtivo > 5) { return }
    if (this.slideAtivo != 5) { this.slideAtivo++; }
    var allSlides = document.querySelectorAll('.slide')

    var slideAtivar = document.getElementById(`slide-${this.slideAtivo}`)
    allSlides.forEach(element => {
      element.classList.add('slide-hidden')
    });
    slideAtivar?.classList.remove('slide-hidden')
  }

  prevButtonClick() {
    if (this.slideAtivo < 1 || this.slideAtivo > 5) { return }
    if (this.slideAtivo != 1) { this.slideAtivo--; }

    var allSlides = document.querySelectorAll('.slide')

    var slideAtivar = document.getElementById(`slide-${this.slideAtivo}`)
    allSlides.forEach(element => {
      element.classList.add('slide-hidden')
    });
    slideAtivar?.classList.remove('slide-hidden')
  }

}
