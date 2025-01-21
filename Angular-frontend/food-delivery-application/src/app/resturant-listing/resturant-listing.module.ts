import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ResturantListingRoutingModule } from './resturant-listing-routing.module';
import { ResturantListingComponent } from './component/resturant-listing.component';


@NgModule({
  declarations: [
    ResturantListingComponent
  ],
  imports: [
    CommonModule,
    ResturantListingRoutingModule
  ]
})
export class ResturantListingModule { }
