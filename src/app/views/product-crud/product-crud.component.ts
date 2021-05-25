import { Produto } from './product.model';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { ProductServiceService } from 'src/app/service/product-service.service';
@Component({
  selector: 'app-product-crud',
  templateUrl: './product-crud.component.html',
  styleUrls: ['./product-crud.component.css']
})
export class ProductCrudComponent implements OnInit {

  produto: Produto = {
  nome: "Diogo",
  codigo: 123213,
  descricao: "Testes de inclusao",
  preco: 213
  }

  constructor(private productService: ProductServiceService,
              private router: Router) { }

//colocar um snacbar para cadastrado com sucesso.

ngOnInit(): void {

}

 createProduct() {
    console.log(this.produto);
    this.productService
    .create(this.produto)
    .subscribe(resultado => {
      alert("Produto Cadastrado com sucesso")
      this.router.navigate(['/products'])
    })
  }

  cancel(){
    this.router.navigate(['/'])
  }
}
