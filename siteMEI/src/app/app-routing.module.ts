import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'cadastro', loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule) },
                        { path: "", redirectTo: "cadastro", pathMatch: "full"},
                        { path: 'inicio', loadChildren: () => import('./inicio/inicio.module').then(m => m.InicioModule) },
                        { path: 'validacaocad', loadChildren: () => import('./validacaocad/validacaocad.module').then(m => m.ValidacaocadModule) },
                        { path: 'telarecaptcha', loadChildren: () => import('./telarecaptcha/telarecaptcha.module').then(m => m.TelarecaptchaModule) },
                        { path: 'sobre', loadChildren: () => import('./sobre/sobre.module').then(m => m.SobreModule) },
                        { path: 'contato', loadChildren: () => import('./contato/contato.module').then(m => m.ContatoModule) },
                        { path: 'newsletter', loadChildren: () => import('./newsletter/newsletter.module').then(m => m.NewsletterModule) }
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
