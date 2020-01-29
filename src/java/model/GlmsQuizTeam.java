package model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_TEAM database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_TEAM")
@NamedQuery(name="GlmsQuizTeam.findAll", query="SELECT g FROM GlmsQuizTeam g")
public class GlmsQuizTeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QUIZTEAM_IDX")
	private long quizteamIdx;

	@Temporal(TemporalType.DATE)
	private Date enddate;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private String teamname;

	//bi-directional many-to-one association to GlmsQuizChannelmember
	@OneToMany(mappedBy="glmsQuizTeam")
	private List<GlmsQuizChannelmember> glmsQuizChannelmembers;

	//bi-directional many-to-one association to GlmsQuizChannel
	@ManyToOne
	@JoinColumn(name="QUIZCHANNEL_IDX")
	private GlmsQuizChannel glmsQuizChannel;

	public GlmsQuizTeam() {
	}

	public long getQuizteamIdx() {
		return this.quizteamIdx;
	}

	public void setQuizteamIdx(long quizteamIdx) {
		this.quizteamIdx = quizteamIdx;
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

	public String getTeamname() {
		return this.teamname;
	}

	public void setTeamname(String teamname) {
		this.teamname = teamname;
	}

	public List<GlmsQuizChannelmember> getGlmsQuizChannelmembers() {
		return this.glmsQuizChannelmembers;
	}

	public void setGlmsQuizChannelmembers(List<GlmsQuizChannelmember> glmsQuizChannelmembers) {
		this.glmsQuizChannelmembers = glmsQuizChannelmembers;
	}

	public GlmsQuizChannelmember addGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		getGlmsQuizChannelmembers().add(glmsQuizChannelmember);
		glmsQuizChannelmember.setGlmsQuizTeam(this);

		return glmsQuizChannelmember;
	}

	public GlmsQuizChannelmember removeGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		getGlmsQuizChannelmembers().remove(glmsQuizChannelmember);
		glmsQuizChannelmember.setGlmsQuizTeam(null);

		return glmsQuizChannelmember;
	}

	public GlmsQuizChannel getGlmsQuizChannel() {
		return this.glmsQuizChannel;
	}

	public void setGlmsQuizChannel(GlmsQuizChannel glmsQuizChannel) {
		this.glmsQuizChannel = glmsQuizChannel;
	}

}