import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PaymentService {
  private apiUrl = 'http://localhost:8086/paiement';


  constructor(private http: HttpClient) { }
  createPayment(paiement: any) {
    return this.http.post<any>(`${this.apiUrl}/create`, paiement);
  }
}
