import { Component } from '@angular/core';
import { UserService } from 'app/api/user.service';
import { NewUserDto } from 'app/model/newUserDto';

@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent {
  user : NewUserDto = {
    email : "", 
    password : "",
    firstname : "",
    lastname : ""
  }

  constructor(private userService : UserService) {}

  
  registrazione(){
    this.userService.addUser(this.user).subscribe(
      (data) => { 
        // Gestisci la risposta di successo
        console.log('Registrazione avvenuta con successo:', data);
        // Salva eventuali dati di autenticazione nel cookie o altrove
        // Esempio: this.cookieService.set('authToken', data.token);
      },
      (error) => {
        // Gestisci gli errori durante il login
        console.error('Errore durante la Registrazione:', error);
      }
    );
  }

}
