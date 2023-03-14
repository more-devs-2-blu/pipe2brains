import { Component } from '@angular/core';
import { FormControl, FormGroup, NgForm, NgModel } from '@angular/forms';
import cnaeImport from '../atividadesMEI.json';
import { Cnae } from '../cnae';
import { HttpCpfService } from '../httpcpf.service';
import { HttpIptuService } from '../httpiptu.service';
import { CpfModel } from './cpfmodel';
import { FormModel } from './formmodel';
import { IptuResponseModel } from './ipturesponse';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {

  public cnaeList:Cnae[] = cnaeImport;
  public cnaeResultadoBusca: Cnae[] = this.cnaeList;
  public cpfAtual: CpfModel;
  public iptuResponse: IptuResponseModel;

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
    areaEmpreendimento: 0,

    statusConsultaMEI:false,
    statusConsultaIPTU:false
  }
 

  constructor(
    private httpCpfService: HttpCpfService,
    private httpIptuService: HttpIptuService
    ) { }

  buscaCNAE(key: string){
    const results: Cnae[] = [];
    for(const cnae of this.cnaeList){
      if(cnae.ocupacao.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1 
      || cnae.cnae.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1) {
      results.push(cnae);
      }
    }
    this.cnaeResultadoBusca = results
  }

  getCPF(cpf:string) {    
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

  getIPTU(nrCadastroIPTU: string){
    nrCadastroIPTU = nrCadastroIPTU.replace(/[^0-9]/g, '');
    if (nrCadastroIPTU) {
      this.httpIptuService.getRequest(nrCadastroIPTU).subscribe((response) => {        
        this.iptuResponse = response;
        this.formModel.enderecoIPTU = this.iptuResponse.endereco;
        console.log(this.formModel);
        console.log(this.iptuResponse);
        
      })
    }
  }

  atribuiCnae(elem:any){

    this.formModel.cnaePrimario = elem.value
    this.formModel.cnaePrimarioOcupacao = elem.dataset.ocup
  }





  onSubmit(form: NgForm){
    

    console.log(this.formModel);

  }




}
