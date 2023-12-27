// login.component.ts

import { Component } from '@angular/core';
import { Router } from '@angular/router'; // Importa il servizio Router
import { AuthService } from 'app/api/auth.service';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent {

  loginMail?: string;
  password?: string;

  constructor(private cookieService: CookieService, private authService: AuthService, private router: Router) {}

  login() {
    if (!this.loginMail || !this.password) {
      console.error('Email e password sono obbligatori.');
      return;
    }

    const loginData = {
      email: this.loginMail!,
      password: this.password!
    };

    this.authService.login(loginData).subscribe(
      (data) => {
        this.cookieService.set('userId', data.userId);
        // Gestisci la risposta di successo

        console.log('Login avvenuto con successo:', data);
        
        // Reindirizza alla homepage dopo il login
        this.router.navigate(['/homepage']);
        console.log('Reindirizzamento alla Homepage avvenuto con successo');
      },
      (error) => {
        // Gestisci gli errori durante il login
        console.error('Errore durante il login:', error);
      }
    );
  }
}
