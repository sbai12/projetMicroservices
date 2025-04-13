// src/app/services/cart.service.ts
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartService {
  private items: any[] = [];
  private produitsSelectionnes: any[] = [];
  addToCart(product: any) {
    product.selected = false;
    this.items.push(product);
  }
  
  

  getCartItems() {
    return this.items;
  }

  clearCart() {
    this.items = [];
  }
  getTotalItems() {
    return this.items.length;
  }
  getTotalPrice() {
    return this.items.reduce((total, item) => {
      const prix = parseFloat(item.prix.replace(/[^\d.-]/g, ''));
      return total + prix;
    }, 0);
  }
  setProduitsSelectionnes(items: any[]) {
    this.produitsSelectionnes = items;
  }
  
  getProduitsSelectionnes() {
    return this.produitsSelectionnes;
  }
}
