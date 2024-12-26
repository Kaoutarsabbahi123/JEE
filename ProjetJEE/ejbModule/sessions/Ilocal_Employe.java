package sessions;

import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;
import Entities.Employe;
import Entities.Login;
import Entities.Stage;
import Entities.Stagiaire;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
@Stateless
@LocalBean
public class Ilocal_Employe implements Ilocal_EmployeLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
	@EJB
     private Ilocal_StageLocal stagelocal;
	
	@Override
	public void addEmploye(Employe E) {
		em.persist(E);
		
	}

	@Override
	public void deleteEmploye(Employe E) {
		em.remove(E);
		
	}

	@Override
	public Employe getEmploye(int code) {
		 Employe E= em.find(Employe.class,code);
		 return E;
	}

	@Override
	public Employe getEmployeByNom(String Nom) {
		 Employe E= em.find(Employe.class,Nom);
		 return E;
	}

	@Override
	public Employe getEmployeByPrenom(String prenom) {
		 Employe E= em.find(Employe.class,prenom);
		 return E;	
		 }

	@Override
	public void updateEmploye(Employe E) {
		em.merge(E);
	}
	public void Supprimeremploye(int id) {
		String sql = "UPDATE Employe SET etat = 'en archive' WHERE id_emp = :id";

	    // Create the native query
	    Query query = em.createNativeQuery(sql);
	    query.setParameter("id", id);

	    // Execute the update query
	    query.executeUpdate();
	}
	@Override
	public List<Employe> getallEmploye() {
		String sql="select * from Employe where etat NOT LIKE '%en archive%'";
		Query query = em.createNativeQuery(sql, Employe.class);
		List<Employe> listEmploye=query.getResultList();
		return listEmploye;
	}
	public List<Employe> searchEmploye(String keyword) {
	    String nativeQuery = "SELECT * FROM Employe l, departement d WHERE " +
	        "d.id_dep = l.departement_id_dep AND  " +
	        "(l.id_emp LIKE :keyword OR " +
	        "l.cin LIKE :keyword OR " +
	        "l.nom LIKE :keyword OR " +
	        "l.prenom LIKE :keyword OR " +
	        "l.statut LIKE :keyword OR " +
	        "CAST(l.dat_naiss AS CHAR) LIKE :keyword OR " +
	        "l.adresse LIKE :keyword OR " +
	        "l.email LIKE :keyword OR " +
	        "l.tel LIKE :keyword OR " +
	        "d.nom_dep LIKE :keyword)";

	    Query query = em.createNativeQuery(nativeQuery, Employe.class);

	    query.setParameter("keyword", "%" + keyword + "%");
	    List<Employe> result = query.getResultList();

	    return result;
	}

	@Override
	public boolean supprimerEmployeSiConditionsRemplies(int idEmp) {
	    Employe employe = this.getEmploye(idEmp);

	    if (employe != null) {
	        String statut = employe.getStatut();

	        // Vérifier les conditions pour la suppression
	        if ("non affecte".equals(statut) || ("affecte".equals(statut) && stageTermine(employe))) {
	            this.Supprimeremploye(idEmp);
	            return true;
	        }
	        else {
	        	return false;
	        }
	    }
	    return false;
	}

	// Méthode pour vérifier si le stage est terminé
	private boolean stageTermine(Employe employe) {
	    employe.setStages(stagelocal.getListeStagesParEmploye(employe.getId_emp()));
	    List<Stage> stages = employe.getStages();
	    LocalDate aujourdhui = LocalDate.now();
	    for (Stage stage : stages) {
	        if (stage.getDate_fin().toLocalDate().isBefore(aujourdhui)) {
	            return true;
	        }
	    }
	    return false;
	} 
	@Override
	public int nbremployeaffecte() {
	    String sql = "SELECT count(*) FROM employe WHERE statut LIKE '%affecte%'";
	    // Create the native query
	    Query query = em.createNativeQuery(sql);
	    // Execute the query and return the result
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}

	@Override
	public int nbremployenonaffecte() {
	    String sql = "SELECT count(*) FROM employe WHERE statut LIKE '%non affecte%'";
	    // Create the native query
	    Query query = em.createNativeQuery(sql);
	    // Execute the query and return the result
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}


   
   
}
