import { SessionType } from './sessionType.enum';

export class User {
  public id: number;
  public name: string;
  public profilePictureUrl: string;
  public interests: string[];
  public preferedSessionType: SessionType;
  public area: string;
  public videoConferenceTools: string[];

  constructor(
    id?: number,
    name?: string,
    profilePictureUrl?: string,
    interests?: string[],
    preferedSessionType?: SessionType,
    area?: string,
    videoConferenceTools?: string[]
  ) {
    this.id = id || 0;
    this.name = name || '';
    this.profilePictureUrl = profilePictureUrl || '';
    this.interests = interests || [];
    this.preferedSessionType = preferedSessionType || SessionType.BOTH;
    this.area = area || '';
    this.videoConferenceTools = videoConferenceTools || [];
  }
}
