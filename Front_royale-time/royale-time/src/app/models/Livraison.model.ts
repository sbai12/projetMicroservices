export interface Livraison {
  id?: number;
  adresse: string;
  transporteur: string;
  statut: 'EN_ATTENTE' | 'EN_COURS' | 'LIVREE';
  dateLivraisonPrevue: string;
}
