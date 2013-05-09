package com.orize.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Projet entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "projet", catalog = "orize_test")
public class Projet implements java.io.Serializable {

	// Fields

	private Integer id;
	private Groupe groupe;
	private String nom;
	private String description;
	private String dtCreation;
	private String dtModification;
	private String statu;
	private Set<MembreProjet> membreProjets = new HashSet<MembreProjet>(0);
	private Set<Planning> plannings = new HashSet<Planning>(0);

	// Constructors

	/** default constructor */
	public Projet() {
	}

	/** minimal constructor */
	public Projet(Groupe groupe, String nom, String description,
			String dtCreation, String dtModification, String statu) {
		this.groupe = groupe;
		this.nom = nom;
		this.description = description;
		this.dtCreation = dtCreation;
		this.dtModification = dtModification;
		this.statu = statu;
	}

	/** full constructor */
	public Projet(Groupe groupe, String nom, String description,
			String dtCreation, String dtModification, String statu,
			Set<MembreProjet> membreProjets, Set<Planning> plannings) {
		this.groupe = groupe;
		this.nom = nom;
		this.description = description;
		this.dtCreation = dtCreation;
		this.dtModification = dtModification;
		this.statu = statu;
		this.membreProjets = membreProjets;
		this.plannings = plannings;
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
	@JoinColumn(name = "id_grp", nullable = false)
	public Groupe getGroupe() {
		return this.groupe;
	}

	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Column(name = "description", nullable = false, length = 1000)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "dt_creation", nullable = false, length = 50)
	public String getDtCreation() {
		return this.dtCreation;
	}

	public void setDtCreation(String dtCreation) {
		this.dtCreation = dtCreation;
	}

	@Column(name = "dt_modification", nullable = false, length = 50)
	public String getDtModification() {
		return this.dtModification;
	}

	public void setDtModification(String dtModification) {
		this.dtModification = dtModification;
	}

	@Column(name = "statu", nullable = false, length = 100)
	public String getStatu() {
		return this.statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projet")
	public Set<MembreProjet> getMembreProjets() {
		return this.membreProjets;
	}

	public void setMembreProjets(Set<MembreProjet> membreProjets) {
		this.membreProjets = membreProjets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projet")
	public Set<Planning> getPlannings() {
		return this.plannings;
	}

	public void setPlannings(Set<Planning> plannings) {
		this.plannings = plannings;
	}

}