import { ComponentFixture, TestBed } from '@angular/core/testing';
import { SessionType } from '../model/sessionType.enum';
import { User } from '../model/user.model';
import { UserBuilder } from '../userBuilder';

import { UserCardComponent } from './user-card.component';

describe('UserCardComponent', () => {
  let component: UserCardComponent;
  let fixture: ComponentFixture<UserCardComponent>;
  let testData: User = new UserBuilder()
    .setId(111)
    .setName('test')
    .setProfilePictureUrl('www.test.test')
    .setInterests(['Java', 'Pair Programming'])
    .setPreferedSessionType(SessionType.BOTH)
    .setVideoConferenceTools(['Zoom'])
    .setArea('London')
    .build();

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [UserCardComponent],
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UserCardComponent);
    component = fixture.componentInstance;
    component.user = testData;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should show the users name in a h2 header', () => {
    let compiled = fixture.debugElement.nativeElement;
    expect(compiled.querySelector('h2').textContent).toBe(testData.name);
  });
});
