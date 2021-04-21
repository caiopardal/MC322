package lab6;

import java.util.ArrayList;
import java.util.Calendar;

public class Admin extends Usuario {
	public Admin() {
		super();
	}

	public Admin(int id, String login, Perfil perfil, String email, String senha, Calendar dataAtivacao,
			boolean status) {
		super(id, login, perfil, email, senha, dataAtivacao, status);
	}

	public boolean desabilitarGrupo(Grupo grupo) {
		if (grupo.setStatus(false, this)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean criarGrupo(String nome, String descricao, boolean isPrivate) {
		if (isPrivate) {
			GrupoPrivado grupoPrivado = new GrupoPrivado(nome, descricao, this, Calendar.getInstance());
			this.grupos.add(grupoPrivado);

			ArrayList<Permissao> permissoes = new ArrayList<>();
			permissoes.add(Permissao.VISUALIZAR_INFO);
			grupoPrivado.adicionaMembro(this, this, permissoes);

			return true;
		} else {
			GrupoPublico grupoPublico = new GrupoPublico(nome, descricao, this, Calendar.getInstance());
			this.grupos.add(grupoPublico);

			ArrayList<Permissao> permissoes = new ArrayList<>();
			permissoes.add(Permissao.VISUALIZAR_INFO);

			grupoPublico.adicionaMembro(this, this, permissoes);

			return true;
		}
	}
}
