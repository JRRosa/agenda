package org.ejemplo.com.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.ejemplo.com.entity.property.UserProperty;

@Entity(name = UserProperty.TABLE)
public class User implements Serializable {

	/**
	 * A {@code Long} Serial autogenerated value: {@value #serialVersionUID}.
	 */
	private static final long serialVersionUID = -5465519860542035769L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name=UserProperty.ID, nullable=false)
	private Integer id;
	
	@Column(name=UserProperty.NAME, nullable=false)
	private String name;
	
	@Column(name=UserProperty.LASTNAME, nullable=false)
	private String lastname;
	
	@Column(name=UserProperty.EMAIL, nullable=false)
	private String email;
	
	@Column(name=UserProperty.PASSWORD, nullable=false)
	private String password;
	
	@Column(name=UserProperty.BIRTHDATE, nullable=false)
	@Temporal(TemporalType.DATE)
	private Date birthdate;
	
	@Column(name=UserProperty.ENROLL_DATE, nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date enrollDate;
	
	@OneToMany(mappedBy = UserProperty.RELATION_ACTIVITY)
	List<Activity> activities;
	
	public User() {
		super();
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

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Date getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(Date enrollDate) {
		this.enrollDate = enrollDate;
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public void setActivities(List<Activity> activities) {
		this.activities = activities;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (!(obj instanceof User)) {
			return false;
		}
		User other = (User) obj;
		if (id == null) {
			if (other.id != null) {
				return false;
			}
		} else if (!id.equals(other.id)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=").append(id).append(", name=").append(name).append(", lastname=").append(lastname)
				.append(", email=").append(email).append(", password=").append(password).append(", birthdate=")
				.append(birthdate).append(", enrollDate=").append(enrollDate).append(", activities=").append(activities)
				.append("]");
		return builder.toString();
	}	
}
