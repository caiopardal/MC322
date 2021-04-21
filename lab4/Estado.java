package lab4;

public enum Estado {
	Acre ("AC", "Acre"),
	Alagoas ("AL", "Alagoas"),
	Amapa ("AP", "Amapa"),
	Amazonas ("AM", "Amazonas"),
	Bahia ("BA", "Bahia"),
	Ceara ("CE", "Ceará"),
	Distrito_Federal ("DF", "Distrito Federal"),
	Espirito_Santo ("ES", "Espírito Santo"),
	Goias ("GO", "Goiás"),
	Maranhao ("MA", "Maranhão"),
	Mato_Grosso ("MT", "Mato Grosso"),
	Mato_Grosso_do_Sul ("MS", "Mato Grosso do Sul"),
	Minas_Gerais ("MG", "Minas Gerais"),
	Para ("PA", "Pára"),
	Paraiba ("PB", "Paraíba"),
	Parana ("PR","Paraná"),
	Pernambuco ("PE", "Pernambuco"),
	Piaui ("PI", "Piauí"),
	Rio_de_Janeiro ("RJ", "Rio de Janeiro"),
	Rio_Grande_do_Norte ("RN", "Rio Grande do Norte"),
	Rio_Grande_do_Sul ("RS", "Rio Grande do Sul"),
	Rondonia ("RO", "Rondônia"),
	Roraima ("RR", "Roraima"),
	Santa_Catarina ("SC", "Santa Catarina"),
	Sao_Paulo ("SP", "São Paulo"),
	Sergipe ("SE", "Sergipe"),
	Tocantins ("TO", "Tocantins");
	
	private final String sigla;
	private final String descricao;
	
	Estado(String sigla, String descricao) {
		this.sigla = sigla;
		this.descricao = descricao;
	}
	
	public String getSigla() {
		return sigla;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
