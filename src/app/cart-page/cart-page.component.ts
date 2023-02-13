import { Component, OnInit } from '@angular/core';
import { CartService } from '../services/cart.service';
import { FoodService } from '../services/food/food.service';
import { Cart } from '../shared/models/Cart';
import { CartItem } from '../shared/models/CartItem';

@Component({
  selector: 'app-cart-page',
  templateUrl: './cart-page.component.html',
  styleUrls: ['./cart-page.component.css']
})
export class CartPageComponent implements OnInit {
cart!:Cart
items!:CartItem

  constructor(private cartService:CartService,private fs:FoodService ) { 
    this.setCart();
   /* let foods=this.fs.getAll();
    cartService.addToCart(foods[1])
    cartService.addToCart(foods[3])
    cartService.addToCart(foods[5])//add temporary data in cart*/
  }


  ngOnInit(): void {
  }
setCart(){
this.cart=this.cartService.getCart();
}
removeFromCart(cartItem:CartItem){
this.cartService.removeFromCart(cartItem.food.id);
this.setCart();//instance loading data
}
changeQuantity(cartItem:CartItem,quantityInString:string){
  const quantity=parseInt(quantityInString);
this.cartService.changeQuantity(cartItem.food.id,quantity)
this.setCart();
}
}
