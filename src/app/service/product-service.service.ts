import { Produto } from './../views/product-crud/product.model';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/internal/Observable';

@Injectable({
  providedIn: 'root'
})
export class ProductServiceService {

  constructor(private http: HttpClient) { }
  API  = 'http://localhost:8080/produtos';

  public create(produto: Produto) {
    return this.http.post('http://localhost:8080/produtos', produto);
  }

  public getProdutos(): Observable<Produto[]> {
    return this.http.get<Produto[]>(this.API);
  }

  public getById(id: number): Observable<Produto> {
    const APIBYID = `${this.API}/${id}`;
    return this.http.get<Produto>(APIBYID);
  }

  public getUpdate(produto: Produto): Observable<Produto> {
    const url = `${this.API}/${produto.id_produto}`;
    return this.http.put<Produto>(url, produto)
  }

  public getDelete(id: number): Observable<Produto> {
    const APIBYID = `${this.API}/${id}`;
    return this.http.delete<Produto>(APIBYID);

  }

}


