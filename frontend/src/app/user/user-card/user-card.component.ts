import { Component, Input, OnInit } from '@angular/core';
import { SessionType } from '../model/sessionType.enum';
import { User } from '../model/user.model';

@Component({
  selector: 'app-user-card',
  templateUrl: './user-card.component.html',
  styleUrls: ['./user-card.component.css'],
})
export class UserCardComponent implements OnInit {
  @Input()
  public user: User;

  constructor() {}

  ngOnInit(): void {}

  public userWantsRemoteSession(): boolean {
    return (
      this.user.preferedSessionType === SessionType.REMOTE ||
      this.userWantsBothSessionTypes()
    );
  }

  public userWantsLocalSession(): boolean {
    return (
      this.user.preferedSessionType === SessionType.LOCAL ||
      this.userWantsBothSessionTypes()
    );
  }

  private userWantsBothSessionTypes(): boolean {
    return this.user.preferedSessionType === SessionType.BOTH;
  }
}
