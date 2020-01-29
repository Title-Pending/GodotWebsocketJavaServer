package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_CHANNEL database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_CHANNEL")
@NamedQuery(name="GlmsQuizChannel.findAll", query="SELECT g FROM GlmsQuizChannel g")
public class GlmsQuizChannel implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QUIZCHANNEL_IDX")
	private long quizchannelIdx;

	private int channelpincode;

	private Timestamp closedtime;

	private String ischannelactivation;

	private String isclosed;

	private String isopen;

	private String isquizstart;

	private String isteam;

	private String isused;

	private String keyword;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private String quizchannelinfo;

	private String quizchannelname;

	private Timestamp quizendtime;

	private Timestamp quizstarttime;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private String serverip;

	private int serverport;

	//bi-directional many-to-one association to GlmsUser
	@ManyToOne
	@JoinColumn(name="USER_IDX")
	private GlmsUser glmsUser;

	//bi-directional many-to-one association to GlmsQuizSet
	@ManyToOne
	@JoinColumn(name="QUIZSET_IDX")
	private GlmsQuizSet glmsQuizSet;

	//bi-directional many-to-one association to GlmsQuizChannelmember
	@OneToMany(mappedBy="glmsQuizChannel")
	private List<GlmsQuizChannelmember> glmsQuizChannelmembers;

	//bi-directional many-to-one association to GlmsQuizTeam
	@OneToMany(mappedBy="glmsQuizChannel")
	private List<GlmsQuizTeam> glmsQuizTeams;

	public GlmsQuizChannel() {
	}

	public long getQuizchannelIdx() {
		return this.quizchannelIdx;
	}

	public void setQuizchannelIdx(long quizchannelIdx) {
		this.quizchannelIdx = quizchannelIdx;
	}

	public int getChannelpincode() {
		return this.channelpincode;
	}

	public void setChannelpincode(int channelpincode) {
		this.channelpincode = channelpincode;
	}

	public Timestamp getClosedtime() {
		return this.closedtime;
	}

	public void setClosedtime(Timestamp closedtime) {
		this.closedtime = closedtime;
	}

	public String getIschannelactivation() {
		return this.ischannelactivation;
	}

	public void setIschannelactivation(String ischannelactivation) {
		this.ischannelactivation = ischannelactivation;
	}

	public String getIsclosed() {
		return this.isclosed;
	}

	public void setIsclosed(String isclosed) {
		this.isclosed = isclosed;
	}

	public String getIsopen() {
		return this.isopen;
	}

	public void setIsopen(String isopen) {
		this.isopen = isopen;
	}

	public String getIsquizstart() {
		return this.isquizstart;
	}

	public void setIsquizstart(String isquizstart) {
		this.isquizstart = isquizstart;
	}

	public String getIsteam() {
		return this.isteam;
	}

	public void setIsteam(String isteam) {
		this.isteam = isteam;
	}

	public String getIsused() {
		return this.isused;
	}

	public void setIsused(String isused) {
		this.isused = isused;
	}

	public String getKeyword() {
		return this.keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getQuizchannelinfo() {
		return this.quizchannelinfo;
	}

	public void setQuizchannelinfo(String quizchannelinfo) {
		this.quizchannelinfo = quizchannelinfo;
	}

	public String getQuizchannelname() {
		return this.quizchannelname;
	}

	public void setQuizchannelname(String quizchannelname) {
		this.quizchannelname = quizchannelname;
	}

	public Timestamp getQuizendtime() {
		return this.quizendtime;
	}

	public void setQuizendtime(Timestamp quizendtime) {
		this.quizendtime = quizendtime;
	}

	public Timestamp getQuizstarttime() {
		return this.quizstarttime;
	}

	public void setQuizstarttime(Timestamp quizstarttime) {
		this.quizstarttime = quizstarttime;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getServerip() {
		return this.serverip;
	}

	public void setServerip(String serverip) {
		this.serverip = serverip;
	}

	public int getServerport() {
		return this.serverport;
	}

	public void setServerport(int serverport) {
		this.serverport = serverport;
	}

	public GlmsUser getGlmsUser() {
		return this.glmsUser;
	}

	public void setGlmsUser(GlmsUser glmsUser) {
		this.glmsUser = glmsUser;
	}

	public GlmsQuizSet getGlmsQuizSet() {
		return this.glmsQuizSet;
	}

	public void setGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		this.glmsQuizSet = glmsQuizSet;
	}

	public List<GlmsQuizChannelmember> getGlmsQuizChannelmembers() {
		return this.glmsQuizChannelmembers;
	}

	public void setGlmsQuizChannelmembers(List<GlmsQuizChannelmember> glmsQuizChannelmembers) {
		this.glmsQuizChannelmembers = glmsQuizChannelmembers;
	}

	public GlmsQuizChannelmember addGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		getGlmsQuizChannelmembers().add(glmsQuizChannelmember);
		glmsQuizChannelmember.setGlmsQuizChannel(this);

		return glmsQuizChannelmember;
	}

	public GlmsQuizChannelmember removeGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		getGlmsQuizChannelmembers().remove(glmsQuizChannelmember);
		glmsQuizChannelmember.setGlmsQuizChannel(null);

		return glmsQuizChannelmember;
	}

	public List<GlmsQuizTeam> getGlmsQuizTeams() {
		return this.glmsQuizTeams;
	}

	public void setGlmsQuizTeams(List<GlmsQuizTeam> glmsQuizTeams) {
		this.glmsQuizTeams = glmsQuizTeams;
	}

	public GlmsQuizTeam addGlmsQuizTeam(GlmsQuizTeam glmsQuizTeam) {
		getGlmsQuizTeams().add(glmsQuizTeam);
		glmsQuizTeam.setGlmsQuizChannel(this);

		return glmsQuizTeam;
	}

	public GlmsQuizTeam removeGlmsQuizTeam(GlmsQuizTeam glmsQuizTeam) {
		getGlmsQuizTeams().remove(glmsQuizTeam);
		glmsQuizTeam.setGlmsQuizChannel(null);

		return glmsQuizTeam;
	}

}