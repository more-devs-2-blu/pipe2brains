import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { CadastroRoutingModule } from './cadastro-routing.module';
import { CadastroComponent } from './cadastro.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { DataPipe } from './datapipe';


@NgModule({
  declarations: [
    CadastroComponent,
    DataPipe
  ],
  imports: [
    CommonModule,
    CadastroRoutingModule,
    FormsModule,
  ]
})
export class CadastroModule { }
