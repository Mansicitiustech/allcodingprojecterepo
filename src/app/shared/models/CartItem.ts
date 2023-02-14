//import { FoodService } from "src/app/services/food/food.service";
import { Foods } from "./food";

export class CartItem{
    food:Foods;
    quantity:number=1;//initial we get one cart
   // price!: number;

   /* getPrice():Number{
        return this.food.price * this.quantity;
    }*/
  
     //other way
    get price():number{
        return this.food.price * this.quantity;
    }
    
    constructor( food:Foods){
        this.food=food;
    // this.price
       
       
       // this.getPrice();
        //this.price;//other way

    }
}