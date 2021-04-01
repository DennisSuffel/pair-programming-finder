import { SessionType } from "./sessionType.enum";

export class User {
  private id: number;
  private name: string;
  private profilePictureUrl: string;
  private interests: string[];
  private preferedSessionType: SessionType;
  private area: string;
  private videoConferenceTools: string[];

  constructor(id: number, name: string, profilePictureUrl: string, interests: string[], preferedSessionType: SessionType, area: string, videoConferenceTools: string[]) {
    this.id = id;
    this.name = name;
    this.profilePictureUrl = profilePictureUrl;
    this.interests = interests;
    this.preferedSessionType = preferedSessionType;
    this.area = area;
    this.videoConferenceTools = videoConferenceTools;
  }
}
