package sessions;

import java.util.List;

import Entities.Division;
import Entities.Entreprise;
import jakarta.ejb.Local;

@Local
public interface Ilocal_DivisionLocal {
	public Division getDivision(int code);
	public List<Division> getalldivison();

}
