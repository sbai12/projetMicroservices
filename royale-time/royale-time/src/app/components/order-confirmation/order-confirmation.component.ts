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
    const livraison: Livraison = {
      orderId: 123,
      adresse: this.adresse,
      transporteur: 'Chronopost',
      status: 'EN_ATTENTE',
      dateLivraisonPrevue: new Date().toISOString()
    };

    console.log('Objet Livraison:', livraison); // Vérifiez l'objet avant de l'envoyer

    this.livraisonService.createLivraison(livraison).subscribe({
      next: (data: Livraison) => {
        alert(`Livraison créée avec succès pour ${this.nom}, à l'adresse : ${this.adresse}`);
        this.commandeValidee = true;
      },
      error: (err: any) => {
        alert('Erreur lors de la création de la livraison.');
        console.error('Erreur de livraison:', err);
      }
    });
  }
}
