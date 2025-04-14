import { Component } from '@angular/core';
import { CartService } from '../../services/cart.service';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-navbar',
  imports: [RouterModule],
  templateUrl: './navbar.component.html',
  styleUrl: './navbar.component.css'
})
export class NavbarComponent {
 
  totalItems = 0;
  constructor(private cartService: CartService) {}

  ngOnInit() {
    this.totalItems = this.cartService.getTotalItems();
  }
}
