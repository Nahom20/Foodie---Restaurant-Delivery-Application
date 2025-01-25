import { Component } from '@angular/core';
import { restaurant } from 'src/app/SharedData/models/resturant';
import { RestaurantService } from '../service/resturant.service';
import { Router } from '@angular/router';
import { min } from 'rxjs';

@Component({
  selector: 'app-resturant-listing',
  templateUrl: './resturant-listing.component.html',
  styleUrls: ['./resturant-listing.component.css']
})
export class ResturantListingComponent {

  public restaurantList:restaurant[];

  constructor(private router:Router, private resturnantservice:RestaurantService){}

  ngOnInit(){
    this.getAllResturants();
    console.log(this.restaurantList);
  }

  getAllResturants(){
    this.resturnantservice.getAllRestaurants().subscribe(
      data => {
        this.restaurantList = data;
      }
    )
  }

  getRandomNumber(min:number, max:number):number{
    return Math.floor(Math.random() * (max - min +1)) +min;
  }

  getRandomImage():string{
    const imageCount = 8;
    const randomIndex = this.getRandomNumber(1, imageCount);
    return `${randomIndex}.jpg`;
  }

  onButtonClick(id:number){
    this.router.navigate(['/foodcatalogue',id])
  }


   
}
