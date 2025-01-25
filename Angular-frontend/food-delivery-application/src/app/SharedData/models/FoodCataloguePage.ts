import { FoodItem } from "src/app/SharedData/models/Fooditem";
import { restaurant } from 'src/app/SharedData/models/resturant';

export interface FoodCataloguePage{
    foodItemList:FoodItem[];
    resturant:restaurant | null;
}