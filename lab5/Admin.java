package lab5;

import java.util.ArrayList;
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
	
	public boolean criarGrupo(String nome, String descricao, boolean isPrivate) {
		boolean hasGroup = false;

		if (isPrivate) {
			GrupoPrivado grupoPrivado = new GrupoPrivado(nome, descricao, this, (GregorianCalendar) GregorianCalendar.getInstance());
			hasGroup = grupos.contains(grupoPrivado);
			
			if (!hasGroup) {
				grupos.add(grupoPrivado);

				ArrayList<Permissao> permissoes = new ArrayList<>();
				permissoes.add(Permissao.VISUALIZAR_INFO);
				grupoPrivado.adicionaMembro(this, this, permissoes);

				return true;
			}
			
			return false;
		}

		GrupoPublico grupoPublico = new GrupoPublico(nome, descricao, this, (GregorianCalendar) GregorianCalendar.getInstance());
		hasGroup = grupos.contains(grupoPublico);
		
		if (!hasGroup) {
			grupos.add(grupoPublico);
			
			ArrayList<Permissao> permissoes = new ArrayList<>();
			permissoes.add(Permissao.VISUALIZAR_INFO);
	
			grupoPublico.adicionaMembro(this, this, permissoes);
		
			return true;
		}
		
		return false;
	}
}
