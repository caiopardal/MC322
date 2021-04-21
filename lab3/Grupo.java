package lab3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Grupo {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private int id;
	private String nome;
	private String descricao;
	private final Usuario dono;
	ArrayList<Usuario> membros;
	private boolean status;
	private GregorianCalendar dataCriacao;
	
	public Grupo(String nome, String descricao, Usuario dono) {
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		this.status = true;
		membros = new ArrayList<Usuario>();
	}
	
	public Grupo(int id, String nome, String descricao, Usuario dono, boolean status,
			GregorianCalendar dataCriacao) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.dono = dono;
		membros = new ArrayList<Usuario>();
		this.status = status;
		this.dataCriacao = dataCriacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		out += "];";
		
		return out;
	}
}
