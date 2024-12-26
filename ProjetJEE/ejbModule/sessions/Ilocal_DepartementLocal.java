package sessions;

import jakarta.ejb.Local;

import java.util.List;

import Entities.Departement;
@Local
public interface Ilocal_DepartementLocal {
	public Departement getDepartement(int code);
	public List<Departement> getalldepartement();
}
