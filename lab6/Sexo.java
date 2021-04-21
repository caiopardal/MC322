package lab6;

public enum Sexo {
	MASCULINO ("M", "Sexo Masculino (HOMEM)"), 
	FEMININO ("F", "Sexo Feminino (MULHER)");
		
	private final String sigla;
	private final String descricao;
	
	Sexo(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public String getSexo() {
		return sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
