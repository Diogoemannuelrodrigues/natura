import { ProdutoUpdateComponent } from './views/produto-update/produto-update.component';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './login/login/login.component';

import { HomeComponent } from './views/home/home.component';
import { ProductCrudComponent } from './views/product-crud/product-crud.component';
import { ProductCrudReadComponent } from './views/product-crud-read/product-crud-read.component';

const routes: Routes = [
  { path: "", component: HomeComponent},
  { path: 'login', component: LoginComponent},
  { path: 'produtos', component: ProductCrudComponent},
  { path: 'produtos-read', component: ProductCrudReadComponent},
  { path: 'produto-update/:id_produto', component: ProdutoUpdateComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
