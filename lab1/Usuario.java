package lab1;

import java.util.Date;

public class Usuario {
	private int id;
	private String login;
	private String email;
	private String senha;
	private Date dataAtivacao;
	private boolean status;
	
	public Usuario(int id, String login, String email, String senha, Date dataAtivacao, boolean status) {
		super();
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.dataAtivacao = dataAtivacao;
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
	
	public Date getDataAtivacao() {
		return dataAtivacao;
	}
	
	public void setDataAtivacao(Date dataAtivacao) {
		this.dataAtivacao = dataAtivacao;
	}
	
	public boolean isStatus() {
		return status;
	}
	
	public void setStatus(boolean status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", login=" + login + ", email=" + email + ", senha=" + senha + ", dataAtivacao="
				+ dataAtivacao.toString() + ", status=" + status + "]";
	}
}
