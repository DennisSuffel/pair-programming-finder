package de.dennissuffel.pairProgrammingFinderBackend.user.model;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue
	private Integer id;

	private String name;

	private URL profilePictureUrl;

	@ElementCollection
	@CollectionTable(name = "user_interest", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "interest")
	private List<String> interests;

	@Enumerated(EnumType.STRING)
	private SessionType preferedSessionType;

	private String area;

	@ElementCollection
	@CollectionTable(name = "user_video_conference_tool", joinColumns = @JoinColumn(name = "user_id"))
	@Column(name = "video_conference_tool")
	private List<String> videoConferenceTools;

	public User(User that) throws MalformedURLException {
		this.id = that.getId();
		this.name = that.getName();
		this.profilePictureUrl = new URL(that.getProfilePictureUrl().toExternalForm());
		this.interests = new ArrayList<>(that.getInterests());
		this.preferedSessionType = that.getPreferedSessionType();
		this.area = that.getArea();
		this.videoConferenceTools = new ArrayList<>(that.getVideoConferenceTools());
	}

	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
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

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", profilePictureUrl=" + profilePictureUrl + ", interests="
				+ interests + ", preferedSessionType=" + preferedSessionType + ", area=" + area
				+ ", videoConferenceTools=" + videoConferenceTools + "]";
	}
}
