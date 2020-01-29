package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GLMS_QUIZ_HINTITEM database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_HINTITEM")
@NamedQuery(name="GlmsQuizHintitem.findAll", query="SELECT g FROM GlmsQuizHintitem g")
public class GlmsQuizHintitem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="HINTITEM_IDX")
	private long hintitemIdx;

	private String hintcomment;

	private BigDecimal hintdisplaynum;

	private BigDecimal hinttype;

	private String isused;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	//bi-directional many-to-one association to GlmsQuizItem
	@ManyToOne
	@JoinColumn(name="QUIZITEM_IDX")
	private GlmsQuizItem glmsQuizItem;

	//bi-directional many-to-one association to GlmsUser
	@ManyToOne
	@JoinColumn(name="USER_IDX")
	private GlmsUser glmsUser;

	public GlmsQuizHintitem() {
	}

	public long getHintitemIdx() {
		return this.hintitemIdx;
	}

	public void setHintitemIdx(long hintitemIdx) {
		this.hintitemIdx = hintitemIdx;
	}

	public String getHintcomment() {
		return this.hintcomment;
	}

	public void setHintcomment(String hintcomment) {
		this.hintcomment = hintcomment;
	}

	public BigDecimal getHintdisplaynum() {
		return this.hintdisplaynum;
	}

	public void setHintdisplaynum(BigDecimal hintdisplaynum) {
		this.hintdisplaynum = hintdisplaynum;
	}

	public BigDecimal getHinttype() {
		return this.hinttype;
	}

	public void setHinttype(BigDecimal hinttype) {
		this.hinttype = hinttype;
	}

	public String getIsused() {
		return this.isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
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

	public GlmsQuizItem getGlmsQuizItem() {
		return this.glmsQuizItem;
	}

	public void setGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		this.glmsQuizItem = glmsQuizItem;
	}

	public GlmsUser getGlmsUser() {
		return this.glmsUser;
	}

	public void setGlmsUser(GlmsUser glmsUser) {
		this.glmsUser = glmsUser;
	}

}