import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FoodMenuComponent } from './food/food-menu/food-menu.component';
import { CartComponent } from './shopping/cart/cart.component';
import { ItemEditComponent } from './food/item-edit/item-edit.component';
import { LoginComponent } from './site/login/login.component';
import { SignupComponent } from './site/signup/signup.component';
import { LoginGuard } from './login.guard';
import { EditItemStatusComponent } from './food/edit-item-status/edit-item-status.component';

const routes: Routes = [
  { path: '', component: FoodMenuComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'cart', component: CartComponent ,canActivate: [LoginGuard]},
  { path: 'item-edit/:id', component: ItemEditComponent,canActivate: [LoginGuard] },
  { path: 'login', component: LoginComponent },
  { path: 'login/:status', component: LoginComponent },
  { path: 'food-menu', component: FoodMenuComponent },
  { path: 'edit-item-status', component: EditItemStatusComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
