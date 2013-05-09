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
 * Planning entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "planning", catalog = "orize_test")
public class Planning implements java.io.Serializable {

	// Fields

	private Integer id;
	private Projet projet;
	private String dtDebut;
	private String dtFin;
	private String nomTache;
	private String tache;

	// Constructors

	/** default constructor */
	public Planning() {
	}

	/** full constructor */
	public Planning(Projet projet, String dtDebut, String dtFin,
			String nomTache, String tache) {
		this.projet = projet;
		this.dtDebut = dtDebut;
		this.dtFin = dtFin;
		this.nomTache = nomTache;
		this.tache = tache;
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
	@JoinColumn(name = "id_projet", nullable = false)
	public Projet getProjet() {
		return this.projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	@Column(name = "dt_debut", nullable = false, length = 50)
	public String getDtDebut() {
		return this.dtDebut;
	}

	public void setDtDebut(String dtDebut) {
		this.dtDebut = dtDebut;
	}

	@Column(name = "dt_fin", nullable = false, length = 50)
	public String getDtFin() {
		return this.dtFin;
	}

	public void setDtFin(String dtFin) {
		this.dtFin = dtFin;
	}

	@Column(name = "nom_tache", nullable = false, length = 100)
	public String getNomTache() {
		return this.nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	@Column(name = "tache", nullable = false, length = 1000)
	public String getTache() {
		return this.tache;
	}

	public void setTache(String tache) {
		this.tache = tache;
	}

}