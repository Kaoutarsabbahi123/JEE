package sessions;

import java.util.List;

import Entities.Login;
import Entities.Stagiaire;
import jakarta.ejb.LocalBean;

import jakarta.ejb.Stateless;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

/**
 * Session Bean implementation class Ilocal_Login
 */
@Stateless
@LocalBean
public class Ilocal_Login implements Ilocal_LoginLocal {
	@PersistenceContext(unitName="projetds")
    EntityManager em;
    public Ilocal_Login() {
        // TODO Auto-generated constructor stub
    }
	@Override
	public void addLogin(Login l) {
		em.persist(l);
		
	}
	@Override
	public void deleteLogin(String id_login) {
	    String sql = "DELETE FROM Login WHERE id_login = ?";
	    Query q = em.createNativeQuery(sql);
	    q.setParameter(1, id_login);
	    q.executeUpdate();
	}
	@Override
	public Login getLogin(String id_login) {
		Login l =em.find(Login.class, id_login);
		return l;
	}
	@Override
	public void updateLogin(Login l) {
		em.merge(l);
		
	}
	@Override
	public void MotdePasseOublie(String id_login, String mot_passe) {
		Login l =getLogin(id_login);
		l.setMot_passe(mot_passe);
	}
	@Override
	public List<Login> getallLogin() {
		String sql = "SELECT * FROM Login where role not like '%superadmin%'";

		
		Query query = em.createNativeQuery(sql, Login.class);

		
		List<Login> result = query.getResultList();
		return result;
	}
	@Override
	public String authentifier(String id_login, String mot_passe) {
		Query q=em.createNativeQuery("select role from Login WHERE id_login = :id_login AND mot_passe = :mot_passe ");
		q.setParameter("id_login", id_login);
        q.setParameter("mot_passe", mot_passe);
        try {
        Object result = q.getSingleResult();
        return result.toString();
        }
	   catch (NoResultException e) {
	        return null;
	    }
	}
	@Override
	public List<Login> searchUsers(String keyword) {
	    String nativeQuery = "SELECT * FROM Login l WHERE " +
	    		"l.id_login LIKE :keyword OR " +
	            "l.cin LIKE :keyword OR " +
	            "l.nom LIKE :keyword OR " +
	            "l.prenom LIKE :keyword OR " +
	            "l.role LIKE :keyword OR " +
	            "CAST(l.dat_naiss AS CHAR) LIKE :keyword OR " +
	            "l.adresse LIKE :keyword OR " +
	            "l.email LIKE :keyword OR " +
	            "l.tel LIKE :keyword";

	    Query query = em.createNativeQuery(nativeQuery, Login.class);

	    query.setParameter("keyword", "%" + keyword + "%");
	    List<Login> result=query.getResultList();

	    return result;
	}
}
