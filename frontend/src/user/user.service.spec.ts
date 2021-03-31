import { TestBed } from '@angular/core/testing';

import { UserService } from './user.service';

describe('UserService', () => {
  let service: UserService = new UserService();

  it('should return a filled list of users', () => {
    expect(service.getAllUsers()).not.toBeNull();
    expect(service.getAllUsers()).not.toHaveSize(0);
  });
});
