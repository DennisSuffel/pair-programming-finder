package de.dennissuffel.pairprogrammingfinderbackend.user.model;

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + id;
		result = prime * result + ((interests == null) ? 0 : interests.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((preferedSessionType == null) ? 0 : preferedSessionType.hashCode());
		result = prime * result + ((profilePictureUrl == null) ? 0 : profilePictureUrl.hashCode());
		result = prime * result + ((videoConferenceTools == null) ? 0 : videoConferenceTools.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (id != other.id)
			return false;
		if (interests == null) {
			if (other.interests != null)
				return false;
		} else if (!interests.equals(other.interests))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (preferedSessionType != other.preferedSessionType)
			return false;
		if (profilePictureUrl == null) {
			if (other.profilePictureUrl != null)
				return false;
		} else if (!profilePictureUrl.equals(other.profilePictureUrl))
			return false;
		if (videoConferenceTools == null) {
			if (other.videoConferenceTools != null)
				return false;
		} else if (!videoConferenceTools.equals(other.videoConferenceTools))
			return false;
		return true;
	}

}
