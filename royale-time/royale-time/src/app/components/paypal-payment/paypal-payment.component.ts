import { Component, OnInit, AfterViewInit } from '@angular/core';

declare global {
  interface Window {
    paypal: any;
  }
}

@Component({
  selector: 'app-paypal-payment',
  templateUrl: './paypal-payment.component.html',
  styleUrls: ['./paypal-payment.component.css']
})
export class PaypalPaymentComponent implements OnInit, AfterViewInit {

  constructor() {}

  ngOnInit(): void {}

  ngAfterViewInit(): void {
    this.renderPayPalButton();
  }

  renderPayPalButton(): void {
    if (window.paypal) {
      window.paypal.Buttons({
        createOrder: (data: any, actions: any) => {
          return actions.order.create({
            purchase_units: [{
              amount: {
                value: '100.00' // à remplacer par ton total panier
              }
            }]
          });
        },
        onApprove: (data: any, actions: any) => {
          return actions.order.capture().then((details: any) => {
            alert('Paiement réussi ! Merci 🎉');
          });
        },
        onCancel: (data: any) => {
          alert('Paiement annulé ❌');
        }
      }).render('#paypal-button-container');
    }
  }
}
