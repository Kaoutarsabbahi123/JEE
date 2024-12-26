package sessions;

import java.util.List;
import Entities.Employe;

import jakarta.ejb.Local;

import jakarta.ejb.Stateless;
@Stateless
@Local
public interface Ilocal_EmployeLocal {
	public void addEmploye(Employe E);
	public void deleteEmploye(Employe E);
	public Employe getEmploye(int code);
	public Employe getEmployeByNom(String Nom);
	public Employe getEmployeByPrenom(String prenom);
	public void updateEmploye(Employe E);
	public List<Employe> getallEmploye();
	public List<Employe> searchEmploye(String keyword);
	public boolean supprimerEmployeSiConditionsRemplies(int idEmp);
	public int nbremployeaffecte();
	public int nbremployenonaffecte();

}
