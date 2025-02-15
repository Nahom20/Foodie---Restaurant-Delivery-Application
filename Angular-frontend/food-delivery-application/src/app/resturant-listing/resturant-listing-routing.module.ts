import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { ResturantListingComponent } from './component/resturant-listing.component';

const routes: Routes = [
  {path: '', component: ResturantListingComponent}
];

@NgModule({
  imports: [RouterModule.forChild(routes)],
  exports: [RouterModule]
})
export class ResturantListingRoutingModule { }
