package sessions;

import java.util.List;

import Entities.Login;
import jakarta.ejb.Local;

@Local
public interface Ilocal_LoginLocal {
	public void addLogin(Login l);
	public void deleteLogin(String id_login);
	public Login getLogin(String id_login);
	public void updateLogin(Login l);
	public void MotdePasseOublie(String id_login,String mot_passe);
	public List<Login> getallLogin();
    public String authentifier(String id_login,String mot_passe);
    public List<Login> searchUsers(String keyword);
}
