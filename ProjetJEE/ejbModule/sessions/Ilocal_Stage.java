package sessions;

import java.math.BigInteger;
import java.time.LocalDate;
import java.util.List;
import Entities.Stage;
import Entities.Stagiaire;
import Entities.Employe;
import Entities.Etat_stage;
import Entities.Etat_stagiaire;
import Entities.Statut;
import Entities.Type;
import jakarta.ejb.EJB;
import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class Ilocal_Stage
 */
@Stateless
@LocalBean
public class Ilocal_Stage implements Ilocal_StageLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
	@EJB
	private Ilocal_Stagiaire local_stagiaire;
    public Ilocal_Stage() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void addStage(Stage S) {
		em.persist(S);
	}

	@Override
	public void deleteStage(Stage S) {
		em.remove(S);
		
	}

	@Override
	public Stage getStage(int code) {
		 Stage S= em.find(Stage.class,code);
		 return S;
	}

	@Override
	public Stage getStageSujet(String Sujet) {
			Stage S= em.find(Stage.class,Sujet);
			 return S;
		}

	@Override
	public Stage getStageType(Type type) {
		Stage S= em.find(Stage.class,type);
		 return S;
	}

	@Override
	public Stage getStageStatut(Statut statut) {
		Stage S= em.find(Stage.class,statut);
		 return S;
	}

	@Override
	public Stage getStageEtat(Etat_stage Etat) {
		Stage S= em.find(Stage.class,Etat);
		 return S;
	}

	@Override
	public void updateStage(Stage S) {
		em.merge(S);
		
	}

	@Override
	public List<Stage> getallStage() {
	    String sql = "SELECT * FROM Stage WHERE etat Like '%non archive%'";
	    Query query = em.createNativeQuery(sql, Stage.class);
	    List<Stage> listStages = query.getResultList();
	    return listStages;
	}


	@Override
	public List<Stage> getListeStagesParEmploye(int idEmp) {
		   String sqlQuery = "SELECT * FROM Stage s WHERE s.encadrant_id_emp = :idEmp";
	        Query query = em.createNativeQuery(sqlQuery, Stage.class);
	        query.setParameter("idEmp ", idEmp);

	        return query.getResultList();

	}
	public List<Stage> searchstage(String keyword) {
	    String nativeQuery = "SELECT * FROM Stage s, division d , employe e  WHERE " +
	        "s.division_id_div = d.id_div AND  " +
	        "s.encadrant_id_emp = e.id_emp AND  " +
	        "(s.id_stage LIKE :keyword OR " +
	        "s.sujet LIKE :keyword OR " +
	        "s.statut LIKE :keyword OR " +
	        "s.type LIKE :keyword OR " +
	        "CAST(s.date_debut AS CHAR) LIKE :keyword OR " +
	        "CAST(s.date_fin AS CHAR) LIKE :keyword OR " +
	        "d.nom_div LIKE :keyword OR " +
	        "e.nom LIKE :keyword OR " +
	        "e.prenom LIKE :keyword )" ;

	    Query query = em.createNativeQuery(nativeQuery, Stage.class);

	    query.setParameter("keyword", "%" + keyword + "%");
	    List<Stage> result = query.getResultList();

	    return result;
	}
	@Override
	public boolean supprimerStageSiConditionsRemplies(int idstage) {
	    Stage stage=this.getStage(idstage);

	    if (stage != null) {
	        String statut = stage.getStatut();
	        LocalDate aujourdhui = LocalDate.now();
	        
	        if ("non affecte".equals(statut) ) {
	        	String sql = "UPDATE Stage SET etat = 'archive' WHERE id_stage = :id";
	    	   
	    	    Query query = em.createNativeQuery(sql);
	    	    query.setParameter("id", idstage);
	    	 
	    	    query.executeUpdate();
	            return true;
	        }
	        else if("affecte".equals(statut) && stage.getDate_fin().toLocalDate().isBefore(aujourdhui)) {
	        	List<Stagiaire> stagiaires=this.local_stagiaire.getstagiairebystage(idstage);
	        	for (Stagiaire stagiaire : stagiaires) {
	    	        stagiaire.setEtat(Etat_stagiaire.EN_ARCHIVE.getNom());
	    	        local_stagiaire.updateStagiaire(stagiaire);
	    	    }
	        	String sql = "UPDATE Stage SET etat = 'archive' , statut='non affecte' WHERE id_stage = :id";
	    	    
	    	    Query query = em.createNativeQuery(sql);
	    	    query.setParameter("id", idstage);
	    	    
	    	    query.executeUpdate();
	        	return true;
	        }
	        else {
	        	return false;
	        }
	    }
	    return false;
	}
	@Override
	public int nbrstageaffecte() {
	    String sql = "SELECT count(*) FROM Stage WHERE statut LIKE '%affecte%'";
	   
	    Query query = em.createNativeQuery(sql);
	    
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}

	@Override
	public int nbrstagenonaffecte() {
	    String sql = "SELECT count(*) FROM Stage WHERE statut LIKE '%non affecte%'";
	    
	    Query query = em.createNativeQuery(sql);
	    
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}

   

}
