import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';

import { HomeComponent } from './views/home/home.component';
import { ProductCrudComponent } from './views/product-crud/product-crud.component';
import { ProductCrudReadComponent } from './views/product-crud-read/product-crud-read.component';

const routes: Routes = [
  { path: "", component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'products', component: ProductCrudComponent},
  { path: 'products-read', component: ProductCrudReadComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
