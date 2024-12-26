package sessions;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import Entities.Stagiaire;

import jakarta.ejb.Local;
import Entities.Etat_stagiaire;

@Local
public interface Ilocal_StagiaireLocal {
	public void addStagiaire(Stagiaire S);
	public void deleteStagiaire(Stagiaire S);
	public Stagiaire getStagiaire(int code);
	public Stagiaire getStagiaireByCIN(String cin);
	public Stagiaire getStagiaireByEtat(Etat_stagiaire Etat);
	public void updateStagiaire(Stagiaire S);
	public List<Stagiaire> getallStagiaire();
	public List<Stagiaire> searchStagiaires(String keyword);
	public void SupprimerStagiaire(int id);
	public List<Stagiaire> getlistestagiairenouveau();
	public int nbrNouveauStagiaire();
	public int nbrencoursStagiaire();
	public int nbrarchiveStagiaire();
	public List<Integer> getAbsentsByDate(Date date);
	public Map<Date, Boolean> getListeAbsencesStagiaire(int idStagiaire);
}
