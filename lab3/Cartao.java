package lab3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Cartao {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private int numeroCartoes;
	private int id;
	private int visibilidade;
	private String nome;
	private Usuario dono;
	private boolean invitationOnly;
	private GregorianCalendar dataCriacao;
	
	public Cartao() {
		super();
		
		this.id = this.numeroCartoes;
	}
	
	public Cartao(int numeroCartoes, int visibilidade, String nome, Usuario dono, boolean invitationOnly,
			GregorianCalendar dataCriacao) {
		super();
		
		this.id = this.numeroCartoes;
		this.numeroCartoes = numeroCartoes;
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.dono = dono;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
	}
	
	public int getNumeroCartoes() {
		return numeroCartoes;
	}
	public void setNumeroCartoes(int numeroCartoes) {
		this.numeroCartoes = numeroCartoes;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getVisibilidade() {
		return visibilidade;
	}
	public void setVisibilidade(int visibilidade) {
		this.visibilidade = visibilidade;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Usuario getDono() {
		return dono;
	}
	public void setDono(Usuario dono) {
		this.dono = dono;
	}
	public boolean isInvitationOnly() {
		return invitationOnly;
	}
	public void setInvitationOnly(boolean invitationOnly) {
		this.invitationOnly = invitationOnly;
	}
	public GregorianCalendar getDataCriacao() {
		return dataCriacao;
	}
	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Cartao [numeroCartoes=" + numeroCartoes + ", id=" + id + ", visibilidade=" + visibilidade + ", nome="
				+ nome + ", dono=" + dono + ", invitationOnly=" + invitationOnly + ", dataCriacao=" + (dataCriacao != null ? formatter.format(dataCriacao.getTime()) : null) + "]";
	}
}
