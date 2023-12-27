import { Component } from '@angular/core';
import { AuthService } from 'app/api/auth.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {


  loginMail?: string ;
  password?: string ;


  constructor(private cookieService:CookieService, private authService: AuthService) {}


  login(){
    if (!this.loginMail || !this.password) {
      console.error('Email e password sono obbligatori.');
      
    }

    const loginData = {
      email: this.loginMail!,
      password: this.password!
    };

    this.authService.login(loginData).subscribe(
      (data) => {
      
        this.cookieService.set("userId", data.userId) 
        // Gestisci la risposta di successo
        console.log('Login avvenuto con successo:', data);
        // Salva eventuali dati di autenticazione nel cookie o altrove
        // Esempio: this.cookieService.set('authToken', data.token);
      },
      (error) => {
        // Gestisci gli errori durante il login
        console.error('Errore durante il login:', error);
      }
    );
  }
}

//userId?: string = this.cookieService.get("userId")
//Number(userId)
