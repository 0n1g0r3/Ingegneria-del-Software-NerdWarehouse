// app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/homepage/homepage.component';
import { LoginComponent } from './component/login/login.component';
import { RegistrationComponent } from './component/registration/registration.component'; // Assicurati di importare il componente di registrazione

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redirect alla rotta di login
  { path: 'login', component: LoginComponent },
  { path: 'homepage', component: HomeComponent },
  { path: 'registration', component: RegistrationComponent }, // Aggiungi questa riga per la rotta di registrazione
  // Altre rotte possono essere aggiunte qui, se necessario
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
