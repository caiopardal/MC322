package lab5;

import java.util.ArrayList;
import java.util.GregorianCalendar;

/*
 * Perguntas:
 *
 * 1-) Explique o que é polimorfismo, qual a sua importância e por quê deve ser utilizado.
 * R: Polimorfismo é um conceito de orientação a objetos, no qual pode-se realizar uma única ação de maneiras diferentes.
 * O mesmo deve ser utilizado, pois facilita na criação de diferentes estruturas e objetos que partem de uma interface 
 * comum. Visto que dessa forma, não seria necessário ficar alterando a estrutura previamente criada para incluir novos
 * tipos de objetos, desde que sejam seguidas as "regras" criadas na interface anteriormente.
 * 
 * 2-) Como é o funcionamento do polimorfismo na linguagem Java?
 * R: Possui duas formas, a primeira é a de que métodos de mesmo nome são definidos em várias classes (dentro da hierarquia),
 * de forma que possam assumir diferentes implementações em cada uma delas. E a segunda é a propriedade pela qual uma variável
 * pode apontar objetos de classes diferentes em momentos distintos.
 * 
 * 3-) O que acontece se instanciarmos uma subclasse em uma variável da superclasse e tentarmos chamar um 
 * método que não foi implementado na superclasse? Como você resolveria essa situação?
 * R: O programa não seria compilado, pois as operações que estamos tentando realizar estão em níveis diferentes.
 * Para resolver esse problema, precisaríamos realizar um downcasting, assim a variável teria o mesmo nível
 * do método e a invocação poderia acontecer.
 * 
 */

public class Main {

	public static void main(String[] args) {
		// Users
		UsuarioConvidado user1 = new UsuarioConvidado(1, "user1", "user1@gmail.com", "pwd1", "user 1", new GregorianCalendar(2002, 10, 9), true,  new GregorianCalendar(2020, 12, 01));
		System.out.println("User 1:\n" + user1 + "\n");
		
		UsuarioConvidado user2 = new UsuarioConvidado(2, "user2", "user2@gmail.com", "pwd2", "user 2", new GregorianCalendar(2002, 10, 18), false,  new GregorianCalendar(2020, 12, 01));	
		System.out.println("User 2:\n" + user2 + "\n");
		
		
		// Admins
		Admin admin1 = new Admin(3, "admin1", "admin1@gmail.com", "pwd1", "admin 2", new GregorianCalendar(2002, 10, 18), true);
		System.out.println("Admin 1:\n" + admin1 + "\n");
		
		Admin admin2 = new Admin(4, "admin2", "admin2@gmail.com", "pwd2", "admin 2", new GregorianCalendar(2002, 10, 18), false);
		System.out.println("Admin 2:\n" + admin2 + "\n");
		
		// only admins can create groups
		user1.criarGrupo("convidado 1", "teste 1", true);
		user2.criarGrupo("convidado 2", "teste 2", true);
		
		// admins can create a group
		admin1.criarGrupo("teste group", "group for testing", true);
		GrupoPrivado privateGroup = (GrupoPrivado) admin1.getGrupos().get(0);
		System.out.println(privateGroup.getNome());
		
		admin2.criarGrupo("teste admin 2", "second group for testing", false);
		GrupoPublico publicGroup = (GrupoPublico) admin2.getGrupos().get(0);
		System.out.println(publicGroup.getNome());
		System.out.println();
		
		// add user to a group with add and change permissions
		ArrayList<Permissao> permissaoAdicionarEAlterar = new ArrayList<Permissao>();
		permissaoAdicionarEAlterar.add(Permissao.ADICIONAR_USUARIO);
		permissaoAdicionarEAlterar.add(Permissao.ALTERAR_PERMISSAO);
		
		privateGroup.adicionaMembro(admin1, user2, permissaoAdicionarEAlterar);
		
		// add user to a group with add and remove permissions
		ArrayList<Permissao> removerEAdicionar = new ArrayList<Permissao>();
		removerEAdicionar.add(Permissao.ADICIONAR_USUARIO);
		removerEAdicionar.add(Permissao.REMOVER_USUARIO); 
		
		ArrayList<Permissao> adicionar = new ArrayList<Permissao>();
		removerEAdicionar.add(Permissao.ADICIONAR_USUARIO);
		
		privateGroup.adicionaMembro(admin1, user1, removerEAdicionar);
		
		// add user to a group with card permissions
		ArrayList<Permissao> cardPermissions = new ArrayList<Permissao>();
		cardPermissions.add(Permissao.VISUALIZAR_INFO);
		cardPermissions.add(Permissao.CRIAR_CARTAO);
		
		privateGroup.adicionaMembro(admin1, admin2, cardPermissions);
		
		System.out.println();
		
		// add and remove permissions
		privateGroup.adicionarPermissao(admin1, user1, permissaoAdicionarEAlterar);
		privateGroup.removerPermissao(admin1, user1, adicionar);
		
		// Creating cards
		admin1.criarCartao(privateGroup.getId());
		user1.criarCartao(privateGroup.getId());
		
		// private group
		for (int i = 0; i < privateGroup.membros.size(); i++) {
			System.out.println("-- Membro " + i + ": ");
			System.out.print(privateGroup.membros.get(i).getLogin()+ ", ");
			System.out.print(" (id: " + privateGroup.membros.get(i).getId() + "), ");
			System.out.print("e-mail: " + privateGroup.membros.get(i).getEmail() + ",");
			System.out.print("Senha: " + privateGroup.membros.get(i).getSenha() + ", ");
			System.out.print("Descrição do usuário: " + privateGroup.membros.get(i).getDescricao() + ", ");
			System.out.print("Data de ativação: " + privateGroup.membros.get(i).getDataAtivacao() + ", ");
			System.out.print("Status: " + privateGroup.membros.get(i).isStatus() + ";" + "\n");
		}
	}
}
