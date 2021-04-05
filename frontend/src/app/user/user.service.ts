import { Injectable } from '@angular/core';
import { EmptyError } from 'rxjs';
import { User } from './model/user.model';
import { SessionType } from './model/sessionType.enum';
import { UserBuilder } from './userBuilder';

@Injectable({
  providedIn: 'root',
})
export class UserService {
  constructor() {}

  public getAllUsers(): User[] {
    return [
      new UserBuilder()
        .setId(111)
        .setName('test')
        .setProfilePictureUrl('www.test.test')
        .setInterests(['Java', 'Pair Programming'])
        .setPreferedSessionType(SessionType.REMOTE)
        .setArea('Munich')
        .setVideoConferenceTools(['Zoom'])
        .build(),
    ];
  }
}
