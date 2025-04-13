import { RouterModule,Routes } from '@angular/router';
import { HomeComponent } from './components/home/home.component';
import { NgModule } from '@angular/core';
import { LandingComponent } from './components/landing/landing.component';
import{CartComponent} from './components/cart.component';
import { OrderConfirmationComponent } from './order-confirmation/order-confirmation.component';
import { SignInComponent } from './components/auth/sign-in/sign-in.component';
import { SignUpComponent } from './components/auth/sign-up/sign-up.component';
import { SuiviLivraisonComponent } from './components/suivi-livraison/suivi-livraison.component';

export const routes: Routes = [
    { path: '', component: LandingComponent },
    { path: 'panier', component: CartComponent },
    { path: 'confirmation',component: OrderConfirmationComponent },
    { path: 'home', component: HomeComponent },
    { path: 'sign-in', component: SignInComponent },
    { path: 'sign-up', component: SignUpComponent },
    {  path: 'suivi-livraison', component:SuiviLivraisonComponent},
];

@NgModule({
    imports: [RouterModule.forRoot(routes)],
    exports: [RouterModule]
  })
  export class AppRoutes{ }