import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private items: any[] = [];

  constructor() {}

  // Ajoute un produit au panier
  addToCart(product: any): void {
    this.items.push(product);
  }

  // Retourne tous les produits dans le panier
  getItems(): any[] {
    return this.items;
  }

  // Alias optionnel pour getItems() → règle l'erreur getCartItems()
  getCartItems(): any[] {
    return this.getItems();
  }

  // Retourne le nombre total d'articles
  getTotalItems(): number {
    return this.items.length;
  }

  // Supprime tous les articles
  clearCart(): void {
    this.items = [];
  }

  // Ajoute une méthode pour setProduitsSelectionnes() si nécessaire
  setProduitsSelectionnes(produits: any[]): void {
    // Tu peux gérer les produits sélectionnés comme tu le souhaites ici
    this.items = produits;
  }

  // Ajoute une méthode pour getProduitsSelectionnes() si nécessaire
  getProduitsSelectionnes(): any[] {
    return this.items.filter(item => item.selected); // Retourne les produits sélectionnés
  }

  // Calcul du prix total
  getTotalPrice(): number {
    return this.items.reduce((total, item) => total + item.price, 0); // Calcul du prix total
  }
}
