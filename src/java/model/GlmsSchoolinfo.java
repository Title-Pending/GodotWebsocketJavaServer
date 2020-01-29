package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_SCHOOLINFO database table.
 * 
 */
@Entity
@Table(name="GLMS_SCHOOLINFO")
@NamedQuery(name="GlmsSchoolinfo.findAll", query="SELECT g FROM GlmsSchoolinfo g")
public class GlmsSchoolinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SCHOOL_IDX")
	private long schoolIdx;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private String schoolname;

	//bi-directional many-to-one association to GlmsBasiclocalorg
	@ManyToOne
	@JoinColumn(name="AREA2_IDX")
	private GlmsBasiclocalorg glmsBasiclocalorg;

	//bi-directional many-to-one association to GlmsUser
	@OneToMany(mappedBy="glmsSchoolinfo")
	private List<GlmsUser> glmsUsers;

	public GlmsSchoolinfo() {
	}

	public long getSchoolIdx() {
		return this.schoolIdx;
	}

	public void setSchoolIdx(long schoolIdx) {
		this.schoolIdx = schoolIdx;
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

	public String getSchoolname() {
		return this.schoolname;
	}

	public void setSchoolname(String schoolname) {
		this.schoolname = schoolname;
	}

	public GlmsBasiclocalorg getGlmsBasiclocalorg() {
		return this.glmsBasiclocalorg;
	}

	public void setGlmsBasiclocalorg(GlmsBasiclocalorg glmsBasiclocalorg) {
		this.glmsBasiclocalorg = glmsBasiclocalorg;
	}

	public List<GlmsUser> getGlmsUsers() {
		return this.glmsUsers;
	}

	public void setGlmsUsers(List<GlmsUser> glmsUsers) {
		this.glmsUsers = glmsUsers;
	}

	public GlmsUser addGlmsUser(GlmsUser glmsUser) {
		getGlmsUsers().add(glmsUser);
		glmsUser.setGlmsSchoolinfo(this);

		return glmsUser;
	}

	public GlmsUser removeGlmsUser(GlmsUser glmsUser) {
		getGlmsUsers().remove(glmsUser);
		glmsUser.setGlmsSchoolinfo(null);

		return glmsUser;
	}

}