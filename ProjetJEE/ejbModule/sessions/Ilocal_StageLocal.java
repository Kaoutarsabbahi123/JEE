package sessions;

import java.util.List;
import Entities.Stage;
import Entities.Type;
import Entities.Statut;
import Entities.Etat_stage;
import jakarta.ejb.Local;

@Local
public interface Ilocal_StageLocal {
	public void addStage(Stage S);
	public void deleteStage(Stage S);
	public Stage getStage(int code);
	public Stage getStageSujet(String Sujet);
	public Stage getStageType(Type type);
	public Stage getStageStatut(Statut statut);
	public Stage getStageEtat(Etat_stage Etat);
	public void updateStage(Stage S);
	public List<Stage> getallStage();
	public List<Stage> getListeStagesParEmploye(int idEmp) ;
	public boolean supprimerStageSiConditionsRemplies(int idstage);
	public int nbrstageaffecte();
	public int nbrstagenonaffecte();
}
