import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { CartService } from 'app/api/cart.service';
import { NavigationService } from 'app/api/navigation.service';
import { ProductDto } from 'app/model/productDto';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  productInTheCart: number | null = null;

  constructor(private cartService : CartService,
              private cookieService : CookieService,
              private navigationService : NavigationService) {

  }
 
  @Input() item: ProductDto | undefined;



  addToCart(ID? : number) {
    if (ID !== undefined){
      this.cartService.addToCart(ID);
      this.productInTheCart = ID;
      setTimeout(() => {
        this.productInTheCart = null;
      }, 1000);
    }
  }
}

    
    
    
    
    


