package sessions;

import java.util.List;

import Entities.Departement;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class Ilocal_Departement
 */
@Stateless
@LocalBean
public class Ilocal_Departement implements Ilocal_DepartementLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
    public Ilocal_Departement() {
        // TODO Auto-generated constructor stub
    }
    public Departement getDepartement(int code) {
    	Departement d=em.find(Departement.class,code);
    	return d;
    }
    public List<Departement> getalldepartement(){
    	String sql ="SELECT * from departement";
    	Query q=em.createNativeQuery(sql,Departement.class);
    	List<Departement> departements=q.getResultList();
    	return departements;
    	
    }
    public Departement getdepartementbynom(String nom) {
    	    String sql="SELECT * from departement where nom_dep =?";
    	    Query q=em.createNativeQuery(sql,Departement.class);
    	    q.setParameter(1,nom);
    	    Departement d=(Departement) q.getSingleResult();
    	    return d;
    }
}
