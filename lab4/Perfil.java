package lab4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.GregorianCalendar;

public class Perfil {
	private DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	private Sexo sexo;
	private GregorianCalendar dataNascimento;
	private String cidade;
	private Estado estado;
	private String telefone;
	private String descricao;
	private String[] foto;
	
	public Perfil(Sexo sexo, GregorianCalendar dataNascimento, String cidade, Estado estado, String telefone, String descricao,
			String[] foto) {
		super();
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.cidade = cidade;
		this.estado = estado;
		this.telefone = telefone;
		this.descricao = descricao;
		this.foto = foto;
	}

	public Sexo getSexo() {
		return sexo;
	}
	
	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public GregorianCalendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(GregorianCalendar dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String[] getFoto() {
		return foto;
	}

	public void setFoto(String[] foto) {
		this.foto = foto;
	}
	
	@Override
	public String toString() {
		return "Perfil [sexo=" + sexo + ", dataNascimento=" + (dataNascimento != null ? formatter.format(dataNascimento.getTime()) : null) + ", cidade=" + cidade + ", estado="
				+ estado + ", telefone=" + telefone + ", descricao=" + descricao + ", foto=" + Arrays.toString(foto)
				+ "]";
	}
}
