import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { MenuItem } from '../../MenuItem';

@Component({
  selector: 'app-food-search',
  templateUrl: './food-search.component.html',
  styleUrls: ['./food-search.component.css']
})
export class FoodSearchComponent implements OnInit {
  menuItem: MenuItem[];
  @Output() searchEmitter: any;
  searchString: string = '';
  constructor() {
    this.searchEmitter = new EventEmitter();
  }

  ngOnInit() {
  }
  event() {
    this.searchEmitter.emit(this.searchString);
  }
}
