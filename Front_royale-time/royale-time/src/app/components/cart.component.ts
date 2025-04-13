import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartService } from '../services/cart.service';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';




@Component({
  selector: 'app-cart',
  standalone: true,

  imports: [CommonModule, FormsModule],
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']

})
export class CartComponent {
  
  items: any[] = [];
  total: number = 0;
  commandeVisible = false;
produitsCommandes: any[] = [];
totalCommande: number = 0;


  constructor(private cartService: CartService,private router: Router) {}

  ngOnInit() {
    this.items = this.cartService.getCartItems().map(item => ({ ...item, selected: false }));
    this.total = this.cartService.getTotalPrice();
  }
  
  clearCart() {
    this.cartService.clearCart();
    this.items = [];
    this.total = 0;
  }
  
  passerCommande() {
    const produitsSelectionnes = this.items.filter(item => item.selected);
    this.cartService.setProduitsSelectionnes(produitsSelectionnes);
    this.router.navigate(['/confirmation']);
  }
  
  fermerCommande() {
    this.commandeVisible = false;
  }
  
  confirmerCommande() {
    alert("Commande confirmée !");
    this.cartService.clearCart();
    this.items = [];
    this.total = 0;
    this.commandeVisible = false;
  }

}
