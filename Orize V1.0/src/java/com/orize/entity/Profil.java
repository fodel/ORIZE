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
import javax.persistence.UniqueConstraint;
import org.hibernate.annotations.GenericGenerator;

/**
 * Profil entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "profil", catalog = "orize_test", uniqueConstraints = @UniqueConstraint(columnNames = "pseudo"))
public class Profil implements java.io.Serializable {

	// Fields

	private Integer id;
	private Utilisateur utilisateur;
	private String pseudo;
	private String adresse;
	private Integer tel;
	private String nom;
        private String prenom;
	private Set<Inscription> inscriptions = new HashSet<Inscription>(0);
	private Set<MembreProjet> membreProjets = new HashSet<MembreProjet>(0);
	private Set<Publication> publications = new HashSet<Publication>(0);
	private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);

	// Constructors

	/** default constructor */
	public Profil() {
	}

	/** minimal constructor */
	public Profil(Utilisateur utilisateur, String pseudo,String nom,String prenom,String adresse,
			Integer tel) {
		this.utilisateur = utilisateur;
		this.pseudo = pseudo;
		this.adresse = adresse;
		this.tel = tel;
		this.nom = nom;
                this.prenom= prenom;
	}

	/** full constructor */
	public Profil(Utilisateur utilisateur, String pseudo, String adresse,
			Integer tel, String nom,String prenom, Set<Inscription> inscriptions,
			Set<MembreProjet> membreProjets, Set<Publication> publications,
			Set<Commentaire> commentaires) {
		this.utilisateur = utilisateur;
		this.pseudo = pseudo;
		this.adresse = adresse;
		this.tel = tel;
		this.nom = nom;
                this.prenom= prenom;
		this.inscriptions = inscriptions;
		this.membreProjets = membreProjets;
		this.publications = publications;
		this.commentaires = commentaires;
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
	@JoinColumn(name = "id_user", nullable = false)
	public Utilisateur getUtilisateur() {
		return this.utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	@Column(name = "pseudo", unique = true, nullable = false, length = 50)
	public String getPseudo() {
		return this.pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	@Column(name = "adresse", nullable = false, length = 50)
	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@Column(name = "tel", nullable = false)
	public Integer getTel() {
		return this.tel;
	}

	public void setTel(Integer tel) {
		this.tel = tel;
	}

	@Column(name = "nom", nullable = false, length = 50)
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

        
	@Column(name = "prenom", nullable = false, length = 50)
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<Inscription> getInscriptions() {
		return this.inscriptions;
	}

	public void setInscriptions(Set<Inscription> inscriptions) {
		this.inscriptions = inscriptions;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<MembreProjet> getMembreProjets() {
		return this.membreProjets;
	}

	public void setMembreProjets(Set<MembreProjet> membreProjets) {
		this.membreProjets = membreProjets;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<Publication> getPublications() {
		return this.publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "profil")
	public Set<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

}