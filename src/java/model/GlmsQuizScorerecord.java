package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the GLMS_QUIZ_SCORERECORD database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_SCORERECORD")
@NamedQuery(name="GlmsQuizScorerecord.findAll", query="SELECT g FROM GlmsQuizScorerecord g")
public class GlmsQuizScorerecord implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="SCORE_IDX")
	private long scoreIdx;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private BigDecimal score;

	//bi-directional many-to-one association to GlmsQuizSet
	@ManyToOne
	@JoinColumn(name="QUIZSET_IDX")
	private GlmsQuizSet glmsQuizSet;

	//bi-directional many-to-one association to GlmsQuizChannelmember
	@ManyToOne
	@JoinColumn(name="MEMBER_IDX")
	private GlmsQuizChannelmember glmsQuizChannelmember;

	//bi-directional many-to-one association to GlmsQuizItem
	@ManyToOne
	@JoinColumn(name="QUIZITEM_IDX")
	private GlmsQuizItem glmsQuizItem;

	//bi-directional many-to-one association to GlmsQuizAnsweritem
	@ManyToOne
	@JoinColumn(name="ANSWERITEM_IDX")
	private GlmsQuizAnsweritem glmsQuizAnsweritem;

	public GlmsQuizScorerecord() {
	}

	public long getScoreIdx() {
		return this.scoreIdx;
	}

	public void setScoreIdx(long scoreIdx) {
		this.scoreIdx = scoreIdx;
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

	public BigDecimal getScore() {
		return this.score;
	}

	public void setScore(BigDecimal score) {
		this.score = score;
	}

	public GlmsQuizSet getGlmsQuizSet() {
		return this.glmsQuizSet;
	}

	public void setGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		this.glmsQuizSet = glmsQuizSet;
	}

	public GlmsQuizChannelmember getGlmsQuizChannelmember() {
		return this.glmsQuizChannelmember;
	}

	public void setGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		this.glmsQuizChannelmember = glmsQuizChannelmember;
	}

	public GlmsQuizItem getGlmsQuizItem() {
		return this.glmsQuizItem;
	}

	public void setGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		this.glmsQuizItem = glmsQuizItem;
	}

	public GlmsQuizAnsweritem getGlmsQuizAnsweritem() {
		return this.glmsQuizAnsweritem;
	}

	public void setGlmsQuizAnsweritem(GlmsQuizAnsweritem glmsQuizAnsweritem) {
		this.glmsQuizAnsweritem = glmsQuizAnsweritem;
	}

}