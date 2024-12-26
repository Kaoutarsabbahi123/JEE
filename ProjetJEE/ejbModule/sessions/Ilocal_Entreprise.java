package sessions;


import Entities.Entreprise;
import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 * Session Bean implementation class Ilocal_Entreprise
 */
@Stateless
@LocalBean
public class Ilocal_Entreprise implements Ilocal_EntrepriseLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
    public Ilocal_Entreprise() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public Entreprise getEntreprise(int code) {
		Entreprise E= em.find(Entreprise.class,code);
		 return E;	
	}
}
