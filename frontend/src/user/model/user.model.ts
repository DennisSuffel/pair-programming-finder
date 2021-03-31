export class User {
  public id: string;
  public name: string;
  public profilePictureUrl: string;
  public interests: string[];
  public preferedSessionType: SessionType;
  public area: string;
  public videoConferenceTools: string[];

  constructor(id: string, name: string, profilePictureUrl: string, interests: string[], preferedSessionType: SessionType, area: string, videoConferenceTools: string[]) {
    this.id = id;
    this.name = name;
    this.profilePictureUrl = profilePictureUrl;
    this.interests = interests;
    this.preferedSessionType = preferedSessionType;
    this.area = area;
    this.videoConferenceTools = videoConferenceTools;
  }
}
