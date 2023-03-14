import { Component } from '@angular/core';
import cnaeImport from '../atividadesMEI.json';
import { Cnae } from '../cnae';
import { HttpCpfService } from '../httpcpf.service';
import { CpfModel } from './cpfmodel';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {

  public cnaeList:Cnae[] = cnaeImport;
  public cnaeResultadoBusca: Cnae[] = this.cnaeList;
  public cpfAtual: CpfModel;
 
  constructor(private httpCpfService: HttpCpfService) { }

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
      })
    }
  }


}
