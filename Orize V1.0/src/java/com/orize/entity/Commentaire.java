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
 * Commentaire entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "commentaire", catalog = "orize_test")
public class Commentaire implements java.io.Serializable {

	// Fields

	private Integer id;
	private Profil profil;
	private Publication publication;
	private String commentaire;

	// Constructors

	/** default constructor */
	public Commentaire() {
	}

	/** full constructor */
	public Commentaire(Profil profil, Publication publication,
			String commentaire) {
		this.profil = profil;
		this.publication = publication;
		this.commentaire = commentaire;
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
	@JoinColumn(name = "id_pub", nullable = false)
	public Publication getPublication() {
		return this.publication;
	}

	public void setPublication(Publication publication) {
		this.publication = publication;
	}

	@Column(name = "commentaire", nullable = false, length = 1000)
	public String getCommentaire() {
		return this.commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

    public void setPublication(Publication1 publication1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}