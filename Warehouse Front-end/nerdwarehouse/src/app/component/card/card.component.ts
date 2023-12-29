import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { CartService } from 'app/api/cart.service';
import { NavigationService } from 'app/api/navigation.service';
import { ProductDto } from 'app/model/productDto';
import { CookieService } from 'ngx-cookie-service';
import { Router } from '@angular/router';
import { MatSnackBar } from '@angular/material/snack-bar';
@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent {

  productInTheCart: number | null = null;

  constructor(private cartService : CartService,
              private cookieService : CookieService,
              private navigationService : NavigationService,
              private router : Router,
              private snackBar : MatSnackBar) {

  }
 
  @Input() item?: ProductDto;

addToCart(): void {
  if (this.item) {
    const product: ProductDto = this.item;
    if (product.id !== undefined) {
      let cartItems: ProductDto[] = [];
      const cartItemsCookie = this.cookieService.get('cartItems');
      if (cartItemsCookie) {
        cartItems = JSON.parse(cartItemsCookie) as ProductDto[];
      }
      const existingProduct = cartItems.find(item => item.id === product.id);
      if (existingProduct) {
        this.snackBar.open("Prodotto già nel carrello", "OK");
      } else {
        cartItems.push(product);
      }
      this.cookieService.set('cartItems', JSON.stringify(cartItems), 1, '/');
    } else {
      this.snackBar.open("Prodotto non disponibile", "RIPROVA");
    }
  }
  console.log(this.cookieService.get('cartItems'));
}
}


      
      
      
      
      


