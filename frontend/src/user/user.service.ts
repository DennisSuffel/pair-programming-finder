import { Injectable } from '@angular/core';
import { EmptyError } from 'rxjs';
import { User } from './model/user.model';
import { SessionType } from './model/sessionType.enum';

@Injectable({
  providedIn: 'root'
})
export class UserService {

  constructor() { }

  public getAllUsers(): User[] {
    return [new User(111, 'test', 'www.test.test', ['Java', 'Pair Programming'], SessionType.REMOTE, '', ['Zoom'])];
  }
}
