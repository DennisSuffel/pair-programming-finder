import { inject, TestBed } from '@angular/core/testing';
import {
  HttpClientTestingModule,
  HttpTestingController,
} from '@angular/common/http/testing';

import { UserService } from './user.service';
import { UserBuilder } from './userBuilder';
import { SessionType } from './model/sessionType.enum';
import { User } from './model/user.model';

describe('UserService', () => {
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

  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [UserService],
      imports: [HttpClientTestingModule],
    });
  });

  afterEach(inject(
    [HttpTestingController],
    (httpMock: HttpTestingController) => {
      httpMock.verify();
    }
  ));

  // TODO: Deep copy the test data
  it('should return a filled list of users', inject(
    [HttpTestingController, UserService],
    (httpMock: HttpTestingController, service: UserService) => {
      service.getAllUsers().subscribe((users) => {
        expect(users).not.toBeNull();
        expect(users).not.toHaveSize(0);
        expect(users).toEqual(testData);
        expect(Object.assign({}, users)).toEqual(Object.assign({}, testData));
      });

      const req = httpMock.expectOne('http://localhost:8080/user/all');
      expect(req.request.method).toEqual('GET');

      req.flush(testData);
    }
  ));
});
