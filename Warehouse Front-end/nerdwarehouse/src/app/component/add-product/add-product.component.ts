import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductService } from 'app/api/product.service';
import { ProductDto } from 'app/model/productDto';
import { CookieService } from 'ngx-cookie-service';
import { UserDto } from 'app/model/userDto';
import { UserService } from 'app/api/user.service';
import {MatSnackBar} from "@angular/material/snack-bar";

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent{

  prodotto:ProductDto = {
    available:true}
  

  constructor(private router: Router,
              private productService : ProductService,
              private cookieService : CookieService,
              private snackBar : MatSnackBar) {}     

    creaInserzione() {
      const seller = this.cookieService.get("userId");
      this.prodotto.userId = Number(seller);
      console.log(this.prodotto);
      if(this.productIsValid(this.prodotto)){
        this.productService.addProduct(this.prodotto).subscribe(
          (response) => {
            console.log(response)
            this.snackBar.open('Prodotto aggiunto con successo', 'Chiudi', { duration: 3000 });
            this.router.navigate(['/homepage']);
          }
        );
      }
    }
    
    productIsValid(product: ProductDto): boolean {
      if (product.title && typeof product.price === 'number' && product.price > 0 && product.price < 10000 && product.description)  return true; 
      else  return false;
    }
  }
              