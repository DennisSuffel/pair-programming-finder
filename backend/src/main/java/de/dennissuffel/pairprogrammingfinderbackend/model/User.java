package de.dennissuffel.pairprogrammingfinderbackend.model;

import java.net.URL;
import java.util.List;

public class User {
	private int id;

	private String name;

	private URL profilePictureUrl;

	private List<String> interests;

	private SessionType preferedSessionType;

	private String area;

	private List<String> videoConferenceTools;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public URL getProfilePictureUrl() {
		return profilePictureUrl;
	}

	public void setProfilePictureUrl(URL profilePictureUrl) {
		this.profilePictureUrl = profilePictureUrl;
	}

	public List<String> getInterests() {
		return interests;
	}

	public void setInterests(List<String> interests) {
		this.interests = interests;
	}

	public SessionType getPreferedSessionType() {
		return preferedSessionType;
	}

	public void setPreferedSessionType(SessionType preferedSessionType) {
		this.preferedSessionType = preferedSessionType;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public List<String> getVideoConferenceTools() {
		return videoConferenceTools;
	}

	public void setVideoConferenceTools(List<String> videoConferenceTools) {
		this.videoConferenceTools = videoConferenceTools;
	}

}
