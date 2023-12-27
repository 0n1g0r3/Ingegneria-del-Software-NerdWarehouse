import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from 'app/api/cart.service';
import { NavigationService } from 'app/api/navigation.service';
import { ProductDto } from 'app/model/productDto';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-card',
  templateUrl: './card.component.html',
  styleUrls: ['./card.component.css']
})
export class CardComponent implements OnInit {

  productInTheCart: number | null = null;
  isUserProduct = false;

  constructor(private http : HttpClient,
              private cartService : CartService,
              private cookieService : CookieService,
              private router : Router,
              private route : ActivatedRoute, 
              private navigationService : NavigationService) {

  }
  ngOnInit(): void {
    if (this.cookieService.get("role") == "MANU"){
      this.isUserProduct=true
    }
  }
  @Input() item: ProductDto | undefined;




  showProductDetails(productId : number) {
    const currentRoute = this.router.url;
    this.navigationService.setPreviousComponent(currentRoute);
    this.router.navigate(['/product',  productId ]);
  }

  addToCart(ID : number) {
    this.cartService.addToCart(ID);
    this.productInTheCart = ID;
    setTimeout(() => {
      this.productInTheCart = null;
    }, 1000);
  }
}

    
    
    
    
    


