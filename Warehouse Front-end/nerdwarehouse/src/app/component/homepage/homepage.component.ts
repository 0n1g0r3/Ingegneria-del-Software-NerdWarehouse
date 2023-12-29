import { Component, OnDestroy, OnInit} from '@angular/core';
import { ProductService } from 'app/api/product.service';
import { ProductDto } from 'app/model/productDto';
import { Subscription } from 'rxjs';
import { Router } from '@angular/router';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomeComponent implements OnInit,OnDestroy{
  product: ProductDto[] = [];
  disableLoadMore = false;
  private productSubscription? : Subscription;

  constructor(private productService: ProductService,
              private router: Router) {}

  ngOnInit() : void {
    this.getAllProducts();
  }

  public getAllProducts() {
    // Call the getAll1 method from the ProductService
    this.productSubscription = this.productService.getAll('body').subscribe(
      (data: ProductDto[]) => {
        // Update your component property with the received data
        this.product = data;
        console.log(data)
      },
      (error) => {
        // Handle error as needed
        console.error('Error fetching products:', error);
      }
    );
  }

  cerca() {}

  loadMoreProduct(){}

  // Aggiungi le funzioni mancanti
  toggleSidenav() {
    // Implementa la logica per la funzione toggleSidenav
  }

  openCart() {
    this.router.navigate(['/cart']);
  }

  ngOnDestroy() : void{
    // Unsubscribe to avoid memory leaks
    if (this.productSubscription) {
      this.productSubscription.unsubscribe();
    }
  }

}

//array di productdto(model) e la funzione "getAll()" < la funzione this.arraydiproductdto = data

//e dopo nell'html ngfor che scorre la lista dei prodottidto che si chiama item e che mi metta tutto nel componente card <card-component nomeProdotto="item"></card-component>
//passare l'intero productDto

//Per far sì che si aspetti un input il componente card dentro il ts, @input nomeProdotto: ProductDto


