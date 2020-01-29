package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_AUTH database table.
 * 
 */
@Entity
@Table(name="GLMS_AUTH")
@NamedQuery(name="GlmsAuth.findAll", query="SELECT g FROM GlmsAuth g")
public class GlmsAuth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AUTH_IDX")
	private long authIdx;

	private String authname;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	//bi-directional many-to-one association to GlmsMenuauth
	@OneToMany(mappedBy="glmsAuth")
	private List<GlmsMenuauth> glmsMenuauths;

	//bi-directional many-to-one association to GlmsUser
	@OneToMany(mappedBy="glmsAuth")
	private List<GlmsUser> glmsUsers;

	public GlmsAuth() {
	}

	public long getAuthIdx() {
		return this.authIdx;
	}

	public void setAuthIdx(long authIdx) {
		this.authIdx = authIdx;
	}

	public String getAuthname() {
		return this.authname;
	}

	public void setAuthname(String authname) {
		this.authname = authname;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public List<GlmsMenuauth> getGlmsMenuauths() {
		return this.glmsMenuauths;
	}

	public void setGlmsMenuauths(List<GlmsMenuauth> glmsMenuauths) {
		this.glmsMenuauths = glmsMenuauths;
	}

	public GlmsMenuauth addGlmsMenuauth(GlmsMenuauth glmsMenuauth) {
		getGlmsMenuauths().add(glmsMenuauth);
		glmsMenuauth.setGlmsAuth(this);

		return glmsMenuauth;
	}

	public GlmsMenuauth removeGlmsMenuauth(GlmsMenuauth glmsMenuauth) {
		getGlmsMenuauths().remove(glmsMenuauth);
		glmsMenuauth.setGlmsAuth(null);

		return glmsMenuauth;
	}

	public List<GlmsUser> getGlmsUsers() {
		return this.glmsUsers;
	}

	public void setGlmsUsers(List<GlmsUser> glmsUsers) {
		this.glmsUsers = glmsUsers;
	}

	public GlmsUser addGlmsUser(GlmsUser glmsUser) {
		getGlmsUsers().add(glmsUser);
		glmsUser.setGlmsAuth(this);

		return glmsUser;
	}

	public GlmsUser removeGlmsUser(GlmsUser glmsUser) {
		getGlmsUsers().remove(glmsUser);
		glmsUser.setGlmsAuth(null);

		return glmsUser;
	}

}