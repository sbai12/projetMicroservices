import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { CartService } from '../services/cart.service';
import { FormsModule } from '@angular/forms';
import{PaypalPaymentComponent}from'../paypal-payment/paypal-payment.component';
@Component({
  selector: 'app-order-confirmation',
  standalone: true,
  imports: [CommonModule, FormsModule,PaypalPaymentComponent],
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent {
  selectedItems: any[] = [];
  total = 0;
  nom = '';
  adresse = '';
  commandeValidee = false;


  constructor(private cartService: CartService) {}

  ngOnInit() {
    this.selectedItems = this.cartService.getProduitsSelectionnes();
    this.total = this.selectedItems.reduce((sum, item) => {
      const prix = parseFloat(item.prix.replace(/[^\d.-]/g, ''));
      return sum + prix;
    }, 0);
  }

  validerCommande() {
    alert(`Commande confirmée pour ${this.nom}, à l'adresse : ${this.adresse}`);
    this.commandeValidee = true;

  }
}
