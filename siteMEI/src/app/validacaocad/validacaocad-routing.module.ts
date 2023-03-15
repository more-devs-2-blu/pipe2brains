import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ValidacaocadComponent } from './validacaocad.component';

const routes: Routes = [{ path: '', component: ValidacaocadComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ValidacaocadRoutingModule { }
