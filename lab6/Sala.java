package lab6;

import java.util.Calendar;

public class Sala {
	private static int numeroSalas = 0;
	private final int id;
	private int capacidadeMaxima;
	private int numeroUsuarios = 0;
	private String descricao;
	private Usuario dono;
	private boolean ingressoAutomatico;
	private Calendar dataCriacao;
	
	public Sala() {
		id = Sala.numeroSalas++; 
		numeroSalas ++;		
		numeroUsuarios ++;
	}
	
	public Sala(int capacidadeMaxima, int numeroUsuarios, String descricao, Usuario dono,
			boolean ingressoAutomatico, Calendar dataCriacao) {
		id = Sala.numeroSalas++; 
		numeroSalas ++;		
		numeroUsuarios ++;	
		this.capacidadeMaxima = capacidadeMaxima;
		this.numeroUsuarios = numeroUsuarios;
		this.descricao = descricao;
		this.dono = dono;
		this.ingressoAutomatico = ingressoAutomatico;
		this.dataCriacao = dataCriacao;
	}

	public static int getNumeroSalas() {
		return numeroSalas;
	}

	public void setNumeroSalas(int numeroSalas) {
		Sala.numeroSalas = numeroSalas;
	}

	public int getId() {
		return id;
	}

	public int getCapacidadeMaxima() {
		return capacidadeMaxima;
	}

	public void setCapacidadeMaxima(int capacidadeMaxima) {
		this.capacidadeMaxima = capacidadeMaxima;
	}

	public int getNumeroUsuarios() {
		return numeroUsuarios;
	}

	public void setNumeroUsuarios(int numeroUsuarios) {
		this.numeroUsuarios = numeroUsuarios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Usuario getDono() {
		return dono;
	}

	public void setDono(Usuario dono) {
		this.dono = dono;
	}

	public boolean isIngressoAutomatico() {
		return ingressoAutomatico;
	}

	public void setIngressoAutomatico(boolean ingressoAutomatico) {
		this.ingressoAutomatico = ingressoAutomatico;
	}

	public Calendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(Calendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Sala [numeroSalas=" + numeroSalas + ", id=" + id + ", capacidadeMaxima=" + capacidadeMaxima
				+ ", numeroUsuarios=" + numeroUsuarios + ", descricao=" + descricao + ", dono=" + dono
				+ ", ingressoAutomatico=" + ingressoAutomatico + ", dataCriacao=" + dataCriacao.toString() + "]";
	}
	
	public boolean adicionaUsuario() {
		if (getNumeroUsuarios() >= capacidadeMaxima) {
			return false;
		}
		
		numeroUsuarios++;
		
		return true;
	}
	
	public boolean removeUsuario() {
		if (getNumeroUsuarios() <= 0) {
			return false;
		}
		
		numeroUsuarios--;
		
		return true;
	}	
}
