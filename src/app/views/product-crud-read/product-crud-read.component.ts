import { ProductServiceService } from 'src/app/service/product-service.service';
import { Produto } from './../product-crud/product.model';
import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material/table';

@Component({
  selector: 'app-product-crud-read',
  templateUrl: './product-crud-read.component.html',
  styleUrls: ['./product-crud-read.component.css']
})
export class ProductCrudReadComponent implements OnInit {

   produtos: Produto[] = [
    {id_produto: 1, nome: 'Hydrogen', preco: '1.0', codigoProduto: '1'},
    {id_produto: 2, nome: 'Helium', preco: '4.00', codigoProduto: '2'},
    {id_produto: 3, nome: 'Lithium', preco: '6.94', codigoProduto: '3'},
    {id_produto: 4, nome: 'Beryllium', preco: '9.01', codigoProduto: '2'},
    {id_produto: 5, nome: 'Boron', preco: '10.81', codigoProduto: '1'},
  ];
  displayedColumns: string[] = ['id_produto', 'nome', 'preco', 'codigoProduto', 'descricao', ];
  newprodutos: Produto[] = new Array;
  dataSource = new MatTableDataSource(this.produtos);

  constructor(private service: ProductServiceService) { }

  ngOnInit(): void {
    this.getProdutos();
  }

  getProdutos(){
    this.service.getProdutos().subscribe(produtos => {
      this.newprodutos = produtos;
      console.log(produtos);
    })
  }

  applyFilter(event: Event) {
    const filterValue = (event.target as HTMLInputElement).value;
    this.dataSource.filter = filterValue.trim().toLowerCase();
  }

}
