package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_BASICLOCALORG database table.
 * 
 */
@Entity
@Table(name="GLMS_BASICLOCALORG")
@NamedQuery(name="GlmsBasiclocalorg.findAll", query="SELECT g FROM GlmsBasiclocalorg g")
public class GlmsBasiclocalorg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AREA2_IDX")
	private long area2Idx;

	private String area2name;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	//bi-directional many-to-one association to GlmsRegionalorg
	@ManyToOne
	@JoinColumn(name="AREA1_IDX")
	private GlmsRegionalorg glmsRegionalorg;

	//bi-directional many-to-one association to GlmsSchoolinfo
	@OneToMany(mappedBy="glmsBasiclocalorg")
	private List<GlmsSchoolinfo> glmsSchoolinfos;

	public GlmsBasiclocalorg() {
	}

	public long getArea2Idx() {
		return this.area2Idx;
	}

	public void setArea2Idx(long area2Idx) {
		this.area2Idx = area2Idx;
	}

	public String getArea2name() {
		return this.area2name;
	}

	public void setArea2name(String area2name) {
		this.area2name = area2name;
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

	public GlmsRegionalorg getGlmsRegionalorg() {
		return this.glmsRegionalorg;
	}

	public void setGlmsRegionalorg(GlmsRegionalorg glmsRegionalorg) {
		this.glmsRegionalorg = glmsRegionalorg;
	}

	public List<GlmsSchoolinfo> getGlmsSchoolinfos() {
		return this.glmsSchoolinfos;
	}

	public void setGlmsSchoolinfos(List<GlmsSchoolinfo> glmsSchoolinfos) {
		this.glmsSchoolinfos = glmsSchoolinfos;
	}

	public GlmsSchoolinfo addGlmsSchoolinfo(GlmsSchoolinfo glmsSchoolinfo) {
		getGlmsSchoolinfos().add(glmsSchoolinfo);
		glmsSchoolinfo.setGlmsBasiclocalorg(this);

		return glmsSchoolinfo;
	}

	public GlmsSchoolinfo removeGlmsSchoolinfo(GlmsSchoolinfo glmsSchoolinfo) {
		getGlmsSchoolinfos().remove(glmsSchoolinfo);
		glmsSchoolinfo.setGlmsBasiclocalorg(null);

		return glmsSchoolinfo;
	}

}