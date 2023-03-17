import { Component, OnInit } from '@angular/core';
import { environment } from 'src/environments/environment';
import { CpfModel } from '../cadastro/cpfmodel';
import { FormModel } from '../cadastro/formmodel';
import { IptuViabilidadeModel } from '../cadastro/iptuviabilidade';
import { DataService } from '../data.service';
import { HttpIptuService } from '../httpiptu.service';
import { HttpMeiService } from '../httpmei.service';

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

  public estabelecerModel: IptuViabilidadeModel = {
    grupoNaturezaJur: '',
    naturezaJur: '',
    objConsulta: '',
    tipoEstabelecimento: '',
    cnaePrincipal: '',
    cpf: '',
    inscrCadIPTU: '',
    areaEmpreendimento: 0
  }

  public formModel: FormModel = {
    id:'',
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
    dataConsulta:''
  }

  constructor(
    private data: DataService,
    private httpIptuService: HttpIptuService,
    private httpMeiService: HttpMeiService,
  ) { }

  ngOnInit() {
    this.data.requisicaoAtual.subscribe(requisicao => this.formModel = requisicao);
    this.data.cpfAtual.subscribe(cpf => this.cpfModel = cpf);
    this.checaViabilidadeMei();
    this.putFormMei();
  }

  tornaElegivel(){
    this.formModel.statusConsultaMEI = true
  }

  //alterar as datas para tipo data e refazer essa verificacao usando a data atual do sistema
  public calculaIdade(nasc: string): number{
    return 2023 - (parseInt(nasc[4]+nasc[5]+nasc[6]+nasc[7])) 
  }

  putFormMei(){    
    this.httpMeiService.putRequest(this.formModel).subscribe((response) => {
      console.log('resposta do put');
      console.log(response);
    } )}
  
  public resultadoEstabelecer: string;  

  consultaEstabelecer(){
    this.estabelecerModel.cnaePrincipal = this.formModel.cnaePrimario;
    this.estabelecerModel.cpf = this.formModel.cpf;
    this.estabelecerModel.inscrCadIPTU = this.formModel.nrCadastroIPTU;
    this.estabelecerModel.areaEmpreendimento = this.formModel.areaEmpreend

    this.httpIptuService.postRequest(this.estabelecerModel).subscribe((response) => {
      this.resultadoEstabelecer = response;
      if (this.resultadoEstabelecer == '0'){this.formModel.statusConsultaIPTU = true}
      this.formModel.codStatusConsultaIPTU = parseInt(this.resultadoEstabelecer)
      this.putFormMei()
    })

  }

  checaViabilidadeMei(){
    if(
      this.cpfModel.situacao.codigo != '0' ||
      this.calculaIdade(this.formModel.dataNascimento) < environment.maxIdadePermitida ||
      this.formModel.eFuncPublico ||
      this.formModel.eSocio ||
      this.formModel.eMeiAtivo ||
      this.formModel.temFiliais ||
      !this.verificaFaturamento() ||
      !this.verificaCustos() ||
      this.formModel.nrFuncionarios > environment.maxFuncionarios
    ){
      this.formModel.statusConsultaMEI = false;
    } else {
      this.formModel.statusConsultaMEI = true;
    }
    this.data.setRequisicao(this.formModel)
  }

  verificaFaturamento():boolean{
    if(environment.cnaesTabelaB.includes(this.formModel.cnaePrimario)){
      if(this.formModel.previsaoFaturamento <= environment.maxFatTabelaB){
        return true;
      } else {
        return false;
      }
    } else {
      if(this.formModel.previsaoFaturamento <= environment.maxFatTabelaA){
        return true;
      } else {
        return false;
      }
    }
  }

  verificaCustos():boolean{
    if((this.formModel.previsaoCustos/this.formModel.previsaoFaturamento) < environment.maxPorcentagemCusto){
      return true;
    } else {
      return false;
    }
  }






}
