package lab4;

public enum Permissoes {
	ADICIONAR_USUARIO (1, "Permite a um usuário adicionar novos membros ao grupo."), 
	REMOVER_USUARIO (2, "Permite a um usuário remover novos membros ao grupo."), 
	ALTERAR_PERMISSAO (3, "Permite a um usuário alterar a permissão de outros usuários no grupo."), 
	VISUALIZAR_INFO (4, "Permite a um usuário visualizar as seguintes informações do grupo: Nome, Dono, Status e Membros Pertencentes.");
	
	private final int id;
	private final String descricao;
	
	Permissoes(int id, String descricao) {
		this.id = id;
		this.descricao = descricao;
	}
	
	public int getCodigo() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}
}
