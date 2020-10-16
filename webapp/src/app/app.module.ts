import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { FoodItemComponent } from './food/food-item/food-item.component';
import { FoodSearchComponent } from './food/search/food-search/food-search.component';
import { CartComponent } from './shopping/cart/cart.component';
import { ItemEditComponent } from './food/item-edit/item-edit.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginComponent } from './site/login/login.component';
import { NavbarComponent } from './navbar/navbar.component';
import { EditItemStatusComponent } from './food/edit-item-status/edit-item-status.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    FoodMenuComponent,
    FoodItemComponent,
    FoodSearchComponent,
    CartComponent,
    ItemEditComponent,
    SignupComponent,
    LoginComponent,
    NavbarComponent,
    EditItemStatusComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
