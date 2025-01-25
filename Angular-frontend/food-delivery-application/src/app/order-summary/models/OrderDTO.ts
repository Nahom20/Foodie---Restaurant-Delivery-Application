import { FoodItem } from "src/app/SharedData/models/Fooditem";
import { restaurant } from "src/app/SharedData/models/resturant";


export interface OrderDTO {
    foodItemList:FoodItem[];
    resturant:restaurant;
    userid: number;
}