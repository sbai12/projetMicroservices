// src/app/models/product.model.ts
export interface Product {
    id: number;
    artdesign: string | null;  // Utiliser artdesign comme nom du produit
    prix: number;
    qtestock: number;
    tauxremise: number;
    artimg: string | null;
    artdesc: string | null;
    artcategory: string | null;
    marque: string | null;
  }
  