package lab6;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Usuario {
	private int id;
	private String login;
	private String email;
	private String senha;
	private Perfil perfil;
	private Calendar dataAtivacao;
	protected ArrayList<Grupo> grupos;
	protected boolean status;
	
	protected Usuario() {
		super();
	}

	protected Usuario(int id, String login, Perfil perfil, String email, String senha,
			Calendar dataAtivacao, boolean status) {
		this.id = id;
		this.login = login;
		this.email = email;
		this.senha = senha;
		this.perfil = perfil;
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

	public Perfil getPerfil() {
		return perfil;
	}
	
	public void setPerfil(Perfil perfil) {
		this.perfil = perfil;
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

	public Calendar getDataAtivacao() {
		return dataAtivacao;
	}
	
	public void setDataAtivacao(Calendar dataAtivacao) {
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
		StringBuilder out 
						= new StringBuilder(); 

		out.append("Usuario [id=" + id);
		out.append(", login=" + login);
		out.append(", email=" + email);
		out.append(", senha=" + senha);
		out.append(", perfil=" + getPerfil() + "\n");
		out.append(", status=" + status);
		if (grupos != null && !grupos.isEmpty()) {
			out.append(", Grupos:\n");
			for (int i=0; i < grupos.size(); i++) {
				Grupo grupo = grupos.get(i);
				out.append(" * " + grupo + "\n");
			}
		}
		out.append("];");
		
		return out.toString();
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
	
	public boolean criarCartao(int id, int visibilidade, int prioridade, String nomeCartao, Usuario responsavelCartao, String assunto, boolean invitation) {
		for (Grupo grupo: getGrupos()){
			if (grupo.getId() == id && grupo.getUsuariosPermissaoCriarCartao().contains(this)) {
				if (grupo.getMembros().contains(responsavelCartao)) {
					Cartao cartao = new Cartao(
							visibilidade, 
							prioridade,
							nomeCartao, 
							assunto,
							Label.TO_DO, 
							this,
							responsavelCartao,
							invitation,
							Calendar.getInstance()
							);
					grupo.adicionarCartao(cartao);
					
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean executarTarefaDeMaiorPrioridade() {		
		Cartao cartaoPrioritario = null;
		boolean primeiroCartao = true;
		for (Grupo grupo: getGrupos()){
			for (Cartao cartao: grupo.getCartoesAFazer()){
				if (primeiroCartao) {
					cartaoPrioritario = cartao;
					primeiroCartao = false;
				}
				else if (cartao.compareTo(cartaoPrioritario) >= 0)
					cartaoPrioritario = cartao;
			}
		}

		if (cartaoPrioritario != null) {
			int index = 0;
			int labelIndex = 0;
			for(Label label : cartaoPrioritario.getLabels()) {
				if (label == Label.TO_DO) {
					labelIndex = index;
					break;
				}
				else index++;
			}
			cartaoPrioritario.getLabels().remove(labelIndex);
			cartaoPrioritario.getLabels().add(Label.DONE);
			cartaoPrioritario.setPrioridade(5);

			return true;
		} else {
			return false;		
		}
	}
}
