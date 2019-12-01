import { TestBed } from '@angular/core/testing';

import { LogInSignUpService } from './log-in-sign-up.service';

describe('LogInSignUpService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: LogInSignUpService = TestBed.get(LogInSignUpService);
    expect(service).toBeTruthy();
  });
});
