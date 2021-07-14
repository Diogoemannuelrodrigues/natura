import { ProductServiceService } from 'src/app/service/product-service.service';
import { Produto } from './../product-crud/product.model';
import { Component, OnChanges, OnInit, SimpleChanges } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-product-crud-read',
  templateUrl: './product-crud-read.component.html',
  styleUrls: ['./product-crud-read.component.css']
})
export class ProductCrudReadComponent implements OnInit {

  produtos: Produto[] = [];
  displayedColumns = ['id_produto', 'nome', 'preco', 'codigoProduto', 'tipo', 'descricao', 'actions'];

  constructor(private service: ProductServiceService) { }

  ngOnInit(): void {
    this.getProdutos();
  }

/*   ngOnChanges(changes: SimpleChanges): void {
    this.getProdutos();
  } */

  getProdutos(){
    this.service.getProdutos().subscribe(produtos => {
      this.produtos = produtos;
      console.log(produtos);
    })
  }




}
