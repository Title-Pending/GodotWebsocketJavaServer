package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_SET database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_SET")
@NamedQuery(name="GlmsQuizSet.findAll", query="SELECT g FROM GlmsQuizSet g")
public class GlmsQuizSet implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QUIZSET_IDX")
	private long quizsetIdx;

	@Column(name="QUIZSET_NAME")
	private String quizsetName;
	
	private double deadline;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private long points;

	@Column(name="QUIZSET_STARTCOMMENT")
	private String quizsetStartcomment;

	private int quotationcount;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private double timelimit;

	private long turnnum;

	//bi-directional many-to-one association to GlmsQuizChannel
	@OneToMany(mappedBy="glmsQuizSet")
	private List<GlmsQuizChannel> glmsQuizChannels;

	//bi-directional many-to-one association to GlmsQuizItem
	@OneToMany(mappedBy="glmsQuizSet")
	private List<GlmsQuizItem> glmsQuizItems;

	//bi-directional many-to-one association to GlmsQuizScorerecord
	@OneToMany(mappedBy="glmsQuizSet")
	private List<GlmsQuizScorerecord> glmsQuizScorerecords;

	//bi-directional many-to-one association to GlmsUser
	@ManyToOne
	@JoinColumn(name="USER_IDX")
	private GlmsUser glmsUser;

	//bi-directional many-to-one association to GlmsQuizGametemplate
	@ManyToOne
	@JoinColumn(name="TEMPLATE_IDX")
	private GlmsQuizGametemplate glmsQuizGametemplate;

	//bi-directional many-to-one association to GlmsCommoncode
	@ManyToOne
	@JoinColumn(name="CODE_IDX")
	private GlmsCommoncode glmsCommoncode;

	public GlmsQuizSet() {
	}

	public long getQuizsetIdx() {
		return this.quizsetIdx;
	}

	public void setQuizsetIdx(long quizsetIdx) {
		this.quizsetIdx = quizsetIdx;
	}
	
	public String getQuizsetName() {
		return this.quizsetName;
	}
	
	public void setQuizsetName(String quizsetName) {
		this.quizsetName = quizsetName;
	}

	public double getDeadline() {
		return this.deadline;
	}

	public void setDeadline(double deadline) {
		this.deadline = deadline;
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

	public String getQuizsetStartcomment() {
		return this.quizsetStartcomment;
	}

	public void setQuizsetStartcomment(String quizsetStartcomment) {
		this.quizsetStartcomment = quizsetStartcomment;
	}

	public int getQuotationcount() {
		return this.quotationcount;
	}

	public void setQuotationcount(int quotationcount) {
		this.quotationcount = quotationcount;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public double getTimelimit() {
		return this.timelimit;
	}

	public void setTimelimit(double timelimit) {
		this.timelimit = timelimit;
	}

	public long getTurnnum() {
		return this.turnnum;
	}

	public void setTurnnum(long turnnum) {
		this.turnnum = turnnum;
	}

	public List<GlmsQuizChannel> getGlmsQuizChannels() {
		return this.glmsQuizChannels;
	}

	public void setGlmsQuizChannels(List<GlmsQuizChannel> glmsQuizChannels) {
		this.glmsQuizChannels = glmsQuizChannels;
	}

	public GlmsQuizChannel addGlmsQuizChannel(GlmsQuizChannel glmsQuizChannel) {
		getGlmsQuizChannels().add(glmsQuizChannel);
		glmsQuizChannel.setGlmsQuizSet(this);

		return glmsQuizChannel;
	}

	public GlmsQuizChannel removeGlmsQuizChannel(GlmsQuizChannel glmsQuizChannel) {
		getGlmsQuizChannels().remove(glmsQuizChannel);
		glmsQuizChannel.setGlmsQuizSet(null);

		return glmsQuizChannel;
	}

	public List<GlmsQuizItem> getGlmsQuizItems() {
		return this.glmsQuizItems;
	}

	public void setGlmsQuizItems(List<GlmsQuizItem> glmsQuizItems) {
		this.glmsQuizItems = glmsQuizItems;
	}

	public GlmsQuizItem addGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		getGlmsQuizItems().add(glmsQuizItem);
		glmsQuizItem.setGlmsQuizSet(this);

		return glmsQuizItem;
	}

	public GlmsQuizItem removeGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		getGlmsQuizItems().remove(glmsQuizItem);
		glmsQuizItem.setGlmsQuizSet(null);

		return glmsQuizItem;
	}

	public List<GlmsQuizScorerecord> getGlmsQuizScorerecords() {
		return this.glmsQuizScorerecords;
	}

	public void setGlmsQuizScorerecords(List<GlmsQuizScorerecord> glmsQuizScorerecords) {
		this.glmsQuizScorerecords = glmsQuizScorerecords;
	}

	public GlmsQuizScorerecord addGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().add(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizSet(this);

		return glmsQuizScorerecord;
	}

	public GlmsQuizScorerecord removeGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().remove(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizSet(null);

		return glmsQuizScorerecord;
	}

	public GlmsUser getGlmsUser() {
		return this.glmsUser;
	}

	public void setGlmsUser(GlmsUser glmsUser) {
		this.glmsUser = glmsUser;
	}

	public GlmsQuizGametemplate getGlmsQuizGametemplate() {
		return this.glmsQuizGametemplate;
	}

	public void setGlmsQuizGametemplate(GlmsQuizGametemplate glmsQuizGametemplate) {
		this.glmsQuizGametemplate = glmsQuizGametemplate;
	}

	public GlmsCommoncode getGlmsCommoncode() {
		return this.glmsCommoncode;
	}

	public void setGlmsCommoncode(GlmsCommoncode glmsCommoncode) {
		this.glmsCommoncode = glmsCommoncode;
	}

}