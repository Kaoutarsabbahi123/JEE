package Entities;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="division")
public class Division implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_div")
	private int id_div;
	@Column(name = "nom_div")
	private String nom_div;
	@OneToMany(mappedBy="division")
	private List<Departement> departments;
	@ManyToOne
	@JoinColumn(name="id_entrp")
	private Entreprise entrp;
	@OneToMany(mappedBy="division")
	public List<Stage> stages;
	public int getId_div() {
		return id_div;
	}
	public void setId_div(int id_div) {
		this.id_div = id_div;
	}
	public String getNom_div() {
		return nom_div;
	}
	public void setNom_div(String nom_div) {
		this.nom_div = nom_div;
	}
	public List<Departement> getDepartments() {
		return departments;
	}
	public void setDepartments(List<Departement> departments) {
		this.departments = departments;
	}
	public Entreprise getEntrp() {
		return entrp;
	}
	public void setEntrp(Entreprise entrp) {
		this.entrp = entrp;
	}
	public List<Stage> getStages() {
		return stages;
	}
	public void setStages(List<Stage> stages) {
		this.stages = stages;
	}
	public Division(String nom_div) {
		super();
		this.nom_div = nom_div;
	}
	public Division() {
		super();
		// TODO Auto-generated constructor stub
	}
	
} 