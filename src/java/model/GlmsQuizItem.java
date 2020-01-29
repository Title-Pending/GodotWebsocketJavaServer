package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_ITEM database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_ITEM")
@NamedQuery(name="GlmsQuizItem.findAll", query="SELECT g FROM GlmsQuizItem g")
public class GlmsQuizItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="QUIZITEM_IDX")
	private long quizitemIdx;

	private String image;

	private String isused;

	private String keyword;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private String quizquestion;

	private int quiztype;

	private int quotationcount;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private String remarksinfo;

	private int remarkstype;

	private String video;

	//bi-directional many-to-one association to GlmsQuizAnsweritem
	@OneToMany(mappedBy="glmsQuizItem", cascade=CascadeType.REMOVE)
	private List<GlmsQuizAnsweritem> glmsQuizAnsweritems;

	//bi-directional many-to-one association to GlmsQuizHintitem
	@OneToMany(mappedBy="glmsQuizItem", cascade=CascadeType.REMOVE)
	private List<GlmsQuizHintitem> glmsQuizHintitems;

	//bi-directional many-to-one association to GlmsQuizSet
	@ManyToOne
	@JoinColumn(name="QUIZSET_IDX")
	private GlmsQuizSet glmsQuizSet;

	//bi-directional many-to-one association to GlmsUser
	@ManyToOne
	@JoinColumn(name="USER_IDX")
	private GlmsUser glmsUser;

	//bi-directional many-to-one association to GlmsCommoncode
	@ManyToOne
	@JoinColumn(name="CODE_IDX")
	private GlmsCommoncode glmsCommoncode;

	//bi-directional many-to-one association to GlmsQuizScorerecord
	@OneToMany(mappedBy="glmsQuizItem")
	private List<GlmsQuizScorerecord> glmsQuizScorerecords;

	public GlmsQuizItem() {
	}

	public long getQuizitemIdx() {
		return this.quizitemIdx;
	}

	public void setQuizitemIdx(long quizitemIdx) {
		this.quizitemIdx = quizitemIdx;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
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

	public String getQuizquestion() {
		return this.quizquestion;
	}

	public void setQuizquestion(String quizquestion) {
		this.quizquestion = quizquestion;
	}

	public int getQuiztype() {
		return this.quiztype;
	}

	public void setQuiztype(int quiztype) {
		this.quiztype = quiztype;
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

	public String getRemarksinfo() {
		return this.remarksinfo;
	}

	public void setRemarksinfo(String remarksinfo) {
		this.remarksinfo = remarksinfo;
	}

	public int getRemarkstype() {
		return this.remarkstype;
	}

	public void setRemarkstype(int remarkstype) {
		this.remarkstype = remarkstype;
	}

	public String getVideo() {
		return this.video;
	}

	public void setVideo(String video) {
		this.video = video;
	}

	public List<GlmsQuizAnsweritem> getGlmsQuizAnsweritems() {
		return this.glmsQuizAnsweritems;
	}

	public void setGlmsQuizAnsweritems(List<GlmsQuizAnsweritem> glmsQuizAnsweritems) {
		this.glmsQuizAnsweritems = glmsQuizAnsweritems;
	}

	public GlmsQuizAnsweritem addGlmsQuizAnsweritem(GlmsQuizAnsweritem glmsQuizAnsweritem) {
		getGlmsQuizAnsweritems().add(glmsQuizAnsweritem);
		glmsQuizAnsweritem.setGlmsQuizItem(this);

		return glmsQuizAnsweritem;
	}

	public GlmsQuizAnsweritem removeGlmsQuizAnsweritem(GlmsQuizAnsweritem glmsQuizAnsweritem) {
		getGlmsQuizAnsweritems().remove(glmsQuizAnsweritem);
		glmsQuizAnsweritem.setGlmsQuizItem(null);

		return glmsQuizAnsweritem;
	}

	public List<GlmsQuizHintitem> getGlmsQuizHintitems() {
		return this.glmsQuizHintitems;
	}

	public void setGlmsQuizHintitems(List<GlmsQuizHintitem> glmsQuizHintitems) {
		this.glmsQuizHintitems = glmsQuizHintitems;
	}

	public GlmsQuizHintitem addGlmsQuizHintitem(GlmsQuizHintitem glmsQuizHintitem) {
		getGlmsQuizHintitems().add(glmsQuizHintitem);
		glmsQuizHintitem.setGlmsQuizItem(this);

		return glmsQuizHintitem;
	}

	public GlmsQuizHintitem removeGlmsQuizHintitem(GlmsQuizHintitem glmsQuizHintitem) {
		getGlmsQuizHintitems().remove(glmsQuizHintitem);
		glmsQuizHintitem.setGlmsQuizItem(null);

		return glmsQuizHintitem;
	}

	public GlmsQuizSet getGlmsQuizSet() {
		return this.glmsQuizSet;
	}

	public void setGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		this.glmsQuizSet = glmsQuizSet;
	}

	public GlmsUser getGlmsUser() {
		return this.glmsUser;
	}

	public void setGlmsUser(GlmsUser glmsUser) {
		this.glmsUser = glmsUser;
	}

	public GlmsCommoncode getGlmsCommoncode() {
		return this.glmsCommoncode;
	}

	public void setGlmsCommoncode(GlmsCommoncode glmsCommoncode) {
		this.glmsCommoncode = glmsCommoncode;
	}

	public List<GlmsQuizScorerecord> getGlmsQuizScorerecords() {
		return this.glmsQuizScorerecords;
	}

	public void setGlmsQuizScorerecords(List<GlmsQuizScorerecord> glmsQuizScorerecords) {
		this.glmsQuizScorerecords = glmsQuizScorerecords;
	}

	public GlmsQuizScorerecord addGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().add(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizItem(this);

		return glmsQuizScorerecord;
	}

	public GlmsQuizScorerecord removeGlmsQuizScorerecord(GlmsQuizScorerecord glmsQuizScorerecord) {
		getGlmsQuizScorerecords().remove(glmsQuizScorerecord);
		glmsQuizScorerecord.setGlmsQuizItem(null);

		return glmsQuizScorerecord;
	}

}