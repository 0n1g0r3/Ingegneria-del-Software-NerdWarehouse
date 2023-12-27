import { Component } from '@angular/core';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomeComponent {

}

//array di productdto(model) e la funzione "getAll()" < la funzione this.arraydiproductdto = data

//e dopo nell'html ngfor che scorre la lista dei prodottidto che si chiama item e che mi metta tutto nel componente card <card-component nomeProdotto="item"></card-component>
//passare l'intero productDto

//Per far sì che si aspetti un input il componente card dentro il ts, @input nomeProdotto: ProductDto


