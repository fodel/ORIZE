package com.orize.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.annotations.GenericGenerator;

/**
 * Utilisateur entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "utilisateur", catalog = "orize_test")
public class Utilisateur implements java.io.Serializable {

	// Fields

	private Integer id;
	private String email;
	private String login;
	private String password;
	private String questionSecrete;
	private String reponse;
	private Integer statu;
	private Set<Profil> profils = new HashSet<Profil>(0);

	// Constructors

	/** default constructor */
	public Utilisateur() {
	}

	/** minimal constructor */
	public Utilisateur(String email, String login,
			String password, Integer statu) {
		this.email = email;
		this.login = login;
		this.password = password;
		this.statu = statu;
	}

	/** full constructor */
	public Utilisateur(String email, String login,
			String password, String questionSecrete, String reponse,
			Integer statu, Set<Profil> profils) {
		this.email = email;
		this.login = login;
		this.password = password;
		this.questionSecrete = questionSecrete;
		this.reponse = reponse;
		this.statu = statu;
		this.profils = profils;
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

	@Column(name = "email", nullable = false, length = 50)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


	@Column(name = "login", nullable = false, length = 50)
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name = "password", nullable = false, length = 50)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "question_secrete", length = 100)
	public String getQuestionSecrete() {
		return this.questionSecrete;
	}

	public void setQuestionSecrete(String questionSecrete) {
		this.questionSecrete = questionSecrete;
	}

	@Column(name = "reponse", length = 100)
	public String getReponse() {
		return this.reponse;
	}

	public void setReponse(String reponse) {
		this.reponse = reponse;
	}

	@Column(name = "statu" )
	public Integer getStatu() {
		return this.statu;
	}

	public void setStatu(Integer statu) {
		this.statu = statu;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public Set<Profil> getProfils() {
		return this.profils;
	}

	public void setProfils(Set<Profil> profils) {
		this.profils = profils;
	}

}