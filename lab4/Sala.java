package lab4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class Sala {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private int numeroSalas;
	private int id;
	private int capacidadeMaxima;
	private int numeroUsuarios;
	private String descricao;
	private Usuario dono;
	private boolean ingressoAutomatico;
	private GregorianCalendar dataCriacao;
	
	public Sala() {
		super();
		
		this.id = this.numeroSalas;
	}
	
	public Sala(int numeroSalas, int capacidadeMaxima, int numeroUsuarios, String descricao, Usuario dono,
			boolean ingressoAutomatico, GregorianCalendar dataCriacao) {
		super();
		
		this.id = this.numeroSalas;
		this.numeroSalas = numeroSalas;		
		this.capacidadeMaxima = capacidadeMaxima;
		this.numeroUsuarios = numeroUsuarios;
		this.descricao = descricao;
		this.dono = dono;
		this.ingressoAutomatico = ingressoAutomatico;
		this.dataCriacao = dataCriacao;
	}

	public int getNumeroSalas() {
		return numeroSalas;
	}

	public void setNumeroSalas(int numeroSalas) {
		this.numeroSalas = numeroSalas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public GregorianCalendar getDataCriacao() {
		return dataCriacao;
	}

	public void setDataCriacao(GregorianCalendar dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

	@Override
	public String toString() {
		return "Sala [numeroSalas=" + numeroSalas + ", id=" + id + ", capacidadeMaxima=" + capacidadeMaxima
				+ ", numeroUsuarios=" + numeroUsuarios + ", descricao=" + descricao + ", dono=" + dono
				+ ", ingressoAutomatico=" + ingressoAutomatico + ", dataCriacao=" + (dataCriacao != null ? formatter.format(dataCriacao.getTime()) : null) + "]";
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
