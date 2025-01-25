
import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { OrderService } from '../service/order.service';
import { OrderDTO } from '../models/orderdto';

@Component({
  selector: 'app-order-summary',
  templateUrl: './order-summary.component.html',
  styleUrls: ['./order-summary.component.css']
})
export class OrderSummaryComponent {

  orderSummary?:OrderDTO;
  obj: any;
  total?: any;
  showDialog: boolean = false;

  constructor(private route: ActivatedRoute, private orderService: OrderService, private router: Router) { 
    const stateData = this.router.getCurrentNavigation()?.extras.state as { obj?: any };
    if (stateData && stateData.obj) {
      this.obj = stateData.obj;
      this.obj.userId = 1;
      this.orderSummary = stateData.obj;
      console.log("📥 Received order summary from state:", this.orderSummary);
    } else {
      console.error("⚠️ No order summary received in constructor!");
    }
  }
  
  ngOnInit() {

    this.total = this.orderSummary?.foodItemList.reduce((accumulator, currentValue) => {
      const quantity = Number(currentValue.quantity);
      const price = currentValue.price ?? 0;  // Default to 0 if price is undefined
      if (isNaN(quantity) || isNaN(price)) {
        console.error('⚠️ Invalid quantity or price', currentValue);
        return accumulator; // Skip this item if quantity or price is invalid
      }
      return accumulator + (quantity * price);
    }, 0);
  }
  
  

  saveOrder() {
    
    this.orderService.saveOrder(this.orderSummary)
      .subscribe(
        response => {
            this.showDialog = true;
        },
        error => {
          console.error('Failed to save data:', error);
        }
      );
  }

  closeDialog() {
    this.showDialog = false;
    this.router.navigate(['/']); // Replace '/home' with the actual route for your home page
  }





}