import { Component, Input, OnInit } from '@angular/core';
import { Tag } from 'src/app/shared/models/Tag';
import { FoodService } from '../services/food/food.service';
@Component({
  selector: 'app-tags',
  templateUrl: './tags.component.html',
  styleUrls: ['./tags.component.css']
})
export class TagsComponent implements OnInit {
  @Input()//as a child to parent ,parent to child
  foodPageTags?:string[];

  @Input()//as a child to parent ,parent to child
  justifyContent:string='center';
tags?:Tag[]=[];
  constructor(private fs:FoodService) { }

  ngOnInit(): void {
    if(!this.foodPageTags)//if tag is not present then return all tags
    this.tags=this.fs.getAllTag();
  }

}
