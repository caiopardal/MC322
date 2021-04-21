package lab4;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/*
 * Perguntas:
 *
 * 1-) Há alguma diferença entre utilizar atributos final e Enumerações ? Explique.
 * R: Sim, existe. Ao utilizar uma variável final, o programador só poderá definir, ao instanciar essa
 * variável, um único valor dentro de vários que podem vir a existir no tipo da variável. Porém, ao 
 * utilizar um enum, o programador pode definir um conjunto de valores possíveis, os quais podem ser
 * utilizados ao invocar uma variável desse tipo. Basicamente, o enum consegue realizar, com uma única
 * variável, o que várias variáveis final poderiam fazer dentro de um código.  
 * 
 * 2-) Na main tente instanciar uma nova Permissao (enum) com a palavra-chave new, o que acontece? 
 * Qual seria o motivo desse resultado?
 * R: Ao tentar realizar esse procedimento, ocorre um erro de compilação. Isso se dá , pois apesar de um
 * enum ser definido como uma classe, não há a possiblidade de instanciar objetos do mesmo, apenas utilizar
 * os atributos previamente criados.
 * 
 * 3-) Sobre os relacionamentos entre as classes: Em teoria, qual o tipo de relacionamento entre as 
 * Grupo(Privado e Público) e Usuario? E entre Usuario e Sala? (Lembre-se que relacionamentos são 
 * classificados em: Associação, Agregação e Composição.)
 * R: Entre Grupo(Privado e Público) e Usuário, temos uma Associação, pois grupos possuem usuários e
 * usuários possuem grupos, mas são independentes entre sim ou seja, não são partes obrigatórias um do
 * outro. Já entre Usuário e Sala, trata-se de uma agregação, pois uma sala possui um usuário, mas 
 * caso o usuário seja removido da sala, este ainda pode ser utilizado em uma outra sala.
 * 
 * 4-) Qual a multiplicidade dos relacionamentos citados na questão anterior?
 * R: Grupo e Usuário possuem multiplicidade muitos (*) em ambas as extremidades, pois vários grupos podem
 * ter vários usuários e vários usuários podem estar em vários grupos ao mesmo tempo. Já Usuário e Sala
 * é 1 pra muitos, pois uma sala pode ter muitos usuários, porém um usuário só pode ter uma sala.
 * 
 */

public class Main {

	public static void main(String[] args) {
		// Users
		Usuario user1 = new Usuario(1, "user1", "user1@email.com", "senha1", "descricao1", new GregorianCalendar(), true);
		Usuario user2 = new Usuario(2, "user2", "user2@email.com", "senha2", "descricao2", new GregorianCalendar(), false);
		Usuario user3 = new Usuario(3, "user3", "user3@email.com", "senha3", "descricao3", new GregorianCalendar(), true);
		Usuario user4 = new Usuario(4, "user4", "user4@email.com", "senha4", "descricao4", new GregorianCalendar(), false);
		
		// Admins
		Admin admin1 = new Admin();
		System.out.println("Admin 1:\n" + admin1 + "\n");
		
		Admin admin2 = new Admin();
		System.out.println("Admin 2:\n" + admin2 + "\n");
		
		// Private group
		GrupoPrivado grupoPrivado = new GrupoPrivado("grupoPrivado", "descricao - grupo privado", admin1);
		System.out.println("\n" + grupoPrivado + "\n");
		
		// Private group members
		ArrayList<Permissao> permissoes = new ArrayList<>();
		permissoes.add(Permissao.REMOVER_USUARIO);
		grupoPrivado.adicionaMembro(user1, admin1, permissoes);

		permissoes.add(Permissao.ALTERAR_PERMISSAO);
		grupoPrivado.adicionaMembro(user2, admin1, permissoes);

		permissoes.remove(Permissao.REMOVER_USUARIO);
		permissoes.add(Permissao.ADICIONAR_USUARIO);
		grupoPrivado.adicionaMembro(user3, admin1, permissoes);

		permissoes.remove(Permissao.ADICIONAR_USUARIO);
		permissoes.remove(Permissao.ALTERAR_PERMISSAO);
		permissoes.add(Permissao.VISUALIZAR_INFO);
		grupoPrivado.adicionaMembro(user4, user1, permissoes); // To show that only an owner can add
		System.out.println("\n" + grupoPrivado + "\n");

		// Public group
		GrupoPublico grupoPublico = new GrupoPublico("grupoPublico", "descricao - grupo publico", user2);
		System.out.println("\n" + grupoPublico + "\n");
		
		// Public group members
		permissoes = new ArrayList<>();
		permissoes.add(Permissao.REMOVER_USUARIO);
		grupoPublico.adicionaMembro(user1, user2, permissoes);

		permissoes.add(Permissao.ALTERAR_PERMISSAO);
		grupoPublico.adicionaMembro(user2, user2, permissoes);

		permissoes.remove(Permissao.REMOVER_USUARIO);
		permissoes.remove(Permissao.ALTERAR_PERMISSAO);
		permissoes.add(Permissao.VISUALIZAR_INFO);
		grupoPublico.adicionaMembro(user3, user2, permissoes);
		System.out.println("\n" + grupoPublico + "\n");
		
		//****Public Group tests****
		
		// Printing every public group member permission
		System.out.println("Permissão Adicionar:" + grupoPublico.getUsuariosPermissaoAdicionar() + "\n");
		System.out.println("Permissão Remover:" + grupoPublico.getUsuariosPermissaoRemover() + "\n");
		System.out.println("Permissão Alterar:" + grupoPublico.getUsuariosPermissaoAlterar() + "\n");
		System.out.println("Permissão Visualizar:" + grupoPublico.getUsuariosPermissaoVisualizar() + "\n");
		
		// Test an add to public group
		boolean hasAddedGroupMember = grupoPublico.adicionaMembro(user4, user2, permissoes);
		System.out.println("\nAdicionou usuário ao grupo? " + hasAddedGroupMember);
		System.out.println("\n" + grupoPublico + "\n");
		
		// Test a removal to public group
		boolean hasRemovedGroupMember = grupoPublico.removeMembro(user4, user2);
		System.out.println("\nRemoveu usuário do grupo? " + hasRemovedGroupMember);
		System.out.println("\n" + grupoPublico + "\n");
		
		// Test a permission addition to public group
		permissoes = new ArrayList<>();
		permissoes.add(Permissao.ADICIONAR_USUARIO);
		boolean hasAddedGroupMemberPermission = grupoPublico.adicionarPermissao(user1, user2, permissoes);
		System.out.println("\nAdicionou permissão ao usuário? " + hasAddedGroupMemberPermission);
		System.out.println("\n" + grupoPublico + "\n");
		
		// Test a permission removal to public group
		boolean hasRemovedGroupMemberPermission = grupoPublico.removerPermissao(user3, user2, permissoes);
		System.out.println("\nRemoveu permissão do usuário? " + hasRemovedGroupMemberPermission);
		System.out.println("\n" + grupoPublico + "\n");
		
		// Test a public group data visualization
		System.out.println("Nome:" + grupoPublico.getNome() + "\n");
		System.out.println("Dono:" + grupoPublico.getDono() + "\n");
		System.out.println("Status:" + grupoPublico.isStatus() + "\n");
		System.out.println("Membros:" + grupoPublico.getMembros() + "\n");
		
		//****Private group tests****
		
		// Printing every public group member permission
		System.out.println("Permissão Adicionar:" + grupoPrivado.getUsuariosPermissaoAdicionar() + "\n");
		System.out.println("Permissão Remover:" + grupoPrivado.getUsuariosPermissaoRemover() + "\n");
		System.out.println("Permissão Alterar:" + grupoPrivado.getUsuariosPermissaoAlterar() + "\n");
		System.out.println("Permissão Visualizar:" + grupoPrivado.getUsuariosPermissaoVisualizar() + "\n");
		
		// Test a permission addition to private group member
		permissoes = new ArrayList<Permissao>();
		permissoes.add(Permissao.REMOVER_USUARIO);
		hasAddedGroupMemberPermission = grupoPrivado.adicionarPermissao(user1, admin1, permissoes);
		System.out.println("\nAdicionou permissão ao usuário? " + hasAddedGroupMemberPermission);
		System.out.println("\n" + grupoPrivado + "\n");
		
		// Test if this user can remove a user (should fail, because he is not an owner)
		boolean userRemovedAnotherUser = grupoPrivado.removeMembro(user3, user1);
		System.out.println("\nRemoveu usuário? " + userRemovedAnotherUser);
		System.out.println("\n" + grupoPrivado + "\n");
		
		// Test a permission removal to private group member
		hasRemovedGroupMemberPermission = grupoPrivado.removerPermissao(user4, admin1, permissoes);
		System.out.println("\nRemoveu permissão do usuário? " + hasRemovedGroupMemberPermission);
		System.out.println("\n" + grupoPrivado + "\n");
	}
}
