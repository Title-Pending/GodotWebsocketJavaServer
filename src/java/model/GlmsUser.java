package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_USERS database table.
 * 
 */
@Entity
@Table(name="GLMS_USERS")
@NamedQuery(name="GlmsUser.findAll", query="SELECT g FROM GlmsUser g")
public class GlmsUser implements Serializable {
	private static final long serialVersionUID = 1L;
	
	public static final String pwSalt = "DB72U4ZKHGS78TRKVJXE7WEVHTPTX8";

	@Id
	@Column(name="USER_IDX")
	private long userIdx;

	private BigDecimal accountuse;

	private String addr1;

	private String addr2;

	private String adminuser;

	private String email;

	private int grade;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private String nickname;

	private String password;

	private String phonenumber;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	private String sextype;

	private String username;

	private BigDecimal zipcode;

	//bi-directional many-to-one association to GlmsPoint
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsPoint> glmsPoints;

	//bi-directional many-to-one association to GlmsQuizAnsweritem
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsQuizAnsweritem> glmsQuizAnsweritems;

	//bi-directional many-to-one association to GlmsQuizChannel
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsQuizChannel> glmsQuizChannels;

	//bi-directional many-to-one association to GlmsQuizChannelmember
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsQuizChannelmember> glmsQuizChannelmembers;

	//bi-directional many-to-one association to GlmsQuizHintitem
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsQuizHintitem> glmsQuizHintitems;

	//bi-directional many-to-one association to GlmsQuizItem
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsQuizItem> glmsQuizItems;

	//bi-directional many-to-one association to GlmsQuizSet
	@OneToMany(mappedBy="glmsUser")
	private List<GlmsQuizSet> glmsQuizSets;

	//bi-directional many-to-one association to GlmsAuth
	@ManyToOne
	@JoinColumn(name="AUTH_IDX")
	private GlmsAuth glmsAuth;

	//bi-directional many-to-one association to GlmsSchoolinfo
	@ManyToOne
	@JoinColumn(name="SCHOOL_IDX")
	private GlmsSchoolinfo glmsSchoolinfo;

	public GlmsUser() {
	}

	public long getUserIdx() {
		return this.userIdx;
	}

	public void setUserIdx(long userIdx) {
		this.userIdx = userIdx;
	}

	public BigDecimal getAccountuse() {
		return this.accountuse;
	}

	public void setAccountuse(BigDecimal accountuse) {
		this.accountuse = accountuse;
	}

	public String getAddr1() {
		return this.addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return this.addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public String getAdminuser() {
		return this.adminuser;
	}

	public void setAdminuser(String adminuser) {
		this.adminuser = adminuser;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getGrade() {
		return this.grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getModifydate() {
		return this.modifydate;
	}

	public void setModifydate(Date modifydate) {
		this.modifydate = modifydate;
	}

	public String getNickname() {
		return this.nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenumber() {
		return this.phonenumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phonenumber = phonenumber;
	}

	public Date getRegdate() {
		return this.regdate;
	}

	public void setRegdate(Date regdate) {
		this.regdate = regdate;
	}

	public String getSextype() {
		return this.sextype;
	}

	public void setSextype(String sextype) {
		this.sextype = sextype;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public BigDecimal getZipcode() {
		return this.zipcode;
	}

	public void setZipcode(BigDecimal zipcode) {
		this.zipcode = zipcode;
	}

	public List<GlmsPoint> getGlmsPoints() {
		return this.glmsPoints;
	}

	public void setGlmsPoints(List<GlmsPoint> glmsPoints) {
		this.glmsPoints = glmsPoints;
	}

	public GlmsPoint addGlmsPoint(GlmsPoint glmsPoint) {
		getGlmsPoints().add(glmsPoint);
		glmsPoint.setGlmsUser(this);

		return glmsPoint;
	}

	public GlmsPoint removeGlmsPoint(GlmsPoint glmsPoint) {
		getGlmsPoints().remove(glmsPoint);
		glmsPoint.setGlmsUser(null);

		return glmsPoint;
	}

	public List<GlmsQuizAnsweritem> getGlmsQuizAnsweritems() {
		return this.glmsQuizAnsweritems;
	}

	public void setGlmsQuizAnsweritems(List<GlmsQuizAnsweritem> glmsQuizAnsweritems) {
		this.glmsQuizAnsweritems = glmsQuizAnsweritems;
	}

	public GlmsQuizAnsweritem addGlmsQuizAnsweritem(GlmsQuizAnsweritem glmsQuizAnsweritem) {
		getGlmsQuizAnsweritems().add(glmsQuizAnsweritem);
		glmsQuizAnsweritem.setGlmsUser(this);

		return glmsQuizAnsweritem;
	}

	public GlmsQuizAnsweritem removeGlmsQuizAnsweritem(GlmsQuizAnsweritem glmsQuizAnsweritem) {
		getGlmsQuizAnsweritems().remove(glmsQuizAnsweritem);
		glmsQuizAnsweritem.setGlmsUser(null);

		return glmsQuizAnsweritem;
	}

	public List<GlmsQuizChannel> getGlmsQuizChannels() {
		return this.glmsQuizChannels;
	}

	public void setGlmsQuizChannels(List<GlmsQuizChannel> glmsQuizChannels) {
		this.glmsQuizChannels = glmsQuizChannels;
	}

	public GlmsQuizChannel addGlmsQuizChannel(GlmsQuizChannel glmsQuizChannel) {
		getGlmsQuizChannels().add(glmsQuizChannel);
		glmsQuizChannel.setGlmsUser(this);

		return glmsQuizChannel;
	}

	public GlmsQuizChannel removeGlmsQuizChannel(GlmsQuizChannel glmsQuizChannel) {
		getGlmsQuizChannels().remove(glmsQuizChannel);
		glmsQuizChannel.setGlmsUser(null);

		return glmsQuizChannel;
	}

	public List<GlmsQuizChannelmember> getGlmsQuizChannelmembers() {
		return this.glmsQuizChannelmembers;
	}

	public void setGlmsQuizChannelmembers(List<GlmsQuizChannelmember> glmsQuizChannelmembers) {
		this.glmsQuizChannelmembers = glmsQuizChannelmembers;
	}

	public GlmsQuizChannelmember addGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		getGlmsQuizChannelmembers().add(glmsQuizChannelmember);
		glmsQuizChannelmember.setGlmsUser(this);

		return glmsQuizChannelmember;
	}

	public GlmsQuizChannelmember removeGlmsQuizChannelmember(GlmsQuizChannelmember glmsQuizChannelmember) {
		getGlmsQuizChannelmembers().remove(glmsQuizChannelmember);
		glmsQuizChannelmember.setGlmsUser(null);

		return glmsQuizChannelmember;
	}

	public List<GlmsQuizHintitem> getGlmsQuizHintitems() {
		return this.glmsQuizHintitems;
	}

	public void setGlmsQuizHintitems(List<GlmsQuizHintitem> glmsQuizHintitems) {
		this.glmsQuizHintitems = glmsQuizHintitems;
	}

	public GlmsQuizHintitem addGlmsQuizHintitem(GlmsQuizHintitem glmsQuizHintitem) {
		getGlmsQuizHintitems().add(glmsQuizHintitem);
		glmsQuizHintitem.setGlmsUser(this);

		return glmsQuizHintitem;
	}

	public GlmsQuizHintitem removeGlmsQuizHintitem(GlmsQuizHintitem glmsQuizHintitem) {
		getGlmsQuizHintitems().remove(glmsQuizHintitem);
		glmsQuizHintitem.setGlmsUser(null);

		return glmsQuizHintitem;
	}

	public List<GlmsQuizItem> getGlmsQuizItems() {
		return this.glmsQuizItems;
	}

	public void setGlmsQuizItems(List<GlmsQuizItem> glmsQuizItems) {
		this.glmsQuizItems = glmsQuizItems;
	}

	public GlmsQuizItem addGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		getGlmsQuizItems().add(glmsQuizItem);
		glmsQuizItem.setGlmsUser(this);

		return glmsQuizItem;
	}

	public GlmsQuizItem removeGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		getGlmsQuizItems().remove(glmsQuizItem);
		glmsQuizItem.setGlmsUser(null);

		return glmsQuizItem;
	}

	public List<GlmsQuizSet> getGlmsQuizSets() {
		return this.glmsQuizSets;
	}

	public void setGlmsQuizSets(List<GlmsQuizSet> glmsQuizSets) {
		this.glmsQuizSets = glmsQuizSets;
	}

	public GlmsQuizSet addGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		getGlmsQuizSets().add(glmsQuizSet);
		glmsQuizSet.setGlmsUser(this);

		return glmsQuizSet;
	}

	public GlmsQuizSet removeGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		getGlmsQuizSets().remove(glmsQuizSet);
		glmsQuizSet.setGlmsUser(null);

		return glmsQuizSet;
	}

	public GlmsAuth getGlmsAuth() {
		return this.glmsAuth;
	}

	public void setGlmsAuth(GlmsAuth glmsAuth) {
		this.glmsAuth = glmsAuth;
	}

	public GlmsSchoolinfo getGlmsSchoolinfo() {
		return this.glmsSchoolinfo;
	}

	public void setGlmsSchoolinfo(GlmsSchoolinfo glmsSchoolinfo) {
		this.glmsSchoolinfo = glmsSchoolinfo;
	}

}