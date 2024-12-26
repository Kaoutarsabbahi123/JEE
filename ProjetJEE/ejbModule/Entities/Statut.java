package Entities;

public enum Statut {
    AFFECTE("affecte"),
    NON_AFFECTE("non affecte");

    private final String nom;

    Statut(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }
    public static Statut fromnom(String nom) {
        for (Statut statut : Statut.values()) {
            if (statut.getNom().equalsIgnoreCase(nom)) {
                return statut;
            }
        }
        throw new IllegalArgumentException("Type inconnu par le nom : " + nom);
    }

}

