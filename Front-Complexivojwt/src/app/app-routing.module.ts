import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ListadoUsuariosComponent } from './Components/listado-usuarios/listado-usuarios.component';
import { LoginComponent } from './Components/login/login.component';

const routes: Routes = [
  { path: 'login', component: LoginComponent },
  { path: 'listar', component: ListadoUsuariosComponent },

  //{ path: '**', pathMatch: 'full', redirectTo: 'login' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
