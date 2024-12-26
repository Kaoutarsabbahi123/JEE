package Entities;

import java.io.Serializable;
import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity 
@Table(name="attestation")
public class Attestation implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_attestation")
	private int id_attestation;
	@Column(name = "date_attestation")
	private Date date_attestation;
	@Column(name = "contenu_fichier")
	private byte[] contenu_fichier;
	@OneToOne(mappedBy="attestation")
	private Stagiaire stagiaire;
	public int getId_attestation() {
		return id_attestation;
	}
	public void setId_attestation(int id_attestation) {
		this.id_attestation = id_attestation;
	}
	public Date getDate_attestation() {
		return date_attestation;
	}
	public void setDate_attestation(Date date_attestation) {
		this.date_attestation = date_attestation;
	}
	public byte[] getContenu_fichier() {
		return contenu_fichier;
	}
	public void setContenu_fichier(byte[] contenu_fichier) {
		this.contenu_fichier = contenu_fichier;
	}
	public Attestation(Date date_attestation, byte[] contenu_fichier) {
		super();
		this.date_attestation = date_attestation;
		this.contenu_fichier = contenu_fichier;
	}
	public Attestation() {
		super();
		// TODO Auto-generated constructor stub
	}
	 

}
