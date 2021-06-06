import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductServiceService } from 'src/app/service/product-service.service';
import { Produto } from '../product-crud/product.model';

@Component({
  selector: 'app-produto-delete',
  templateUrl: './produto-delete.component.html',
  styleUrls: ['./produto-delete.component.css']
})
export class ProdutoDeleteComponent implements OnInit {

  produto: Produto = {
    nome: '',
    codigoProduto: 0,
    descricao: '',
    preco: ''
  }

  constructor(
    private service: ProductServiceService,
    private route: ActivatedRoute,
    private router: Router
  ) { }

  ngOnInit(): void {
    const id = this.route.snapshot.paramMap.get("id_produto");
    this.service.getById(Number(id)).subscribe(product => {
      this.produto = product;
    });
  }

  deleteProduct(): void {
    this.service.getDelete(Number(this.produto.id_produto)).pipe().subscribe(() => this.router.navigate(['/produtos-read']));
  }

}
