import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { TelarecaptchaRoutingModule } from './telarecaptcha-routing.module';
import { TelarecaptchaComponent } from './telarecaptcha.component';


@NgModule({
  declarations: [
    TelarecaptchaComponent
  ],
  imports: [
    CommonModule,
    TelarecaptchaRoutingModule
  ]
})
export class TelarecaptchaModule { }
