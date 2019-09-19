package com.poe.javatos.bean;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="t_utilisateur")
public class Utilisateur 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "nom")
	private String nom;
	
	@Column(name = "prenom")
	private String prenom;
	
	@Column(name = "fonction")
	private String fonction;
	
	@ManyToMany
	@JoinTable(name = "t_utilisateur_has_t_role", 
	joinColumns = {@JoinColumn(name = "t_utilisateur_id", referencedColumnName = "id" )})
	private List<RoleUtilisateur> roles;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getFonction() {
		return fonction;
	}

	public void setFonction(String fonction) {
		this.fonction = fonction;
	}

	public List<RoleUtilisateur> getRoles() {
		return roles;
	}

	public void setRoles(List<RoleUtilisateur> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", username=" + username + ", password=" + password + ", nom=" + nom
				+ ", prenom=" + prenom + ", fonction=" + fonction + ", roles=" + roles + "]";
	}
	
	
}
