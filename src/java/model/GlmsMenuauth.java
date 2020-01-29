package model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the GLMS_MENUAUTH database table.
 * 
 */
@Entity
@Table(name="GLMS_MENUAUTH")
@NamedQuery(name="GlmsMenuauth.findAll", query="SELECT g FROM GlmsMenuauth g")
public class GlmsMenuauth implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="MENUAUTH_IDX")
	private long menuauthIdx;

	private String menuname;

	private BigDecimal parentcode;

	//bi-directional many-to-one association to GlmsAuth
	@ManyToOne
	@JoinColumn(name="AUTH_IDX")
	private GlmsAuth glmsAuth;

	public GlmsMenuauth() {
	}

	public long getMenuauthIdx() {
		return this.menuauthIdx;
	}

	public void setMenuauthIdx(long menuauthIdx) {
		this.menuauthIdx = menuauthIdx;
	}

	public String getMenuname() {
		return this.menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}

	public BigDecimal getParentcode() {
		return this.parentcode;
	}

	public void setParentcode(BigDecimal parentcode) {
		this.parentcode = parentcode;
	}

	public GlmsAuth getGlmsAuth() {
		return this.glmsAuth;
	}

	public void setGlmsAuth(GlmsAuth glmsAuth) {
		this.glmsAuth = glmsAuth;
	}

}