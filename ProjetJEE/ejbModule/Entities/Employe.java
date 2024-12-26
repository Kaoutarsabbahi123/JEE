package Entities;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="employe")
public class Employe implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_emp")
	private int id_emp;
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
	@Column(name = "statut")
	private String statut;
	@Column(name="etat")
	private String etat;
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	@ManyToOne
	private Departement departement;
	@OneToMany(mappedBy="encadrant")
	private List<Stage> stages;
	public int getId_emp() {
		return id_emp;
	}
	public void setId_emp(int id_emp) {
		this.id_emp = id_emp;
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
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}
	public Employe(String cin, String nom, String prenom, String adresse, String tel, Date dat_naiss, String email,
			String statut) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.dat_naiss = dat_naiss;
		this.email = email;
		this.statut = statut;
	}
	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}
}
