package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_CHANNELMEMBERS database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_CHANNELMEMBERS")
@NamedQuery(name="GlmsQuizChannelmember.findAll", query="SELECT g FROM GlmsQuizChannelmember g")
public class GlmsQuizChannelmember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MEMBER_IDX")
	private long memberIdx;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private BigDecimal ranking;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	//bi-directional many-to-one association to GlmsQuizChannel
	@ManyToOne
	@JoinColumn(name="QUIZCHANNEL_IDX")
	private GlmsQuizChannel glmsQuizChannel;

	//bi-directional many-to-one association to GlmsQuizTeam
	@ManyToOne
	@JoinColumn(name="QUIZTEAM_IDX")
	private GlmsQuizTeam glmsQuizTeam;

	//bi-directional many-to-one association to GlmsUser
	@ManyToOne
	@JoinColumn(name="USER_IDX")
	private GlmsUser glmsUser;

	//bi-directional many-to-one association to GlmsQuizScorerecord
	@OneToMany(mappedBy="glmsQuizChannelmember")
	private List<GlmsQuizScorerecord> glmsQuizScorerecords;

	public GlmsQuizChannelmember() {
	}

	public long getMemberIdx() {
		return this.memberIdx;
	}

	public void setMemberIdx(long memberIdx) {
		this.memberIdx = memberIdx;
	}

	public Date getEnddate() {
		return this.enddate;
	}

	public void setEnddate(Date enddate) {
		this.enddate = enddate;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public BigDecimal getRanking() {
		return this.ranking;
	}

	public void setRanking(BigDecimal ranking) {
		this.ranking = ranking;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public GlmsQuizChannel getGlmsQuizChannel() {
		return this.glmsQuizChannel;
	}

	public void setGlmsQuizChannel(GlmsQuizChannel glmsQuizChannel) {
		this.glmsQuizChannel = glmsQuizChannel;
	}

	public GlmsQuizTeam getGlmsQuizTeam() {
		return this.glmsQuizTeam;
	}

	public void setGlmsQuizTeam(GlmsQuizTeam glmsQuizTeam) {
		this.glmsQuizTeam = glmsQuizTeam;
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
		glmsQuizScorerecord.setGlmsQuizChannelmember(this);

		return glmsQuizScorerecord;
	}

	public GlmsQuizScorerecord removeGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().remove(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizChannelmember(null);

		return glmsQuizScorerecord;
	}

}