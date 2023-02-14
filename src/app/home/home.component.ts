
import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FoodService } from '../services/food/food.service';
import { Foods } from '../shared/models/food';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {
//  foods:string[]=[];
foods:Foods[]=[];
  constructor(private fs:FoodService,private routes:ActivatedRoute) { }

  ngOnInit(): void {
    this.routes.params.subscribe(params=>{
      console.log('enter into searchitem');
      if(params['searchItem'])
      
      this.foods=this.fs.getAll().filter(food=>food.name.toLowerCase().includes(params['searchItem'].toLowerCase()))

    //get particular data on basis of params
else if(params['tag'])
this.foods=this.fs.getAllFoodsByTag(params['tag']);
    else
    this.foods= this.fs.getAll();//all images strore inside foods array
    //this.foods= this.fs.getAll()//all images strore inside foods array
  })
  }
}
