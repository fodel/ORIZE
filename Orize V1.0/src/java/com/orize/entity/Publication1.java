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
 * Publication entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "publication1", catalog = "orize_test")
public class Publication1 implements java.io.Serializable {

	// Fields

	private Integer id;
	private Profil profil;
	
	private String publication;
	private Set<Commentaire> commentaires = new HashSet<Commentaire>(0);

	// Constructors

	/** default constructor */
	public Publication1() {
	}

	/** minimal constructor */
	public Publication1(Profil profil, String publication) {
		this.profil = profil;
		
		this.publication = publication;
	}

	/** full constructor */
	public Publication1(Profil profil, String publication,
			Set<Commentaire> commentaires) {
		this.profil = profil;
		
		this.publication = publication;
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
	@JoinColumn(name = "id_profil", nullable = false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}


	

	@Column(name = "publication", nullable = false, length = 1000)
	public String getPublication() {
		return this.publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "publication")
	public Set<Commentaire> getCommentaires() {
		return this.commentaires;
	}

	public void setCommentaires(Set<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

 

}