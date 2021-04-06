import { Injectable } from '@angular/core';
import { EmptyError, Observable } from 'rxjs';
import { User } from './model/user.model';
import { SessionType } from './model/sessionType.enum';
import { UserBuilder } from './userBuilder';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  private readonly endpoint : string = 'http://localhost:8080/user/all';

  constructor(private httpClient: HttpClient) {}

  public getAllUsers(): Observable<User[]> {
    return this.httpClient.get<User[]>(this.endpoint);
  }
}
