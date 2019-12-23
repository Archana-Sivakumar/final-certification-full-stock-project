import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewStockPriceComponent } from './view-stock-price.component';

xdescribe('ViewStockPriceComponent', () => {
  let component: ViewStockPriceComponent;
  let fixture: ComponentFixture<ViewStockPriceComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewStockPriceComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewStockPriceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
