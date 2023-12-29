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

  //prodotto:ProductDto = {
    //available:false
  }

  /*constructor(private router: Router,
              private productService : ProductService,
              private cookieService : CookieService,
              private snackBar : MatSnackBar) {}     
    
  createInsertion(){
    const seller = this.cookieService.get("user")
    this.prodotto.userId = seller;
    console.log(this.cookieService.get("Token"))
    console.log(this.prodotto)
    if(this.acceptableProduct(this.prodotto)){
      this.productService.addProduct(this.prodotto,this.cookieService.get("Token")).subscribe(
        (response) = > {
          this.snackBar.open('Prodotto aggiunto con successo', 'Chiudi', { duration: 3000 });
          this.router.navigate(['/home']);)
        }
      )
    }
  }

  acceptableProduct(product : ProductDto) : boolean {
    if (
      product.title &&
      typeof product.price === 'number' &&
      product.price > 0 && product.price < 9999 &&
      product.description
    ) {
      return true;
    } else {
      return false;
    }
  }

}
*/