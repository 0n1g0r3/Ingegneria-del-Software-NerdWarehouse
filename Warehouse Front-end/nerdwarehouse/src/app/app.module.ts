import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './component/homepage/homepage.component';
import { LoginComponent } from './component/login/login.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { RegistrationComponent } from './component/registration/registration.component';
import { AuthService } from './api/auth.service';
import { CookieService } from 'ngx-cookie-service';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';
import { UserService } from './api/user.service';
import { ProductService } from './api/product.service';
import { OrderService } from './api/order.service';
import { CardComponent } from './component/card/card.component';
import { MatButtonModule } from "@angular/material/button";
import { MatToolbarModule } from "@angular/material/toolbar";
import { MatIconModule } from "@angular/material/icon";
import { MatSidenavModule } from "@angular/material/sidenav";
import { MatListModule } from "@angular/material/list";
import { MatGridListModule } from "@angular/material/grid-list";
import { MatCardModule } from "@angular/material/card";
import { MatInputModule } from "@angular/material/input"; // Aggiunto modulo per la barra di ricerca
import { MatFormFieldModule } from "@angular/material/form-field";
import { CartComponent } from './component/cart/cart.component';
import { AddProductComponent } from './component/add-product/add-product.component'; // Aggiunto modulo per la barra di ricerca

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegistrationComponent,
    CardComponent,
    CartComponent,
    AddProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    MatIconModule,
    HttpClientModule,
    MatSidenavModule,
    FormsModule,
    MatIconModule,
    MatToolbarModule,
    MatButtonModule,
    MatListModule,
    MatGridListModule,
    MatCardModule,
    MatInputModule, // Aggiunto modulo per la barra di ricerca
    MatFormFieldModule // Aggiunto modulo per la barra di ricerca
  ],
  providers: [AuthService, CookieService, UserService, ProductService, OrderService],
  bootstrap: [AppComponent]
})
export class AppModule { }
