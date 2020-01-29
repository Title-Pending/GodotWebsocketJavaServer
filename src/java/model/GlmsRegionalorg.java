package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_REGIONALORG database table.
 * 
 */
@Entity
@Table(name="GLMS_REGIONALORG")
@NamedQuery(name="GlmsRegionalorg.findAll", query="SELECT g FROM GlmsRegionalorg g")
public class GlmsRegionalorg implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="AREA1_IDX")
	private long area1Idx;

	private String area1name;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	//bi-directional many-to-one association to GlmsBasiclocalorg
	@OneToMany(mappedBy="glmsRegionalorg")
	private List<GlmsBasiclocalorg> glmsBasiclocalorgs;

	public GlmsRegionalorg() {
	}

	public long getArea1Idx() {
		return this.area1Idx;
	}

	public void setArea1Idx(long area1Idx) {
		this.area1Idx = area1Idx;
	}

	public String getArea1name() {
		return this.area1name;
	}

	public void setArea1name(String area1name) {
		this.area1name = area1name;
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

	public List<GlmsBasiclocalorg> getGlmsBasiclocalorgs() {
		return this.glmsBasiclocalorgs;
	}

	public void setGlmsBasiclocalorgs(List<GlmsBasiclocalorg> glmsBasiclocalorgs) {
		this.glmsBasiclocalorgs = glmsBasiclocalorgs;
	}

	public GlmsBasiclocalorg addGlmsBasiclocalorg(GlmsBasiclocalorg glmsBasiclocalorg) {
		getGlmsBasiclocalorgs().add(glmsBasiclocalorg);
		glmsBasiclocalorg.setGlmsRegionalorg(this);

		return glmsBasiclocalorg;
	}

	public GlmsBasiclocalorg removeGlmsBasiclocalorg(GlmsBasiclocalorg glmsBasiclocalorg) {
		getGlmsBasiclocalorgs().remove(glmsBasiclocalorg);
		glmsBasiclocalorg.setGlmsRegionalorg(null);

		return glmsBasiclocalorg;
	}

}