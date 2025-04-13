import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-suivi-livraison',
  imports: [CommonModule],
  templateUrl: './suivi-livraison.component.html',
  styleUrl: './suivi-livraison.component.css'
})
export class SuiviLivraisonComponent {
  statut: 'EN_ATTENTE' | 'EXPEDIEE' | 'EN_COURS_DE_LIVRAISON' | 'LIVREE' | 'ANNULEE' = 'EN_COURS_DE_LIVRAISON';

  stepAvant(step: string): boolean {
    const ordre = ['EN_ATTENTE', 'EXPEDIEE', 'EN_COURS_DE_LIVRAISON', 'LIVREE'];
    return ordre.indexOf(this.statut) > ordre.indexOf(step);
  }
  formatStep(step: string): string {
    return step.replace(/_/g, ' ');
  }


}
