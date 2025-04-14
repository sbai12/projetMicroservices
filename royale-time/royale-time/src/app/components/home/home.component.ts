import { Component , OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { NavbarComponent } from "../navbar/navbar.component";
import { CartService } from '../../services/cart.service';
import { ProductService } from 'app/services/product.service'; 
import { Product } from 'models/product.model'; 

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [CommonModule, NavbarComponent],
   
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit  {
  produits: any[] = [];  // Tableau pour stocker les produits

  constructor(private productService: ProductService) { }

   ngOnInit(): void {
    // Appeler le service pour récupérer les produits depuis l'API
    this.productService.getProducts().subscribe(data => {
      // Gérer les données manquantes (null ou undefined) en utilisant map
      this.produits = data.map((produit: Product) => {  // Typage explicite de produit
        produit.artimg = produit.artimg || 'assets/default-image.jpg';  // Image par défaut
        produit.prix = produit.prix || 100.0;  // Prix par défaut
        produit.artdesc = produit.artdesc || 'Description non disponible';  // Description par défaut
        produit.artcategory = produit.artcategory || 'Catégorie non disponible'; // Catégorie par défaut
        produit.marque = produit.marque || 'Marque non disponible';  // Marque par défaut
        return produit;
      });
    });
  }

  addToCart(produit: Product): void {
    console.log('Produit ajouté au panier:', produit);
    // Ajoutez la logique pour ajouter le produit au panier ici
  }
}