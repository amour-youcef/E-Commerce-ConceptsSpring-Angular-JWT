import { Component, OnInit } from '@angular/core';
import { CatalogueService } from '../services/catalogue.service';
import { ActivatedRoute, Router, NavigationEnd } from '@angular/router';

@Component({
  selector: 'app-products',
  templateUrl: './products.component.html',
  styleUrls: ['./products.component.css']
})
export class ProductsComponent implements OnInit {
  products;
  constructor(public catService: CatalogueService,
              private route: ActivatedRoute,
              private router: Router ) {}

  ngOnInit(): void {
    this.router.events.subscribe((val) =>{
      if(val instanceof NavigationEnd){
        let url = val.url;
        console.log(url);
        let p1 = this.route.snapshot.params.p1;
        if (p1 == 1) {
          this.getProducts('/products/search/selectedProducts');
        } else if (p1 == 2) {
          let idCat = this.route.snapshot.params.p2;
          this.getProducts('/categories/' + idCat + '/products');
        }
      }
    });
  }

  private getProducts(url) {
    this.catService.getResource(this.catService.host + url)
      .subscribe(data => {
        this.products = data;
      }, err => {
        console.log(err);
      })
  }
}
