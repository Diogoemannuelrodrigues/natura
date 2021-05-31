import { ProductServiceService } from 'src/app/service/product-service.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-produto-update',
  templateUrl: './produto-update.component.html',
  styleUrls: ['./produto-update.component.css']
})
export class ProdutoUpdateComponent implements OnInit {

  constructor(private service: ProductServiceService) { }

  ngOnInit(): void {
  }

}
