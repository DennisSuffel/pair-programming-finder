import { SessionType } from './model/sessionType.enum';
import { User } from './model/user.model';

export class UserBuilder {
  private user: User;

  constructor() {
    this.user = new User();
  }

  public setId(id: number): UserBuilder {
    this.user.id = id;
    return this;
  }

  public setName(name: string): UserBuilder {
    this.user.name = name;
    return this;
  }

  public setProfilePictureUrl(profilePictureUrl: string): UserBuilder {
    this.user.profilePictureUrl = profilePictureUrl;
    return this;
  }

  public setInterests(interests: string[]): UserBuilder {
    this.user.interests = interests;
    return this;
  }

  public setPreferedSessionType(preferedSessionType: SessionType): UserBuilder {
    this.user.preferedSessionType = preferedSessionType;
    return this;
  }

  public setArea(area: string): UserBuilder {
    this.user.area = area;
    return this;
  }

  public setVideoConferenceTools(videoConferenceTools: string[]): UserBuilder {
    this.user.videoConferenceTools = videoConferenceTools;
    return this;
  }

  public build(): User {
    return this.user;
  }

  public reset(): void {
    this.user = new User();
  }
}
