package Entities;

public enum Etat_stage{
	 ARCHIVE("archive"),NON_ARCHIVE("non archive");
	private String nom;

	private Etat_stage(String nom) {
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	    public static Etat_stage fromnom(String nom) {
	        for (Etat_stage etat_stage :Etat_stage.values()) {
	            if (etat_stage.nom.equalsIgnoreCase(nom)) {
	                return etat_stage;
	            }
	        }
	        throw new IllegalArgumentException("type inconnue par le nom" + nom);
	    }

}