import { ActivatedRoute, Router } from '@angular/router';
import { Produto } from './../product-crud/product.model';
import { ProductServiceService } from 'src/app/service/product-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produto-update',
  templateUrl: './produto-update.component.html',
  styleUrls: ['./produto-update.component.css']
})
export class ProdutoUpdateComponent implements OnInit {

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

  updateProduct(): void {
    this.service.getUpdate(this.produto).subscribe(produto => {
      this.produto = produto;
      alert("Produto "+ produto.id_produto+ " atualizado com sucesso!");
      this.router.navigate(['/produtos-read'])
    });
  }

}
