import { TestBed } from '@angular/core/testing';

import { RestaurantService } from './resturant.service';

describe('ResturantService', () => {
  let service: RestaurantService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RestaurantService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
