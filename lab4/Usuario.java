package lab4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Usuario {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private GregorianCalendar dataAtivacao;
	ArrayList<Grupo> grupos;
	private boolean status;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String login, String email, String senha, String descricao,
			GregorianCalendar dataAtivacao, boolean status) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.dataAtivacao = dataAtivacao;
		grupos = new ArrayList<Grupo>();
		this.status = status;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getLogin() {
		return login;
	}
	
	public void setLogin(String login) {
		this.login = login;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public GregorianCalendar getDataAtivacao() {
		return dataAtivacao;
	}
	
	public void setDataAtivacao(GregorianCalendar dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}
	
	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "Usuario [id=" + id;
		out += ", login=" + login;
		out += ", email=" + email;
		out += ", senha=" + senha;
		out += ", descricao=" + descricao;
		out += ", dataAtivacao=" + (dataAtivacao != null ? formatter.format(dataAtivacao.getTime()) : null);
		out += ", status=" + status;
		if (grupos != null && !grupos.isEmpty()) {
			out += ", Grupos:\n";
			for (int i=0; i < grupos.size(); i++) {
				Grupo grupo = grupos.get(i);
				out += " * " + grupo + "\n";
			}
		}
		out += "];";
		
		return out;
	}

	public boolean criarGrupo(String nome, String descricao, boolean isPrivate) {
		boolean hasGroup = false;

		if (isPrivate) {
			GrupoPrivado grupoPrivado = new GrupoPrivado(nome, descricao, this);
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

		GrupoPublico grupoPublico = new GrupoPublico(nome, descricao, this);
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
	
	public boolean removerGrupo(Grupo grupo) {
		boolean hasGroup = grupos.contains(grupo);
		
		if (hasGroup) {
			grupos.remove(grupo);
			
			return true;
		}
		
		return false;
	}
}
