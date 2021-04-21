package lab5;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class Cartao {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private static int numeroCartoes = 0;
	private final int id;
	private int visibilidade;
	private String nome;
	protected ArrayList<Label> labels;
	private Usuario dono;
	private String assunto;
	private boolean invitationOnly;
	private GregorianCalendar dataCriacao;
	
	public Cartao() {
		id = Cartao.numeroCartoes++;
		numeroCartoes++;
	}
	
	public Cartao(int visibilidade, String nome, String assunto, ArrayList<Label> labels, Usuario dono, boolean invitationOnly,
			GregorianCalendar dataCriacao) {		
		id = Cartao.numeroCartoes++;
		numeroCartoes ++;
		this.visibilidade = visibilidade;
		this.nome = nome;
		this.labels = labels;
		this.dono = dono;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
		this.assunto = assunto;
	}
	
	public static int getNumeroCartoes() {
		return numeroCartoes;
	}
	
	public int numeroCartoes() {
		return getNumeroCartoes();
	}
	
	public void setNumeroCartoes(int numeroCartoes) {
		Cartao.numeroCartoes = numeroCartoes;
	}
	
	public int getId() {
		return id;
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
	
	public String getAssunto() {
		return assunto;
	}
	
	public void setAssunto(String assunto) {
		this.assunto = assunto;
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
		out += ", assunto=" + getAssunto() + "\n";
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
