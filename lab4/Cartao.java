package lab4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Cartao {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private int numeroCartoes;
	private int id;
	private int visibilidade;
	private String nome;
	ArrayList<Label> labels;
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
		labels = new ArrayList<Label>();
		labels.add(Label.TO_DO);
		labels.add(Label.DOING);
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
	
	public ArrayList<Label> getLabels() {
		return labels;
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
		String out = "";
		out += "Cartao [numeroCartoes=" + numeroCartoes;
		out += ", id=" + id;
		out += ", visibilidade=" + visibilidade;
		out += ", nome=" + nome;
		out += ", dono=" + dono;
		out += ", invitationOnly=" + invitationOnly;
		out += ", dataCriacao=" + (dataCriacao != null ? formatter.format(dataCriacao.getTime()) : null);
		if (labels != null && !labels.isEmpty()) {
			out += ", Labels:\n";
			for (int i=0; i < labels.size(); i++) {
				Label label = labels.get(i);
				out += " * " + label + "\n";
			}
		}
		out += "];";
		
		return out;
	}
}
