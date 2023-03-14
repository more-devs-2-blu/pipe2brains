import { Component } from '@angular/core';
import { FormControl, FormGroup, NgForm, NgModel } from '@angular/forms';
import cnaeImport from '../atividadesMEI.json';
import { Cnae } from '../cnae';
import { HttpCpfService } from '../httpcpf.service';
import { CpfModel } from './cpfmodel';
import { FormModel } from './formmodel';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {

  public cnaeList:Cnae[] = cnaeImport;
  public cnaeResultadoBusca: Cnae[] = this.cnaeList;
  public cpfAtual: CpfModel;

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
    private httpCpfService: HttpCpfService
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






  onSubmit(form: NgForm){

    console.log(this.formModel);

  }




}
