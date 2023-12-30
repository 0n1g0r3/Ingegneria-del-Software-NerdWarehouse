import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import { Router } from '@angular/router';
import { OrderService } from 'app/api/order.service';
import { ProductService } from 'app/api/product.service';
import { OrderDto } from 'app/model/orderDto';
import { ProductDto } from 'app/model/productDto';
import { CookieService } from 'ngx-cookie-service';
import { Observable } from 'rxjs';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit{

  product: any[] = [];
  cartProduct?: ProductDto[];
  ordineCreato = false;
  totalCost = 0;
  orderSuccess = false;
  orderError = false;
  areProduct: Boolean = false;
  loadedProducts: ProductDto[] = [];
  order?: OrderDto;


 constructor(
   private cookieService: CookieService,
   private productService: ProductService,
   private router: Router,
   private orderService: OrderService,
   private snackBar: MatSnackBar
  ) {}

 ngOnInit(): void {
   const cartItemsCookie = this.cookieService.get('cartItems');
   if (cartItemsCookie) {
     this.cartProduct = JSON.parse(cartItemsCookie);
     if (this.cartProduct!.length > 0) {
       this.areProduct = true;
     }
   
    }
 }

 removeProductFromCart(productId: number): void {
   if (this.cartProduct) {
     const index = this.cartProduct.findIndex(item => item.id === productId);
     if (index !== -1) {
       this.cartProduct.splice(index, 1);
     }
   }
   this.productService.getById(Number(productId)).subscribe((data: ProductDto) => {
     const productPrice = data.price ?? 0;
     this.totalCost -= productPrice;
   });

 }


 private saveCartItems(cartItems: { product_id: number }[]): void {
   this.cookieService.delete('cartItems', '/');
   const updatedCartItems = cartItems.map(item => ({product_id: item.product_id}));
   this.cookieService.set('cartItems', JSON.stringify(updatedCartItems), 1, '/');
 }

 createOrder(): void {
   if (this.cartProduct!.length === 0) {
     this.snackBar.open("Nessun prodotto nel carrello..." , "OK")
     
     return;
   }

   this.order = {
     totalPrice: this.totalCost,
     paymentMethod: "card",
     productDtoList:this.cartProduct,
     userId: Number(this.cookieService.get('userId'))
   }


   this.orderService.addOrder(this.order!).subscribe((response) => {
       this.snackBar.open("Ordine creato, controlla nel tuo profilo.", "OK")
       this.cookieService.delete('cartItems', '/');
       this.cartProduct = []
       this.router.navigate(['/homepage'])
     },
     (error) => {
       this.snackBar.open("Errore durante la creazione dell ordine." , "RIPROVA")
     }
   );
   {
     this.snackBar.open("Errore durante la creazione dell ordine." , "RIPROVA")
   }


 }

getproductId(){
  let lista: number[] = [];  // Inizializza l'array vuoto qui
  this.product.forEach((cartItem) => {
    lista.push(cartItem.product_id);
  });
  return lista;
}

}
