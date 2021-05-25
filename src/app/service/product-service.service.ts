import { Produto } from './../views/product-crud/product.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http: HttpClient) { }
  API  = 'http://localhost:8080/produtos/';

 /*  public createProdutos(productCrud: ProductCrud): Observable<ProductCrud[]> {
    return this.http.get<ProductCrud[]>('http://localhost:8080/produtos');
  } */

 /*  public create(produto: Produto): Observable<Produto>{
    return this.http.post<Produto>(this.API, produto)
  } */
  public create(produto: Produto) {
    console.log('Id Produto ' + produto.id);
    return this.http.post('http://localhost:8080/produtos', produto);
  }

}


