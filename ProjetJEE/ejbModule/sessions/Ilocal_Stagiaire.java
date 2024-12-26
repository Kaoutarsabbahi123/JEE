package sessions;

import java.math.BigInteger;
import java.sql.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Entities.Stagiaire;
import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;

import Entities.Etat_stagiaire;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
@LocalBean
public class Ilocal_Stagiaire implements Ilocal_StagiaireLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
    public Ilocal_Stagiaire() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addStagiaire(Stagiaire S) {
		em.persist(S);
	}
	@Override
	public void deleteStagiaire(Stagiaire S) {
		em.remove(S);	
	}
	@Override
	public Stagiaire getStagiaire(int code) {
		Stagiaire S= em.find(Stagiaire.class,code);
		 return S;
	}
	@Override
	public Stagiaire getStagiaireByCIN(String cin) {
		Stagiaire S= em.find(Stagiaire.class,cin);
		 return S;
	}
	
	@Override
	public Stagiaire getStagiaireByEtat(Etat_stagiaire Etat) {
		Stagiaire S= em.find(Stagiaire.class,Etat);
		 return S;
	}
	@Override
		public void updateStagiaire(Stagiaire S) {
		    em.merge(S);
		}
	@Override
	public List<Stagiaire> getallStagiaire() {
		String sql = "SELECT * FROM Stagiaire WHERE etat NOT LIKE '%en archive%'";

		
		Query query = em.createNativeQuery(sql, Stagiaire.class);

		
		List<Stagiaire> result = query.getResultList();
		return result;
	}
	@Override
	public List<Stagiaire> searchStagiaires(String keyword) {
	    String nativeQuery = "SELECT * FROM Stagiaire s WHERE " +
	    		"CAST(s.id_stagiaire AS CHAR) LIKE :keyword OR " +
	            "s.cin LIKE :keyword OR " +
	            "s.nom LIKE :keyword OR " +
	            "s.prenom LIKE :keyword OR " +
	            "s.etat LIKE :keyword OR " +
	            "CAST(s.dat_naiss AS CHAR) LIKE :keyword OR " +
	            "s.adresse LIKE :keyword OR " +
	            "s.etablissement LIKE :keyword OR " +
	            "s.filiere LIKE :keyword OR " +
	            "s.email LIKE :keyword OR " +
	            "s.tel LIKE :keyword";

	    Query query = em.createNativeQuery(nativeQuery, Stagiaire.class);

	    query.setParameter("keyword", "%" + keyword + "%");
	    List<Stagiaire> result=query.getResultList();

	    return result;
	}
	public void SupprimerStagiaire(int id) {
		String sql = "UPDATE Stagiaire SET etat = 'en archive' WHERE id_stagiaire = :id";

	    
	    Query query = em.createNativeQuery(sql);
	    query.setParameter("id", id);

	   
	    query.executeUpdate();
	}
	public List<Stagiaire> getstagiairebystage(int idstage){
		String sql = "SELECT * FROM Stagiaire WHERE stage_id_stage = :id";

		
		Query query = em.createNativeQuery(sql, Stagiaire.class);
        query.setParameter("id",idstage);
		
		List<Stagiaire> result = query.getResultList();
		return result;
	}
	@Override
	public List<Stagiaire> getlistestagiairenouveau() {
		String sql = "SELECT * FROM Stagiaire WHERE etat LIKE '%nouveau%' ";
		
		Query query = em.createNativeQuery(sql, Stagiaire.class);
		
		List<Stagiaire> result = query.getResultList();
		return result;
	}
	@Override
	public int nbrNouveauStagiaire() {
	    String sql = "SELECT count(*) FROM Stagiaire WHERE etat LIKE '%nouveau%' ";
	   
	    Query query = em.createNativeQuery(sql);
	   
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}

	@Override
	public int nbrencoursStagiaire() {
	    String sql = "SELECT count(*) FROM Stagiaire WHERE etat LIKE '%en cours%' ";
	   
	    Query query = em.createNativeQuery(sql);
	    
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}

	@Override
	public int nbrarchiveStagiaire() {
	    String sql = "SELECT count(*) FROM Stagiaire WHERE etat LIKE '%en archive%' ";
	    
	    Query query = em.createNativeQuery(sql);
	    
	    BigInteger result = (BigInteger) query.getSingleResult();
	    return result.intValue();
	}

	@Override
	public Map<Date, Boolean> getListeAbsencesStagiaire(int idStagiaire) {
	    String sql = "SELECT cle_map, valeur_map FROM map_table WHERE id_stagiaire = :idStagiaire";
	    Query query = em.createNativeQuery(sql);
	    query.setParameter("idStagiaire", idStagiaire);

	    List<Object[]> results = query.getResultList();
	    Map<Date, Boolean> listeAbsences = new HashMap<>();

	    for (Object[] result : results) {
	        Date date = (Date) result[0];
	        Boolean estAbsent = (Boolean) result[1];
	        listeAbsences.put(date, estAbsent);
	    }

	    return listeAbsences;
	}
	@Override
	public List<Integer> getAbsentsByDate(Date date) {
	    String sql = "SELECT s.id_stagiaire FROM Stagiaire s JOIN map_table m ON s.id_stagiaire = m.id_stagiaire WHERE m.cle_map = :date AND m.valeur_map = true";
	    Query query = em.createNativeQuery(sql);
	    query.setParameter("date", date);
	    List<Integer> result = query.getResultList();
	    return result;
	}
}

