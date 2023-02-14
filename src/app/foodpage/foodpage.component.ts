import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartService } from '../services/cart.service';
import { FoodService } from '../services/food/food.service';
import { Foods } from '../shared/models/food';

@Component({
  selector: 'app-foodpage',
  templateUrl: './foodpage.component.html',
  styleUrls: ['./foodpage.component.css']
})
export class FoodpageComponent implements OnInit {
food!:Foods;
  constructor(private fs:FoodService,private route:ActivatedRoute,
    private cartService:CartService,
    private router:Router) { 
    route.params.subscribe(params=>{
      if(params['id'])
      this.food=
    fs.getFoodById(params['id'])})
  }

  ngOnInit(): void {
  }
addToCart(){
  this.cartService.addToCart(this.food)
  this.router.navigateByUrl('/cart-page')
}
}
