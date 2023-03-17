import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { TelarecaptchaComponent } from './telarecaptcha.component';

const routes: Routes = [{ path: '', component: TelarecaptchaComponent }];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class TelarecaptchaRoutingModule { }
