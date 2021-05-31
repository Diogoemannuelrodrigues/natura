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
  nome: '',
  codigoProduto: '',
  descricao: '',
  preco: ''
  }

  produtos: Produto[] = new Array;

  constructor(private productService: ProductServiceService,
              private router: Router) { }

//colocar um snacbar para cadastrado com sucesso.

ngOnInit(): void {

}

 createProduct() {
    this.productService
    .create(this.produto)
    .subscribe(resultado => {
      console.log(this.produto.id_produto);
      alert(this.produto.id_produto + " Cadastrado com sucesso")
    })
  }

  load() {
    location.reload()
  }

  cancel(){
    this.router.navigate(['/produtos-read'])
  }
}
