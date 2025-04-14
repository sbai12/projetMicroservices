import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { PaypalPaymentComponent } from '../paypal-payment/paypal-payment.component';
import { CartService } from '../../services/cart.service';
import { LivraisonService } from '../../services/livraison.service';
import { Livraison } from 'models/Livraison.model';
import { HttpClientModule } from '@angular/common/http';

@Component({
  selector: 'app-order-confirmation',
  standalone: true,
  imports: [CommonModule, FormsModule, PaypalPaymentComponent, HttpClientModule],  // Ensure HttpClientModule is listed here
  templateUrl: './order-confirmation.component.html',
  styleUrls: ['./order-confirmation.component.css']
})
export class OrderConfirmationComponent {
  selectedItems: any[] = [];
  total = 0;
  nom = '';
  adresse = '';
  commandeValidee = false;

  constructor(private cartService: CartService, private livraisonService: LivraisonService) {}

  ngOnInit() {
    this.selectedItems = this.cartService.getProduitsSelectionnes();
    console.log('Produits sélectionnés:', this.selectedItems); // Vérifiez si le panier contient des éléments
    this.total = this.selectedItems.reduce((sum, item) => {
      const prix = parseFloat(item.prix.replace(/[^\d.-]/g, ''));
      return sum + prix;
    }, 0);
  }

  validerCommande() {
    if (!this.adresse) {
      alert('Please enter a valid address.');
      return;
    }
  
    const livraison: Livraison = {
      adresse: this.adresse,
      transporteur: 'Chronopost',
      statut: 'EN_ATTENTE',
      dateLivraisonPrevue: '2025-04-14T12:53:10'
    };
    
    console.log('Livraison Payload:', JSON.stringify(livraison, null, 2));
  
    this.livraisonService.createLivraison(livraison).subscribe({
      next: (data) => {
        console.log('Livraison créée:', data);
        this.commandeValidee = true;
        this.cartService.clearCart();
        alert('Order confirmed! Your delivery will be processed shortly.');
      },
      error: (err) => {
        console.error('Erreur de livraison:', err);
        alert('There was an error with your order. Please try again.');
        if (err.status === 400) {
          console.error('Backend error details:', err.error); // Log additional error details from the backend
        }
      }
    });
  }
  
  
  }
  
