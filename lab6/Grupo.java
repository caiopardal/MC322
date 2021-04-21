package lab6;

import java.util.ArrayList;
import java.util.Calendar;

public abstract class Grupo {
	private final int id;
	private static int numGrupos = 0;
	private String nome;
	private String descricao;
	private final Usuario dono;
	protected ArrayList<Usuario> membros;
	private boolean status;
	private Calendar dataCriacao;
	protected ArrayList<Usuario> permissaoAdicionar;
	protected ArrayList<Usuario> permissaoRemover;
	protected ArrayList<Usuario> permissaoAlterar;
	protected ArrayList<Usuario> permissaoVisualizar;
	protected ArrayList<Usuario> permissaoCriarCartao;
	protected ArrayList<Cartao> cartoesAFazer; 
	protected ArrayList<Cartao> cartoesFeitos; 
	
	public Grupo(String nome, String descricao, Usuario dono, Calendar dataCriacao) {
		this.id = Grupo.numGrupos++;
		Grupo.numGrupos++;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.status = true;
		this.dataCriacao = dataCriacao;
		
		this.membros = new ArrayList<Usuario>();
		this.membros.add(dono);
		
		this.permissaoAdicionar = new ArrayList<Usuario>();
		this.permissaoAdicionar.add(dono);
		
		this.permissaoRemover = new ArrayList<Usuario>();
		this.permissaoRemover.add(dono);
		
		this.permissaoAlterar = new ArrayList<Usuario>();
		this.permissaoAlterar.add(dono);
		
		this.permissaoVisualizar = new ArrayList<Usuario>();
		this.permissaoVisualizar.add(dono);
		
		this.permissaoCriarCartao = new ArrayList<Usuario>();
		this.permissaoCriarCartao.add(dono);
		
		this.cartoesAFazer = new ArrayList<Cartao>();
		this.cartoesFeitos = new ArrayList<Cartao>();
		
		this.dono.getGrupos().add(this);
	}
	
	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status,
			Calendar dataCriacao) {
		this.id = Grupo.numGrupos++;
		Grupo.numGrupos++;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.status = status;
		this.dataCriacao = dataCriacao;
		
		this.membros = new ArrayList<Usuario>();
		this.membros.add(dono);
		
		this.permissaoAdicionar = new ArrayList<Usuario>();
		this.permissaoAdicionar.add(dono);
		
		this.permissaoRemover = new ArrayList<Usuario>();
		this.permissaoRemover.add(dono);
		
		this.permissaoAlterar = new ArrayList<Usuario>();
		this.permissaoAlterar.add(dono);
		
		this.permissaoVisualizar = new ArrayList<Usuario>();
		this.permissaoVisualizar.add(dono);
		
		this.permissaoCriarCartao = new ArrayList<Usuario>();
		this.permissaoCriarCartao.add(dono);
		
		this.cartoesAFazer = new ArrayList<Cartao>();
		this.cartoesFeitos = new ArrayList<Cartao>();
		
		this.dono.getGrupos().add(this);
	}

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ArrayList<Usuario> getMembros() {
		return membros;
	}
	
	public ArrayList<Usuario> getUsuariosPermissaoAdicionar() {
		return permissaoAdicionar;
	}
	
	public ArrayList<Usuario> getUsuariosPermissaoRemover() {
		return permissaoRemover;
	}
	
	public ArrayList<Usuario> getUsuariosPermissaoAlterar() {
		return permissaoAlterar;
	}
	
	public ArrayList<Usuario> getUsuariosPermissaoVisualizar() {
		return permissaoVisualizar;
	}
	
	public ArrayList<Usuario> getUsuariosPermissaoCriarCartao(){
		return permissaoCriarCartao;
	}
	
	public ArrayList<Cartao> getCartoesAFazer(){
		return cartoesAFazer;
	}

	public ArrayList<Cartao> getCartoesFeitos(){
		return cartoesFeitos;
	}

	public boolean isStatus() {
		return status;
	}

	public boolean setStatus(boolean status, Usuario usuario) {
		if (usuario.getClass() == Admin.class) {
			this.status = status;
			
			return true;
		}
		
		return false;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getDono() {
		return dono;
	}
	
	@Override
	public String toString() {
		StringBuilder out 
						= new StringBuilder(); 
						
		out.append("Grupo [id=" + id);
		out.append(", nome=" + nome);
		out.append(", descricao=" + descricao);
		out.append(", dono=" + dono);
		out.append(", status=" + status);
		if (membros != null && !membros.isEmpty()) {
			for (int i=0; i < membros.size(); i++) {
				out.append("\nMembros:\n");
				Usuario membro = membros.get(i);
				out.append(" * " + membro + "\n");
			}
		}
		if (permissaoAdicionar != null && !permissaoAdicionar.isEmpty()) {
			for (int i=0; i < permissaoAdicionar.size(); i++) {
				out.append("\nUsuário Permissão Adicionar:\n");
				Usuario usuario = permissaoAdicionar.get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (permissaoRemover != null && !permissaoRemover.isEmpty()) {
			for (int i=0; i < permissaoRemover.size(); i++) {
				out.append("\nUsuário Permissão Remover:\n");
				Usuario usuario = permissaoRemover.get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (permissaoAlterar != null && !permissaoAlterar.isEmpty()) {
			for (int i=0; i < permissaoAlterar.size(); i++) {
				out.append("\nUsuário Permissão Alterar:\n");
				Usuario usuario = permissaoAlterar.get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (permissaoVisualizar != null && !permissaoVisualizar.isEmpty()) {
			for (int i=0; i < permissaoVisualizar.size(); i++) {
				out.append("\nUsuário Permissão Visualizar:\n");
				Usuario usuario = permissaoVisualizar.get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (permissaoCriarCartao != null && !permissaoCriarCartao.isEmpty()) {
			for (int i=0; i < permissaoCriarCartao.size(); i++) {
				out.append("\nUsuário Permissão Criar Cartão:\n");
				Usuario usuario = permissaoCriarCartao.get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (cartoesAFazer != null && !cartoesAFazer.isEmpty()) {
			for (int i=0; i < cartoesAFazer.size(); i++) {
				out.append("\nCartões A Fazer:\n");
				Cartao cartao = cartoesAFazer.get(i);
				out.append(" * " + cartao + "\n");
			}
		}
		if (cartoesFeitos != null && !cartoesFeitos.isEmpty()) {
			for (int i=0; i < cartoesFeitos.size(); i++) {
				out.append("\nCartões Feitos:\n");
				Cartao cartao = cartoesFeitos.get(i);
				out.append(" * " + cartao + "\n");
			}
		}
		out.append("];");
		
		return out.toString();
	}
	
	
	public abstract boolean adicionaMembro(Usuario actionUser, Usuario newUser, ArrayList<Permissao> permission);
		
	public abstract boolean removeMembro(Usuario actionUser, Usuario userToDelete);
		
	public abstract boolean adicionarPermissao(Usuario actionUser, Usuario userToAddPermission, ArrayList<Permissao> permission);
		
	public abstract boolean removerPermissao(Usuario actionUser, Usuario userToRemovePermission, ArrayList<Permissao> permission);
		
	public abstract boolean adicionarCartao(Cartao newCard);
}
