package lab6;

import java.util.ArrayList;
import java.util.Calendar;

public class Cartao implements Comparable<Cartao> {
	private static int numeroCartoes = 0;
	private final int id;
	private int visibilidade;
	private int prioridade;
	private String nome;
	protected ArrayList<Label> labels;
	private Usuario dono;
	private Usuario responsavel;
	private String assunto;
	private boolean invitationOnly;
	private Calendar dataCriacao;
	
	public Cartao() {
		id = Cartao.numeroCartoes++;
		numeroCartoes++;
	}
	
	// constructor for common user
	public Cartao(int visibilidade, int prioridade, String nome, String assunto, Label label, Usuario dono, Usuario responsavel, boolean invitationOnly,
			Calendar dataCriacao) {		
		id = Cartao.numeroCartoes++;
		numeroCartoes ++;
		this.visibilidade = visibilidade;
		this.prioridade = prioridade;
		this.nome = nome;
		this.labels = new ArrayList<Label>();
		this.labels.add(label);
		this.dono = dono;
		this.responsavel = responsavel;
		this.invitationOnly = invitationOnly;
		this.dataCriacao = dataCriacao;
		this.assunto = assunto;
	}

	// constructor for admins
	public Cartao(int visibilidade, int prioridade, String nome, Label label, Admin dono, Usuario responsavel, String assunto, boolean invitationOnly, 
	    Calendar dataCriacao) {
		id = Cartao.numeroCartoes++;
		numeroCartoes ++;
		this.visibilidade = visibilidade;
		this.prioridade = prioridade;
		this.nome = nome;
		this.labels = new ArrayList<Label>();
		this.labels.add(label);
		this.dono = dono;
		this.responsavel = responsavel;
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
	
	public static void setNumeroCartoes(int numeroCartoes) {
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

	public int getPrioridade() {
		return prioridade;
	}
	public void setPrioridade(int prioridade) {
		this.prioridade = prioridade;
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

	public Usuario getResponsavel() {
		return responsavel;
	}
	public void setResponsavel(Usuario responsavel) {
		this.responsavel = responsavel;
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
	
	public Calendar getDataCriacao() {
		return dataCriacao;
	}
	
	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}
	
	@Override
	public String toString() {
		StringBuilder out 
		= new StringBuilder(); 
		
		out.append("Cartao [numeroCartoes=" + numeroCartoes);
		out.append(", id=" + id);
		out.append(", visibilidade=" + visibilidade);
		out.append(", nome=" + nome);
		out.append(", dono=" + dono);
		out.append(", invitationOnly=" + invitationOnly);
		out.append(", assunto=" + getAssunto() + "\n");
		out.append(", prioridade=" + prioridade +"\n");
		out.append(", responsavel=" + responsavel +"\n");
		if (labels != null && !labels.isEmpty()) {
			out.append(", Labels:\n");
			for (int i=0; i < labels.size(); i++) {
				Label label = labels.get(i);
				out.append(" * " + label + "\n");
			}
		}
		out.append("];");
		
		return out.toString();
	}

	@Override
	public int compareTo(Cartao cartao2) {
		if (this.getPrioridade() < cartao2.getPrioridade())
			return 1;
		else if (this.getPrioridade() > cartao2.getPrioridade())
			return -1;
		else return 0;
	}
}
