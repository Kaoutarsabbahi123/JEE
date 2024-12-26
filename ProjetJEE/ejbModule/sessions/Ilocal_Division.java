package sessions;

import java.util.List;

import Entities.Departement;
import Entities.Division;
import Entities.Entreprise;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class Ilocal_Division
 */
@Stateless
@LocalBean
public class Ilocal_Division implements Ilocal_DivisionLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
    public Ilocal_Division() {
        // TODO Auto-generated constructor stub
    }
    @Override
	public Division getDivision(int code) {
		Division E= em.find(Division.class,code);
		 return E;	
	}
    @Override
    public List<Division> getalldivison(){
    	String sql ="SELECT * from division";
    	Query q=em.createNativeQuery(sql,Division.class);
    	List<Division> divisions=q.getResultList();
    	return  divisions;
    	
    }
}
