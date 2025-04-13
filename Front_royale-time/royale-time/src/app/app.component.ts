import { Component } from '@angular/core';
import { RouterModule,Router } from '@angular/router';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterModule ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private router: Router) {}

  goToShop() {
    this.router.navigate(['/home']);
  }
  goToSignIn() {
    this.router.navigate(['/sign-in']);
  }
}
