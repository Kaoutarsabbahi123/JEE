package Entities;

public enum Type {
		 PFA("PFA"),PFE("PFE"),INITIATION("INITIATION"),OBSERVATION("OBSERVATION");
		private String nom;

		private Type(String nom) {
			this.nom = nom;
		}

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		    public static Type fromnom(String nom) {
		        for (Type type_stage :Type.values()) {
		            if (type_stage.nom.equalsIgnoreCase(nom)) {
		                return type_stage;
		            }
		        }
		        throw new IllegalArgumentException("type inconnue par le nom" + nom);
		    }

	}


