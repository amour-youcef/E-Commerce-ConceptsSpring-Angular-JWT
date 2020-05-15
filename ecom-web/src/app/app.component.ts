import { Component, OnInit } from '@angular/core';
import { CatalogueService } from './catelogue.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'ecom-web';
  public categories;
  constructor(private catService: CatalogueService) {

  }
  ngOnInit(): void {
    this.getCategories();
  }
  private getCategories() {
    this.catService.getResource("/categories").subscribe(data => {
      this.categories = data;
    }, err => {
      console.log(err);
    })
  }

}
