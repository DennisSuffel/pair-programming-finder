package de.dennissuffel.pairProgrammingFinderBackend.user;

import java.net.URL;
import java.util.List;

import de.dennissuffel.pairProgrammingFinderBackend.user.model.SessionType;
import de.dennissuffel.pairProgrammingFinderBackend.user.model.User;

public class UserBuilder {

	private int id;

	private String name;

	private URL profilePictureUrl;

	private List<String> interests;

	private SessionType preferedSessionType;

	private String area;

	private List<String> videoConferenceTools;

	public UserBuilder setId(int id) {
		this.id = id;
		return this;
	}

	public UserBuilder setName(String name) {
		this.name = name;
		return this;
	}

	public UserBuilder setProfilePictureUrl(URL profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
		return this;
	}

	public UserBuilder setInterests(List<String> interests) {
		this.interests = interests;
		return this;
	}

	public UserBuilder setPreferedSessionType(SessionType preferedSessionType) {
		this.preferedSessionType = preferedSessionType;
		return this;
	}

	public UserBuilder setArea(String area) {
		this.area = area;
		return this;
	}

	public UserBuilder setVideoConferenceTools(List<String> videoConferenceTools) {
		this.videoConferenceTools = videoConferenceTools;
		return this;
	}

	public UserBuilder reset() {
		this.id = 0;
		this.name = null;
		this.profilePictureUrl = null;
		this.interests = null;
		this.preferedSessionType = null;
		this.area = null;
		this.videoConferenceTools = null;
		return this;
	}

	public User build() {
		User user = new User();
		user.setId(this.id);
		user.setName(this.name);
		user.setProfilePictureUrl(this.profilePictureUrl);
		user.setInterests(this.interests);
		user.setPreferedSessionType(this.preferedSessionType);
		user.setArea(this.area);
		user.setVideoConferenceTools(this.videoConferenceTools);
		return user;
	}
}
