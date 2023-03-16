import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'cadastro', loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule) },
                        { path: "", redirectTo: "cadastro", pathMatch: "full"},
                        { path: 'inicio', loadChildren: () => import('./inicio/inicio.module').then(m => m.InicioModule) },
                        { path: 'validacaocad', loadChildren: () => import('./validacaocad/validacaocad.module').then(m => m.ValidacaocadModule) },
                        { path: 'telarecaptcha', loadChildren: () => import('./telarecaptcha/telarecaptcha.module').then(m => m.TelarecaptchaModule) }
                       ];
@NgModule({
  declarations: [],
  imports: [
    RouterModule.forRoot(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class AppRoutingModule { }
