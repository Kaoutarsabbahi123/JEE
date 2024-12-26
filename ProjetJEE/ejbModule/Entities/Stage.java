package Entities;

import java.io.Serializable;



import java.sql.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
@Entity
@Table(name="Stage")
public class Stage implements Serializable {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stage")
	private int id_stage;
	@Column(name = "sujet")
	private String Sujet;
	@Column(name = "date_debut")
	private Date date_debut;
	@Column(name = "date_fin")
	private Date date_fin;
	@Column(name = "type")
	private String type;
	@Column(name = "statut")
	private String statut;
	@Column(name = "etat")
	private String etat;
	@ManyToOne
	private Employe encadrant;
	@ManyToOne
	private Division division;
	public Employe getEncadrant() {
		return encadrant;
	}
	public void setEncadrant(Employe encadrant) {
		this.encadrant = encadrant;
	}
	public Division getDivision() {
		return division;
	}
	public void setDivision(Division division) {
		this.division = division;
	}
	public List<Stagiaire> getStagiaires() {
		return stagiaires;
	}
	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}
	@OneToMany(mappedBy="stage")
	private List<Stagiaire> stagiaires;
	public int getId_stage() {
		return id_stage;
	}
	public void setId_stage(int id_stage) {
		this.id_stage = id_stage;
	}
	public String getSujet() {
		return Sujet;
	}
	public void setSujet(String sujet) {
		Sujet = sujet;
	}
	public Date getDate_debut() {
		return date_debut;
	}
	public void setDate_debut(Date date_debut) {
		this.date_debut = date_debut;
	}
	public Date getDate_fin() {
		return date_fin;
	}
	public void setDate_fin(Date date_fin) {
		this.date_fin = date_fin;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public Stage(String sujet, Date date_debut, Date date_fin, String type, String statut,  String etat) {
		super();
		Sujet = sujet;
		this.date_debut = date_debut;
		this.date_fin = date_fin;
		this.type = type;
		this.statut = statut;
		this.etat = etat;
	}
	public Stage() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
