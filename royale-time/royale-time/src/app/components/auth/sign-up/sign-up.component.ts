import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router'; // ← à ne pas oublier

@Component({
  selector: 'app-sign-up',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent {
  nom = '';
  email = '';
  password = '';

  constructor(private router: Router) {}

  register() {
    console.log('Inscription avec', this.nom, this.email, this.password);
    // Tu peux ajouter ici l'appel API si besoin
  }

  goToSignIn() {
    this.router.navigate(['/sign-in']);
  }
}
