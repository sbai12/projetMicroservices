import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../navbar/navbar.component";
import { CartService } from '../../services/cart.service';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NavbarComponent],
   
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {
  produits = [
    { nom: 'Montre Rolex', prix: '15 000 €', image: 'assets/rolex.jpg' },
    { nom: 'Bracelet Cartier', prix: '8 000 €', image: 'assets/cartier.jpg' },
    // ajoute plus de produits ici
  ];

  constructor(private cartService: CartService) {}

  addToCart(produit: any) {
    this.cartService.addToCart(produit);
    alert(`${produit.nom} ajouté au panier`);
  }
}
