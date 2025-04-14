// paypal-payment.component.ts
import { Component } from '@angular/core';
import{PaymentService}from '../../services/payment.service';

@Component({
  selector: 'app-paypal-payment',
  templateUrl: './paypal-payment.component.html',
  styleUrls: ['./paypal-payment.component.css']
})
export class PaypalPaymentComponent {
  constructor(private paymentService: PaymentService) {}

  payer() {
    const payment = {
      orderId: '123ABC',
      method: 'PAYPAL',
      amount: 100.0,
      status: '',
      createdAt: new Date(),
      approvalUrl: ''
    };

    this.paymentService.createPayment(payment).subscribe(response => {
      if (response && response.approvalUrl) {
        window.location.href = response.approvalUrl; // redirection vers PayPal
      }
    }, error => {
      console.error("Erreur lors de la création du paiement :", error);
    });
  }
}
