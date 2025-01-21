import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResturantListingComponent } from './resturant-listing.component';

describe('ResturantListingComponent', () => {
  let component: ResturantListingComponent;
  let fixture: ComponentFixture<ResturantListingComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResturantListingComponent]
    });
    fixture = TestBed.createComponent(ResturantListingComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
