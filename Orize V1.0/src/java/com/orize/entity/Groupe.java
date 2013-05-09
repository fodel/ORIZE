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
 * Groupe entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "groupe", catalog = "orize_test")
public class Groupe implements java.io.Serializable {

	// Fields

	private Integer id;
	private Groupe groupe;
	private String nom;
	private String dtCreation;
	private String dtModification;
	private String objectifs;
	private String strategie;
	private String statu;
	private Set<Groupe> groupes = new HashSet<Groupe>(0);
	private Set<Projet> projets = new HashSet<Projet>(0);
	private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	private Set<Publication> publications = new HashSet<Publication>(0);

	// Constructors

	/** default constructor */
	public Groupe() {
	}

	/** minimal constructor */
	public Groupe(String nom, String dtCreation, String dtModification,
			String objectifs, String strategie, String statu) {
		this.nom = nom;
		this.dtCreation = dtCreation;
		this.dtModification = dtModification;
		this.objectifs = objectifs;
		this.strategie = strategie;
		this.statu = statu;
	}

	/** full constructor */
	public Groupe(Groupe groupe, String nom, String dtCreation,
			String dtModification, String objectifs, String strategie,
			String statu, Set<Groupe> groupes, Set<Projet> projets,
			Set<Inscription> inscriptions, Set<Publication> publications) {
		this.groupe = groupe;
		this.nom = nom;
		this.dtCreation = dtCreation;
		this.dtModification = dtModification;
		this.objectifs = objectifs;
		this.strategie = strategie;
		this.statu = statu;
		this.groupes = groupes;
		this.projets = projets;
		this.inscriptions = inscriptions;
		this.publications = publications;
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
	@JoinColumn(name = "id_grp")
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

	@Column(name = "objectifs", nullable = false, length = 500)
	public String getObjectifs() {
		return this.objectifs;
	}

	public void setObjectifs(String objectifs) {
		this.objectifs = objectifs;
	}

	@Column(name = "strategie", nullable = false, length = 500)
	public String getStrategie() {
		return this.strategie;
	}

	public void setStrategie(String strategie) {
		this.strategie = strategie;
	}

	@Column(name = "statu", nullable = false, length = 50)
	public String getStatu() {
		return this.statu;
	}

	public void setStatu(String statu) {
		this.statu = statu;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupe")
	public Set<Groupe> getGroupes() {
		return this.groupes;
	}

	public void setGroupes(Set<Groupe> groupes) {
		this.groupes = groupes;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupe")
	public Set<Projet> getProjets() {
		return this.projets;
	}

	public void setProjets(Set<Projet> projets) {
		this.projets = projets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupe")
	public Set<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "groupe")
	public Set<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

}