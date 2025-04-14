import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PaypalPaymentComponent } from '../paypal-payment/paypal-payment.component';
import { CartService } from '../../services/cart.service';
import { LivraisonService } from '../../services/livraison.service';
import { Livraison } from 'models/Livraison.model';
import { HttpClientModule } from '@angular/common/http';
import{PaymentService}from '../../services/payment.service';
import { RouterModule } from '@angular/router';


@Component({
  selector: 'app-order-confirmation',
  standalone: true,
  imports: [CommonModule, FormsModule, PaypalPaymentComponent, HttpClientModule,RouterModule],  // Ensure HttpClientModule is listed here
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent {
  selectedItems: any[] = [];
  total = 0;
  nom = '';
  adresse = '';
  commandeValidee = false;
   paymentId: string = '';
  payerId: string = '';
  approvalUrl: string = '';

  constructor(private cartService: CartService, private livraisonService: LivraisonService , private paymentService :PaymentService) {}

  ngOnInit() {
    this.selectedItems = this.cartService.getProduitsSelectionnes();
    console.log('Produits sélectionnés:', this.selectedItems); // Vérifiez si le panier contient des éléments
    this.total = this.selectedItems.reduce((sum, item) => {
      const prix = parseFloat(item.prix.replace(/[^\d.-]/g, ''));
      return sum + prix;
    }, 0);
  }

  validerCommande() {
    const paiement = {
      amount: this.total,
      method: 'PAYPAL',
      status: 'PENDING',
      orderId: 'ORDER_' + Date.now()
    };
  
    this.paymentService.createPayment(paiement).subscribe({
      next: (res) => {
        if (res.approvalUrl) {
          window.location.href = res.approvalUrl; // Redirection vers PayPal
        }
      },
      error: (err) => {
        console.error(err);
        alert('Erreur lors de la création du paiement');
      }
    });
  }
  payerCommande() {
    // Rediriger vers PayPal avec l'URL d'approbation
    window.location.href = this.approvalUrl;
  }







}
