import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodItemService } from '../service/fooditem.service';
import { FoodCataloguePage } from 'src/app/SharedData/models/FoodCataloguePage';
import { FoodItem } from 'src/app/SharedData/models/Fooditem';



@Component({
  selector: 'app-food-catalogue',
  templateUrl: './food-catalogue.component.html',
  styleUrls: ['./food-catalogue.component.css']
})
export class FoodCatalogueComponent {
  restaurantId: number;
  foodItemResponse: FoodCataloguePage;
  foodItemCart: FoodItem[] = [];
  orderSummary: FoodCataloguePage;


  constructor(private route: ActivatedRoute, private foodItemService: FoodItemService, private router: Router) {
  }

  ngOnInit() {

    this.route.paramMap.subscribe(params => {
      this.restaurantId = +params.get('id')! || 0;
    });


    this.getFoodItemsByRestaurant(this.restaurantId);

    
  }

  getFoodItemsByRestaurant(restaurant: number) {
    this.foodItemService.getFoodItemsByRestaurant(restaurant).subscribe(
      data => {
        console.log("data rep "+ data);
        this.foodItemResponse = data;
        console.log("foodresponse rep "+ this.foodItemResponse.foodItemList);
        console.log("Order Summary (structured):", JSON.stringify(this.foodItemResponse.foodItemList, null, 1));

      }
    )
  }

  increment(food: any) {
    food.quantity++;
    const index = this.foodItemCart.findIndex(item => item.id === food.id);
    if (index === -1) {
      // If record does not exist, add it to the array
      this.foodItemCart.push(food);
    } else {
      // If record exists, update it in the array
      this.foodItemCart[index] = food;
    }
  }

  decrement(food: any) {
    if (food.quantity > 0) {
      food.quantity--;

      const index = this.foodItemCart.findIndex(item => item.id === food.id);
      if (this.foodItemCart[index].quantity == 0) {
        this.foodItemCart.splice(index, 1);
      } else {
        // If record exists, update it in the array
        this.foodItemCart[index] = food;
      }

    }
  }

  onCheckOut() {
    this.orderSummary = {
      foodItemList: this.foodItemCart || [],
      resturant: this.foodItemResponse?.resturant || null
    };
  
    console.log("📤 Sending order summary:", this.orderSummary); // Debugging log
  
    this.router.navigate(['/orderSummary'], {
      state: { obj: this.orderSummary }
    });
  }
  
  
}
