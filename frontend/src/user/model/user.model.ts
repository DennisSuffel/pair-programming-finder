import { SessionType } from './sessionType.enum';

export class User {
  private _id: number;
  private _name: string;
  private _profilePictureUrl: string;
  private _interests: string[];
  private _preferedSessionType: SessionType;
  private _area: string;
  private _videoConferenceTools: string[];

  constructor(
    id?: number,
    name?: string,
    profilePictureUrl?: string,
    interests?: string[],
    preferedSessionType?: SessionType,
    area?: string,
    videoConferenceTools?: string[]
  ) {
    this._id = id || 0;
    this._name = name || '';
    this._profilePictureUrl = profilePictureUrl || '';
    this._interests = interests || [];
    this._preferedSessionType = preferedSessionType || SessionType.BOTH;
    this._area = area || '';
    this._videoConferenceTools = videoConferenceTools || [];
  }

  public set id(id: number) {
    this._id = id;
  }

  public get id(): number {
    return this._id;
  }

  public set name(name: string) {
    this._name = name;
  }

  public get name(): string {
    return this._name;
  }
  public set profilePictureUrl(profilePictureUrl: string) {
    this._profilePictureUrl = profilePictureUrl;
  }

  public get profilePictureUrl(): string {
    return this._profilePictureUrl;
  }
  public set interests(interests: string[]) {
    this._interests = interests;
  }

  public get interests(): string[] {
    return this._interests;
  }
  public set preferedSessionType(preferedSessionType: SessionType) {
    this._preferedSessionType = preferedSessionType;
  }

  public get preferedSessionType(): SessionType {
    return this._preferedSessionType;
  }
  public set area(area: string) {
    this._area = area;
  }

  public get area(): string {
    return this._area;
  }
  public set videoConferenceTools(videoConferenceTools: string[]) {
    this._videoConferenceTools = videoConferenceTools;
  }

  public get videoConferenceTools(): string[] {
    return this._videoConferenceTools;
  }
}
