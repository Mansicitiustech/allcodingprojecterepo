import { Injectable } from '@angular/core';
import { Foods } from 'src/app/shared/models/food';
import { Tag } from 'src/app/shared/models/Tag';
@Injectable({
  providedIn: 'root'
})
export class FoodService {

  constructor() { }

  //get all image
  /*getAll():string[]{
    return[
      '/assets/images/food1.jpg',
      '/assets/images/food2.jpg',
      '/assets/images/aalu paratha.jpg',
      '/assets/images/samosa.jpg',
      '/assets/images/dhokla.jpg',
      '/assets/images/burger.jpg',
      '/assets/images/pizza.jpg',
      '/assets/images/poha.jpg',
     // '/assets/images/dossa.jpg',
    ]
  }*/
  getAll():Foods[]{
    return [{
      id:1,
      name:'paneer',
      price:10,
      cookTime:'40-60',
      favorite:false,
      origins:['burger','indian'],
      star:5,
      imageUrl:'/assets/images/food1.jpg',
      tags:['fry'],

    },
    {
      id:2,
      name:'pasta',
      price:20,
      cookTime: '40-50',
      favorite:false,
      origins:['poha'],
      star:4,
      imageUrl:'/assets/images/food2.jpg',
      tags:['yummy'],

    },
    {
      id:3,
      name:'aalu-paratha',
      price:13,
      cookTime: '50-70',
      favorite:false,
      origins:['poha,pasta'],
      star:3,
      imageUrl:'/assets/images/aalu paratha.jpg',
      tags:['fastFood'],

    },

    
    {
      id:4,
      name:'samosa',
      price:23,
      cookTime: '70-80',
      favorite:false,
      origins:['indian'],
      star:5,
      imageUrl:'/assets/images/samosa.jpg',
      tags:['lunch'],

    },
    {
      id:5,
      name:'khamad dhokla',
      price:13,
      cookTime: '30-70',
      favorite:false,
      origins:['gujrati'],
      star:5,
     // imageUrl:'/assets/images/aalu dhokla.jpg',
     imageUrl:'/assets/images/dhokla.jpg',
      tags:['fry'],

    },


    {
      id:6,
      name:'burger',
      price:30,
      cookTime: '47-60',
      favorite:false,
      origins:['western'],
      star:5,
      imageUrl:'/assets/images/burger.jpg',
      tags:['lunch'],

    },
    {
      id:7,
      name:'pizza',
      price:20,
      cookTime: '45-50',
      favorite:false,
      origins:['indian'],
      star:4,
      imageUrl:'/assets/images/pizza.jpg',
      tags:['lunch'],

    },
    {
      id:8,
      name:'poha',
      price:10,
      cookTime: '30-50',
      favorite:true,
      origins:['indian'],
      star:5,
      imageUrl:'/assets/images/poha.jpg',
      tags:['burger'],

    },
  ]
  }
  getAllFoodsByTag(tag:string) :Foods[]{
    if(tag=='all')
    return this.getAll();
    else
    return this.getAll().filter(food=>food.tags?.includes(tag))
    //other way
    /*return tag=='all'?this.getAll():return this.getAll().filter(food=>food.tags?.includes(tag))
  */}
  getAllTag():Tag[]{
    console.log('get all tags')
    return [
      {name:'all',count:8},
      {name:'fastFood',count:1},
      {name:'lunch',count:3,
    },
    {name:'fry',count:2},
    {name:'burger',count:1},
    {name:'yummy',count:1},
    ];
    
    //here we work based on tags
  }
  getFoodById(id:number):Foods{
    return this.getAll().find(food=>food.id==id)!
  }
}
