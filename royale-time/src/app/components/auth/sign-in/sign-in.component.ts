import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';
import { RouterModule } from '@angular/router';
@Component({
  selector: 'app-sign-in',
  standalone: true,
  imports: [CommonModule, FormsModule , RouterModule],
  templateUrl: './sign-in.component.html',
  styleUrls: ['./sign-in.component.css']
})
export class SignInComponent {
  email = '';
  password = '';

  constructor(private router: Router) {}

  login() {
    console.log('Connexion avec', this.email, this.password);
    
    // Après vérification des identifiants (simulation ici)
    if (this.email && this.password) {
      this.router.navigate(['/home']);
    }
  }
}
