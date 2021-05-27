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
    console.log(this.produto);
    this.productService
    .create(this.produto)
    .subscribe(resultado => {
      alert("Produto Cadastrado com sucesso")
      this.load();
    })
  }

  load() {
    location.reload()
  }

  getProdutos(){
    this.productService.getProdutos().subscribe(produtos =>{
      console.log(produtos);
      produtos = produtos;
      this.router.navigate(['/products'])
    })
  }

  cancel(){
    this.router.navigate(['/'])
  }
}
