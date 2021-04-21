package lab5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public abstract class Grupo {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private final int id;
	private static int numGrupos = 0;
	private String nome;
	private String descricao;
	private final Usuario dono;
	protected ArrayList<Usuario> membros;
	private boolean status;
	private GregorianCalendar dataCriacao;
	protected ArrayList<Usuario> permissaoAdicionar;
	protected ArrayList<Usuario> permissaoRemover;
	protected ArrayList<Usuario> permissaoAlterar;
	protected ArrayList<Usuario> permissaoVisualizar;
	protected ArrayList<Usuario> permissaoCriarCartao;
	protected ArrayList<Cartao> cartoes;
	
	public Grupo(String nome, String descricao, Usuario dono, GregorianCalendar dataCriacao) {
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
		
		this.cartoes = new ArrayList<Cartao>();
		
		this.dono.getGrupos().add(this);
	}
	
	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status,
			GregorianCalendar dataCriacao) {
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
		
		this.cartoes = new ArrayList<Cartao>();
		
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
	
	public ArrayList<Cartao> getCartoes(){
		return cartoes;
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

	public GregorianCalendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	public Usuario getDono() {
		return dono;
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "Grupo [id=" + id;
		out += ", nome=" + nome;
		out += ", descricao=" + descricao;
		out += ", dono=" + dono;
		out += ", status=" + status;
		out += ", dataCriacao=" + (dataCriacao != null ? formatter.format(dataCriacao.getTime()) : null);
		if (membros != null && !membros.isEmpty()) {
			for (int i=0; i < membros.size(); i++) {
				out += "\nMembros:\n";
				Usuario membro = membros.get(i);
				out += " * " + membro + "\n";
			}
		}
		if (permissaoAdicionar != null && !permissaoAdicionar.isEmpty()) {
			for (int i=0; i < permissaoAdicionar.size(); i++) {
				out += "\nUsuário Permissão Adicionar:\n";
				Usuario usuario = permissaoAdicionar.get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (permissaoRemover != null && !permissaoRemover.isEmpty()) {
			for (int i=0; i < permissaoRemover.size(); i++) {
				out += "\nUsuário Permissão Remover:\n";
				Usuario usuario = permissaoRemover.get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (permissaoAlterar != null && !permissaoAlterar.isEmpty()) {
			for (int i=0; i < permissaoAlterar.size(); i++) {
				out += "\nUsuário Permissão Alterar:\n";
				Usuario usuario = permissaoAlterar.get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (permissaoVisualizar != null && !permissaoVisualizar.isEmpty()) {
			for (int i=0; i < permissaoVisualizar.size(); i++) {
				out += "\nUsuário Permissão Visualizar:\n";
				Usuario usuario = permissaoVisualizar.get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (permissaoCriarCartao != null && !permissaoCriarCartao.isEmpty()) {
			for (int i=0; i < permissaoCriarCartao.size(); i++) {
				out += "\nUsuário Permissão Criar Cartão:\n";
				Usuario usuario = permissaoCriarCartao.get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (cartoes != null && !cartoes.isEmpty()) {
			for (int i=0; i < cartoes.size(); i++) {
				out += "\nCartões:\n";
				Cartao cartao = cartoes.get(i);
				out += " * " + cartao + "\n";
			}
		}
		out += "];";
		
		return out;
	}
	
	
	public abstract boolean adicionaMembro(Usuario requisitor, Usuario novo, ArrayList<Permissao> permissao);
		
	public abstract boolean removeMembro(Usuario requisitor, Usuario del);
		
	public abstract boolean adicionarPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao);
		
	public abstract boolean removerPermissao(Usuario requisitor, Usuario nova_permissao, ArrayList<Permissao> permissao);
		
	public abstract boolean adicionarCartao(Cartao novo_cartao);
}
