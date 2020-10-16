import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { FoodService } from '../food.service';

@Component({
  selector: 'app-item-edit',
  templateUrl: './item-edit.component.html',
  styleUrls: ['./item-edit.component.css']
})
export class ItemEditComponent implements OnInit {
  menuItem: any = {
    id : null,
    name : null,
    price : null,
    active : null,
    dateOfLaunch : null,
    category : null,
    freeDelivery : null,
    image : null 
  };
  menuItemList: any;
  categoryBox: any;
  constructor(private activatedRouter: ActivatedRoute, private foodService: FoodService,private router : Router) { }

  ngOnInit() {
    this.categoryBox = this.foodService.getCategory();
      this.activatedRouter.paramMap.subscribe(params => {
        this.foodService.editMenuItem(params.get('id')).subscribe((data) => {
          this.menuItem = data;
        }); 
      });
  }
  launchDate(date: string){
    let dateArray: string[] = date.split("/");
    let newDate: string = dateArray[1] + "-" + dateArray[0] + "-" + dateArray[2];
    this.menuItem.dateOfLaunch = new Date(newDate);
  }
  update(menuItem: any) {
    this.foodService.update(menuItem).subscribe((data) => {
      this.menuItem = data;
    });
    this.router.navigate(['edit-item-status']);
  }
}
