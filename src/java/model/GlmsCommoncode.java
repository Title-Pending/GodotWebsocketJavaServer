package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the GLMS_COMMONCODE database table.
 * 
 */
@Entity
@Table(name="GLMS_COMMONCODE")
@NamedQuery(name="GlmsCommoncode.findAll", query="SELECT g FROM GlmsCommoncode g")
public class GlmsCommoncode implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="CODE_IDX")
	private long codeIdx;

	private String codename;

	private BigDecimal parentcode;

	//bi-directional many-to-one association to GlmsQuizItem
	@OneToMany(mappedBy="glmsCommoncode")
	private List<GlmsQuizItem> glmsQuizItems;

	//bi-directional many-to-one association to GlmsQuizSet
	@OneToMany(mappedBy="glmsCommoncode")
	private List<GlmsQuizSet> glmsQuizSets;

	public GlmsCommoncode() {
	}

	public long getCodeIdx() {
		return this.codeIdx;
	}

	public void setCodeIdx(long codeIdx) {
		this.codeIdx = codeIdx;
	}

	public String getCodename() {
		return this.codename;
	}

	public void setCodename(String codename) {
		this.codename = codename;
	}

	public BigDecimal getParentcode() {
		return this.parentcode;
	}

	public void setParentcode(BigDecimal parentcode) {
		this.parentcode = parentcode;
	}

	public List<GlmsQuizItem> getGlmsQuizItems() {
		return this.glmsQuizItems;
	}

	public void setGlmsQuizItems(List<GlmsQuizItem> glmsQuizItems) {
		this.glmsQuizItems = glmsQuizItems;
	}

	public GlmsQuizItem addGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		getGlmsQuizItems().add(glmsQuizItem);
		glmsQuizItem.setGlmsCommoncode(this);

		return glmsQuizItem;
	}

	public GlmsQuizItem removeGlmsQuizItem(GlmsQuizItem glmsQuizItem) {
		getGlmsQuizItems().remove(glmsQuizItem);
		glmsQuizItem.setGlmsCommoncode(null);

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
		glmsQuizSet.setGlmsCommoncode(this);

		return glmsQuizSet;
	}

	public GlmsQuizSet removeGlmsQuizSet(GlmsQuizSet glmsQuizSet) {
		getGlmsQuizSets().remove(glmsQuizSet);
		glmsQuizSet.setGlmsCommoncode(null);

		return glmsQuizSet;
	}

}