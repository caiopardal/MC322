package lab6;

public enum Permissao {
	ADICIONAR_USUARIO (1, "Permite a um usuário adicionar novos membros ao grupo."), 
	REMOVER_USUARIO (2, "Permite a um usuário remover novos membros ao grupo."), 
	ALTERAR_PERMISSAO (3, "Permite a um usuário alterar a permissão de outros usuários no grupo."), 
	VISUALIZAR_INFO (4, "Permite a um usuário visualizar as seguintes informações do grupo: Nome, Dono, Status e Membros Pertencentes."),
	CRIAR_CARTAO (5, "Permite a um usuário criar cartões");
	
	private final int id;
	private final String descricao;
	
	Permissao(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public String getAtributos() {
		String out = "Id: " + getCodigo() + "\n";
		out += "Descrição: " + getDescricao() + "\n";
		return out;
	}
}
