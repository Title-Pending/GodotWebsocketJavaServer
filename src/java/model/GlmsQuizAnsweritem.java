package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_ANSWERITEM database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_ANSWERITEM")
@NamedQuery(name="GlmsQuizAnsweritem.findAll", query="SELECT g FROM GlmsQuizAnsweritem g")
public class GlmsQuizAnsweritem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ANSWERITEM_IDX")
	private long answeritemIdx;

	private String answeritemname;

	private BigDecimal displaynum;

	private String isanswer;

	private String isused;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private long points;

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

	//bi-directional many-to-one association to GlmsQuizScorerecord
	@OneToMany(mappedBy="glmsQuizAnsweritem")
	private List<GlmsQuizScorerecord> glmsQuizScorerecords;

	public GlmsQuizAnsweritem() {
	}

	public long getAnsweritemIdx() {
		return this.answeritemIdx;
	}

	public void setAnsweritemIdx(long answeritemIdx) {
		this.answeritemIdx = answeritemIdx;
	}

	public String getAnsweritemname() {
		return this.answeritemname;
	}

	public void setAnsweritemname(String answeritemname) {
		this.answeritemname = answeritemname;
	}

	public BigDecimal getDisplaynum() {
		return this.displaynum;
	}

	public void setDisplaynum(BigDecimal displaynum) {
		this.displaynum = displaynum;
	}

	public String getIsanswer() {
		return this.isanswer;
	}

	public void setIsanswer(String isanswer) {
		this.isanswer = isanswer;
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

	public List<GlmsQuizScorerecord> getGlmsQuizScorerecords() {
		return this.glmsQuizScorerecords;
	}

	public void setGlmsQuizScorerecords(List<GlmsQuizScorerecord> glmsQuizScorerecords) {
		this.glmsQuizScorerecords = glmsQuizScorerecords;
	}

	public GlmsQuizScorerecord addGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().add(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizAnsweritem(this);

		return glmsQuizScorerecord;
	}

	public GlmsQuizScorerecord removeGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().remove(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizAnsweritem(null);

		return glmsQuizScorerecord;
	}

}