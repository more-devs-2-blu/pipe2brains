import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';

const routes: Routes = [{ path: 'cadastro', loadChildren: () => import('./cadastro/cadastro.module').then(m => m.CadastroModule) },
                        { path: "", redirectTo: "cadastro", pathMatch: "full"},
                        { path: 'inicio', loadChildren: () => import('./inicio/inicio.module').then(m => m.InicioModule) }
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
