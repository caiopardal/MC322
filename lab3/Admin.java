package lab3;

import java.util.GregorianCalendar;

public class Admin extends Usuario {	
	public Admin() {
		super();
	}

	public Admin(int id, String login, String email, String senha, String descricao,
			GregorianCalendar dataAtivacao, boolean status) {
		super(id, login, email, senha, descricao, dataAtivacao, status);
	}

	public boolean desabilitarGrupo(Grupo grupo) {
		if (grupo.setStatus(false, this)) {
			return true;
		}
		
		return false;
	}
}
