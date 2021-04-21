package lab5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Usuario {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id;
	private String login;
	private String email;
	private String senha;
	private String descricao;
	private GregorianCalendar dataAtivacao;
	protected ArrayList<Grupo> grupos;
	protected boolean status;
	
	public Usuario() {
		super();
	}

	public Usuario(int id, String login, String email, String senha, String descricao,
			GregorianCalendar dataAtivacao, boolean status) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.descricao = descricao;
		this.dataAtivacao = dataAtivacao;
		this.grupos = new ArrayList<Grupo>();
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
	
	public abstract boolean criarGrupo(String nome, String descricao, boolean isPrivate);
	
	public boolean removerGrupo(Grupo grupo) {
		boolean hasGroup = grupos.contains(grupo);
		
		if (hasGroup) {
			grupos.remove(grupo);
			
			return true;
		}
		
		return false;
	}
	
	public boolean criarCartao(int id) {
		ArrayList<Label> labels = new ArrayList<Label>();
			
		String nomeCartao = "visa";
		String assuntoCartao = "random subject";
		int visibilidade = 0;
		new GregorianCalendar();
		GregorianCalendar dataCriacao = (GregorianCalendar) GregorianCalendar.getInstance();
		
		this.getGrupos();
			
			for (int i = 0; i < this.getGrupos().size(); i++) {
				if (this.getGrupos().get(i).getId() == id) {  // se o grupo existe
					// verificamos a permissao
					if (this.getGrupos().get(i).getUsuariosPermissaoCriarCartao().contains(this)) {
						Cartao novoCartao = new Cartao(visibilidade, nomeCartao, assuntoCartao, labels, this, this.isStatus(), dataCriacao);
						this.getGrupos().get(i).adicionarCartao(novoCartao);
						
						return true;
					}
				}
			}
			
			return false;
	}
}
