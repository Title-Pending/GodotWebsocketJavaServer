package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the GLMS_QUIZ_GAMETEMPLATE database table.
 * 
 */
@Entity
@Table(name="GLMS_QUIZ_GAMETEMPLATE")
@NamedQuery(name="GlmsQuizGametemplate.findAll", query="SELECT g FROM GlmsQuizGametemplate g")
public class GlmsQuizGametemplate implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="TEMPLATE_IDX")
	private long templateIdx;

	private BigDecimal classificationtype;

	@Column(name="\"CONTENTS\"")
	private String contents;

	private String isused;

	@Temporal(TemporalType.DATE)
	private Date modifydate;

	private int quotationcount;

	@Temporal(TemporalType.DATE)
	private Date regdate;

	//bi-directional many-to-one association to GlmsQuizSet
	@OneToMany(mappedBy="glmsQuizGametemplate")
	private List<GlmsQuizSet> glmsQuizSets;

	public GlmsQuizGametemplate() {
	}

	public long getTemplateIdx() {
		return this.templateIdx;
	}

	public void setTemplateIdx(long templateIdx) {
		this.templateIdx = templateIdx;
	}

	public BigDecimal getClassificationtype() {
		return this.classificationtype;
	}

	public void setClassificationtype(BigDecimal classificationtype) {
		this.classificationtype = classificationtype;
	}

	public String getContents() {
		return this.contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
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

	public List<GlmsQuizSet> getGlmsQuizSets() {
		return this.glmsQuizSets;
	}

	public void setGlmsQuizSets(List<GlmsQuizSet> glmsQuizSets) {
		this.glmsQuizSets = glmsQuizSets;
	}

	public GlmsQuizSet addGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		getGlmsQuizSets().add(glmsQuizSet);
		glmsQuizSet.setGlmsQuizGametemplate(this);

		return glmsQuizSet;
	}

	public GlmsQuizSet removeGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		getGlmsQuizSets().remove(glmsQuizSet);
		glmsQuizSet.setGlmsQuizGametemplate(null);

		return glmsQuizSet;
	}

}