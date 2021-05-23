import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProductCrudReadComponent } from './product-crud-read.component';

describe('ProductCrudReadComponent', () => {
  let component: ProductCrudReadComponent;
  let fixture: ComponentFixture<ProductCrudReadComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ProductCrudReadComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ProductCrudReadComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
