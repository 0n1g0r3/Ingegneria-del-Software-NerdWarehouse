// app-routing.module.ts
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomeComponent } from './component/homepage/homepage.component';
import { LoginComponent } from './component/login/login.component';
import { RegistrationComponent } from './component/registration/registration.component'; // Assicurati di importare il componente di registrazione
import { CartComponent } from './component/cart/cart.component';
import { AddProductComponent } from './component/add-product/add-product.component';

const routes: Routes = [
  { path: '', redirectTo: '/login', pathMatch: 'full' }, // Redirect alla rotta di login
  { path: 'login', component: LoginComponent },
  { path: 'homepage', component: HomeComponent },
  { path: 'registration', component: RegistrationComponent }, // Aggiungi questa riga per la rotta di registrazione
  { path: 'cart', component: CartComponent},
  { path: 'add', component: AddProductComponent}
  // Altre rotte possono essere aggiunte qui, se necessario
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
