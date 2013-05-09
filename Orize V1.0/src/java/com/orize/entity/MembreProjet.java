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
 * MembreProjet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "membre_projet", catalog = "orize_test")
public class MembreProjet implements java.io.Serializable {

	// Fields

	private Integer id;
	private Profil profil;
	private Projet projet;
	private String role;

	// Constructors

	/** default constructor */
	public MembreProjet() {
	}

	/** full constructor */
	public MembreProjet(Profil profil, Projet projet, String role) {
		this.profil = profil;
		this.projet = projet;
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
	@JoinColumn(name = "id_projet", nullable = false)
	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Column(name = "role", nullable = false, length = 100)
	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}