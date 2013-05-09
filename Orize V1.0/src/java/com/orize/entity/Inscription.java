package com.orize.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Inscription entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "inscription", catalog = "orize_test")
public class Inscription implements java.io.Serializable {

	// Fields

	private Integer id;
	private Profil profil;
	private Groupe groupe;
	private String dtInscri;
	private String role;

	// Constructors

	/** default constructor */
	public Inscription() {
	}

	/** full constructor */
	public Inscription(Profil profil, Groupe groupe, String dtInscri,
			String role) {
		this.profil = profil;
		this.groupe = groupe;
		this.dtInscri = dtInscri;
		this.role = role;
	}

	// Property accessors
	@GenericGenerator(name = "generator", strategy = "increment")
	@Id
	@GeneratedValue(generator = "generator")
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profil", nullable = false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_grp", nullable = false)
	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@Column(name = "dt_inscri", nullable = false, length = 50)
	public String getDtInscri() {
		return this.dtInscri;
	}

	public void setDtInscri(String dtInscri) {
		this.dtInscri = dtInscri;
	}

	@Column(name = "role", nullable = false, length = 50)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}