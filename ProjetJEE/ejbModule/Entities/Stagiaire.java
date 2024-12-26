package Entities;

import java.io.Serializable;


import java.sql.Date;
import java.util.HashMap;
import java.util.Map;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MapKeyColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
@Table(name="Stagiaire")
public class Stagiaire implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_stagiaire")
	private int id_stagiaire;
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
	@Column(name="etablissement")
	private String etablissment;
	@Column(name="filiere")
	private String filiere;
	@Column(name="etat")
	private String etat;
	@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "map_table", joinColumns = @JoinColumn(name = "id_stagiaire"))
    @MapKeyColumn(name = "cle_map")
    @Column(name = "valeur_map")
	private Map<Date,Boolean> liste_abscences;
    @ManyToOne
    private Stage stage;
    @OneToOne 
	@JoinColumn(name="id_attestation")
	private Attestation attestation;
	public int getId_stagiaire() {
		return id_stagiaire;
	}

	public void setId_stagiaire(int id_stagiaire) {
		this.id_stagiaire = id_stagiaire;
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

	public String getEtablissment() {
		return etablissment;
	}

	public void setEtablissment(String etablissment) {
		this.etablissment = etablissment;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public Map<Date, Boolean> getListe_abscences() {
		return liste_abscences;
	}

	public void setListe_abscences(Map<Date, Boolean> liste_abscences) {
		this.liste_abscences = liste_abscences;
	}

	public Stagiaire(int id_stagiaire, String cin, String nom, String prenom, String adresse, String tel,
			Date dat_naiss, String email, String etablissment, String filiere, Map<Date, Boolean> liste_abscences) {
		super();
		this.id_stagiaire = id_stagiaire;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.tel = tel;
		this.dat_naiss = dat_naiss;
		this.email = email;
		this.etablissment = etablissment;
		this.filiere = filiere;
		this.liste_abscences = liste_abscences;
	}

	public Stagiaire() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public String getEtat() {
		return etat;
	}

	public void setEtat(String etat) {
		this.etat = etat;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public Attestation getAttestation() {
		return attestation;
	}

	public void setAttestation(Attestation attestation) {
		this.attestation = attestation;
	}
	@Transactional
	public void ajouterAbsence(Date dateAbsence, boolean estAbsent) {
	    if (liste_abscences == null) {
	        liste_abscences = new HashMap<>();
	    }
	    liste_abscences.size();
	    liste_abscences.put(dateAbsence, estAbsent);
	}


}
