import { SessionType } from './model/sessionType.enum';
import { User } from './model/user.model';

import { UserBuilder } from './userBuilder';

describe('UserBuilder', () => {
  let builder: UserBuilder = new UserBuilder();
  let expectedUser: User = {
    id: 111111,
    name: 'TestName1',
    profilePictureUrl: 'https://www.test.test',
    interests: ['Java', 'TDD'],
    preferedSessionType: SessionType.BOTH,
    area: 'Frankfurt',
    videoConferenceTools: ['Zoom', 'MS Teams'],
  };

  beforeEach(async () => {
    builder
      .setId(expectedUser.id)
      .setName(expectedUser.name)
      .setProfilePictureUrl(expectedUser.profilePictureUrl)
      .setInterests(expectedUser.interests)
      .setPreferedSessionType(expectedUser.preferedSessionType)
      .setArea(expectedUser.area)
      .setVideoConferenceTools(expectedUser.videoConferenceTools);
  });

  it('should build the correct user', () => {
    let actualUser: User = builder.build();

    /*
    * expect(actualUser).toEqual(expectedUser); does not work, because toEqual takes into account the constructor
    * used to create the object. See https://github.com/jasmine/jasmine/issues/598
    */
    expect(Object.assign({}, actualUser)).toEqual(
      Object.assign({}, expectedUser)
    );
  });

  it('should build a default user when reseted', () => {
    let actualUser: User = builder.reset().build();

    expect(actualUser).toEqual(new User());
  });
});
