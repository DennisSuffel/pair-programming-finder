import { HttpClient } from '@angular/common/http';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { TestBed } from '@angular/core/testing';
import { of } from 'rxjs';
import { AppComponent } from './app.component';
import { SessionType } from './user/model/sessionType.enum';
import { User } from './user/model/user.model';
import { UserService } from './user/user.service';
import { UserBuilder } from './user/userBuilder';

describe('AppComponent', () => {
  let testData: User[] = [
    new UserBuilder()
      .setId(111)
      .setName('test')
      .setProfilePictureUrl('www.test.test')
      .setInterests(['Java', 'Pair Programming'])
      .setPreferedSessionType(SessionType.REMOTE)
      .setVideoConferenceTools(['Zoom'])
      .build(),
    new UserBuilder()
      .setId(222)
      .setName('test2')
      .setProfilePictureUrl('www.test2.test')
      .setInterests(['C#', 'TDD'])
      .setPreferedSessionType(SessionType.BOTH)
      .setArea('Munich')
      .setVideoConferenceTools(['MS Teams'])
      .build(),
  ];

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [AppComponent],
      imports: [HttpClientTestingModule],
    }).compileComponents();
  });

  it('should create the app', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app).toBeTruthy();
  });

  it(`should have as title 'Pair Programming Finder'`, () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    expect(app.title).toEqual('Pair Programming Finder');
  });

  // TODO: Deep copy the test data
  it('should have as users a filled list of users', () => {
    const fixture = TestBed.createComponent(AppComponent);
    const app = fixture.componentInstance;
    let userService = fixture.debugElement.injector.get(UserService);
    spyOn(userService, 'getAllUsers').and.returnValue(of(testData));
    fixture.detectChanges();
    fixture.whenStable().then(() => {
      expect(app.users).toEqual(testData);
    });
  });

  it('should render title', () => {
    const fixture = TestBed.createComponent(AppComponent);
    fixture.detectChanges();
    const compiled = fixture.nativeElement;
    expect(compiled.querySelector('.content h1').textContent).toContain(
      'Pair Programming Finder'
    );
  });
});
