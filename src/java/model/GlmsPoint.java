package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GLMS_POINTS database table.
 * 
 */
@Entity
@Table(name="GLMS_POINTS")
@NamedQuery(name="GlmsPoint.findAll", query="SELECT g FROM GlmsPoint g")
public class GlmsPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="POINT_IDX")
	private long pointIdx;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private long points;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private BigDecimal remarks;

	//bi-directional many-to-one association to GlmsUser
	@ManyToOne
	@JoinColumn(name="USER_IDX")
	private GlmsUser glmsUser;

	public GlmsPoint() {
	}

	public long getPointIdx() {
		return this.pointIdx;
	}

	public void setPointIdx(long pointIdx) {
		this.pointIdx = pointIdx;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public long getPoints() {
		return this.points;
	}

	public void setPoints(long points) {
		this.points = points;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public BigDecimal getRemarks() {
		return this.remarks;
	}

	public void setRemarks(BigDecimal remarks) {
		this.remarks = remarks;
	}

	public GlmsUser getGlmsUser() {
		return this.glmsUser;
	}

	public void setGlmsUser(GlmsUser glmsUser) {
		this.glmsUser = glmsUser;
	}

}