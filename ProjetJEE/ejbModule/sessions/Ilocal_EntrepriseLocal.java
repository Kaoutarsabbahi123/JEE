package sessions;

import Entities.Entreprise;
import jakarta.ejb.Local;

@Local
public interface Ilocal_EntrepriseLocal {
	public Entreprise getEntreprise(int code);
}
