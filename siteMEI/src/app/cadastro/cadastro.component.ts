import { Component } from '@angular/core';
import cnaeImport from '../atividadesMEI.json';
import { Cnae } from '../cnae';

@Component({
  selector: 'app-cadastro',
  templateUrl: './cadastro.component.html',
  styleUrls: ['./cadastro.component.css']
})
export class CadastroComponent {

  public cnaeList:Cnae[] = cnaeImport;
  public cnaeResultadoBusca: Cnae[] = this.cnaeList;
  public cnaeResultadoBusca2: Cnae[] = this.cnaeList;

  buscaCnae1(key: string){
    this.cnaeResultadoBusca = this.buscaCNAE(key)
  }

  buscaCNAE(key: string): Cnae[]{
    const results: Cnae[] = [];
    for(const cnae of this.cnaeList){
      if(cnae.ocupacao.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1 
      || cnae.cnae.toLocaleLowerCase().indexOf(key.toLocaleLowerCase()) != -1) {
      results.push(cnae);
      }
    }
    return results;
  }

  preencheEndComl(checkbox:any){
    if(checkbox.checked){
      // document.getElementById('#enderecoEmpCep')!.value = document.getElementById('#enderecoResCep')!.value
      console.log(document.getElementById('#enderecoEmpCep'));
      



    }
    
  }


}
