package Entities;

public enum Etat_stagiaire {
	NOUVEAU("nouveau"),EN_COURS("en cours"),EN_ARCHIVE("en archive");
	private String nom;

	private Etat_stagiaire(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	    public static Etat_stagiaire fromnom(String nom) {
	        for (Etat_stagiaire etat_stagiaire :Etat_stagiaire.values()) {
	            if (etat_stagiaire.nom.equalsIgnoreCase(nom)) {
	                return etat_stagiaire;
	            }
	        }
	        throw new IllegalArgumentException("type inconnue par le nom" + nom);
	    }

}
