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
 * Image entity. @author MyEclipse Persistence Tools
 */
    @Entity
@Table(name = "image", schema = "orize_test")
public class Image implements java.io.Serializable {

	// Fields

	private Integer id;
	private byte[] file;
	private String descreption;
	private Profil profil;

	// Constructors

	/** default constructor */
	public Image() {
	}

	/** full constructor */
	public Image(Profil profil, byte[] file, String descreption) {
		this.file = file;
		this.descreption = descreption;
                this.profil = profil;
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

	@Column(name = "file")
	public byte[] getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	@Column(name = "description")
	public String getDescreption() {
		return this.descreption;
	}

	public void setDescreption(String descreption) {
		this.descreption = descreption;
	}
        
        @ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_profil", nullable = false)
	public Profil getProfil() {
		return this.profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

}