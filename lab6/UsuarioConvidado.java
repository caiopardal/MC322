package lab6;

import java.util.Calendar;

public class UsuarioConvidado extends Usuario {
	private Calendar dataExpiracao;

	public UsuarioConvidado() {
		super();
	}

	public UsuarioConvidado(int id, String login, Perfil perfil, String email, String senha,
	Calendar dataAtivacao, boolean status, Calendar dataExpiracao) {
		super(id, login, perfil, email, senha, dataAtivacao, status);
		this.dataExpiracao = dataExpiracao;
	}

	public Calendar getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(Calendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	@Override
	public String toString() {
		super.toString();
		return "UsuarioConvidado [dataExpiracao=" + dataExpiracao != null ? dataExpiracao.toString() : null + "]";
	}
	
	public boolean criarGrupo(String nome, String descricao, boolean visibilidade) {
		System.out.println("Usuário convidado " + this.getLogin() + " não pode criar um grupo, pois não possui permissão para essa ação.");
		
		return false;
	}
}
