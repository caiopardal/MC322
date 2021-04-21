package lab5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class UsuarioConvidado extends Usuario {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private GregorianCalendar dataExpiracao;

	public UsuarioConvidado() {
		super();
	}

	public UsuarioConvidado(int id, String login, String email, String senha, String descricao,
			GregorianCalendar dataAtivacao, boolean status,  GregorianCalendar dataExpiracao) {
		super(id, login, email, senha, descricao, dataAtivacao, status);
		this.dataExpiracao = dataExpiracao;
	}

	public GregorianCalendar getDataExpiracao() {
		return dataExpiracao;
	}

	public void setDataExpiracao(GregorianCalendar dataExpiracao) {
		this.dataExpiracao = dataExpiracao;
	}

	@Override
	public String toString() {
		return "UsuarioConvidado [dataExpiracao=" + (dataExpiracao != null ? formatter.format(dataExpiracao.getTime()) : null) + "]";
	}
	
	public boolean criarGrupo(String nome, String descricao, boolean visibilidade) {
		System.out.println("Usuário convidado " + this.getLogin() + " não pode criar um grupo, pois não possui permissão para essa ação.");
		
		return false;
	}
}
