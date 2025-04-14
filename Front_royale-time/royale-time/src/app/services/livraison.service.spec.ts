import { TestBed } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { LivraisonService } from './livraison.service';

describe('LivraisonService', () => {
  let service: LivraisonService;

  beforeEach(() => {
    TestBed.configureTestingModule({
      imports: [HttpClientTestingModule],
      providers: [LivraisonService]
    });
    service = TestBed.inject(LivraisonService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
