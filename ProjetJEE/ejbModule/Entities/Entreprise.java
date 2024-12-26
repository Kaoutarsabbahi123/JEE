package Entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Entreprise")
public class Entreprise implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entrp")
	private int id_entrp;
	@Column(name = "nom_entrp")
	private String nom;
	@Column(name = "logo_entrp")
	private byte[] logo;
	@Column(name = "ville_entrp")
	private String ville;
	@OneToMany(mappedBy="entrp")
	private List<Division> divisions;
	public Entreprise(String nom, byte[] logo, String ville) {
		super();
		this.nom = nom;
		this.logo = logo;
		this.ville = ville;
	}
	public Entreprise() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id_entrp;
	}
	public void setId(int id) {
		this.id_entrp = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public byte[] getLogo() {
		return logo;
	}
	public void setLogo(byte[] logo) {
		this.logo = logo;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
}
