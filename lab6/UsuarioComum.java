package lab6;

import java.util.Calendar;

public class UsuarioComum extends Usuario {
  public UsuarioComum(int id, String login, Perfil perfil, String email, String senha,
  Calendar dataAtivacao, boolean status){
		super(id, login, perfil, email, senha, dataAtivacao, status);
	}
	
	public void criarGrupo(boolean isPrivate) {
		// no implementation for now
	}

	@Override
	public boolean criarGrupo(String nome, String descricao, boolean visibilidade) {
		// no implementation for now
		return false;
	}
	
	@Override
	public String toString() {
		return super.toString();
	}
}
