package Entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
@Entity
@Table(name="login")
public class Login implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @Column(name = "id_login")
	private String id_login;
	@Column(name = "mot_passe")
	private String mot_passe;
	@Column(name = "role")
	private String role;
	@Column(name = "cin")
	private String cin;
	@Column(name = "nom")
	private String nom;
	@Column(name = "prenom")
	private String prenom;
	@Column(name = "adresse")
	private String adresse;
	@Column(name = "tel")
	private String tel;
	@Column(name = "dat_naiss")
	private Date dat_naiss;
	@Column(name = "email")
	private String email;
	public String getId_login() {
		return id_login;
	}
	public void setId_login(String id_login) {
		this.id_login = id_login;
	}
	public String getMot_passe() {
		return mot_passe;
	}
	public void setMot_passe(String mot_passe) {
		this.mot_passe = mot_passe;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Login(String id_login, String mot_passe, String role) {
		super();
		this.id_login = id_login;
		this.mot_passe = mot_passe;
		this.role = role;
	}
	
	public Login(String id_login, String mot_passe, String role, String cin, String nom, String prenom, String adresse,
			String tel, Date dat_naiss, String email) {
		super();
		this.id_login = id_login;
		this.mot_passe = mot_passe;
		this.role = role;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.dat_naiss = dat_naiss;
		this.email = email;
	}
	public Login() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
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
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getDat_naiss() {
		return dat_naiss;
	}
	public void setDat_naiss(Date dat_naiss) {
		this.dat_naiss = dat_naiss;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
