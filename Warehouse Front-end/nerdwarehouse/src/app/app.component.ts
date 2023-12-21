// app.component.ts
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
  selector: 'app-root',
  template: `
    <router-outlet></router-outlet>
  `,
})
export class AppComponent implements OnInit {
  title = 'nerdwarehouse'; // Dichiarazione e inizializzazione della proprietà title

  constructor(private router: Router) {}

  ngOnInit() {
    // Implementa la tua logica di autenticazione qui
    // Ad esempio, reindirizza alla homepage se l'utente è autenticato, altrimenti a login
    if (this.isUserAuthenticated()) {
      this.router.navigate(['/homepage']);
    } else {
      this.router.navigate(['/login']);
    }
  }

  private isUserAuthenticated(): boolean {
    // Implementa la tua logica di autenticazione qui
    // Restituisce true se l'utente è autenticato, altrimenti false
    return false; // Modifica questa logica secondo le tue esigenze
  }
}
