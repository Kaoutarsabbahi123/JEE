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
@Table(name="departement")
public class Departement implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_dep")
	private int id_dep;
	@Column(name = "nom_dep")
	private String nom_dep;
	@ManyToOne
	@JoinColumn(name="id_div")
	private Division division;
	@OneToMany(mappedBy="departement")
	private List<Employe> employes;
	public int getId_dep() {
		return id_dep;
	}
	public void setId_dep(int id_dep) {
		this.id_dep = id_dep;
	}
	public String getNom_dep() {
		return nom_dep;
	}
	public void setNom_dep(String nom_dep) {
		this.nom_dep = nom_dep;
	}
	public Departement(String nom_dep) {
		super();
		this.nom_dep = nom_dep;
	}
	public Departement() {
		super();
		// TODO Auto-generated constructor stub
	}
}
