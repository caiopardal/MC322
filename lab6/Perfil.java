package lab6;

import java.util.Calendar;

public class Perfil {
	private Sexo sexo;
	private Calendar dataNascimento;
	private String cidade;
	private Estado estado;
	private String telefone;
	private String descricao;
	private String foto;
	
	public Perfil(Sexo sexo, Calendar dataNascimento, String cidade, Estado estado, String telefone, String descricao,
			String foto) {
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

	public Calendar getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Calendar dataNascimento) {
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

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}
	
	@Override
	public String toString() {
		StringBuilder out 
						= new StringBuilder(); 

		out.append("sexo: "+ sexo + "\n");
		out.append("cidade: "+ cidade + "\n");
		out.append("estado: "+ estado + "\n");
		out.append("telefone:"+ telefone + "\n");
		out.append("descricao: "+ descricao + "\n");
		out.append("foto: "+ foto + "\n");
		return out.toString();
	}
}
