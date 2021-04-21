package lab6;

import java.util.ArrayList;
import java.util.Calendar;

/*
 * Perguntas:
 *
 * 1-) Baseado nos conceitos de interface e classe abstrata e na arquitetura hierarquica da classe Grupo e 
 * suas subclasses GrupoPublico e GrupoPrivado, a classe Grupo deverá:
 * R: Ser alterada e implementada como uma Classe Abstrata.
 * 
 * 2-) Qual foi a estratégia abordada: Interface, Classe Abstrata ou manutenção da classe concreta? Explique 
 * sua escolha.
 * R: A estratégia abordada foi alterar a classe Grupo e torná-la abstrata, porque é necessário que o seus
 * métodos e atributos sejam utilizados e sobrescritos pelas classes herdeiras (Grupo Privado e Público) e como nenhuma outra
 * classe compartilha dos mesmos métodos de Grupo, não se faz necessária a criação de uma interface. 
 * 
 * 3-) Em outra possível abordagem, a classe Usuario poderia ser implementada como uma Interface? Caso sim, por quê? 
 * Quais alterações seriam necessárias?
 * Sim, isso seria possível. Porém, para que essa mudança fosse considerada efetiva, precisaríamos ter heranças múltiplas 
 * de tipo ou se as classes tivessem uma interação maior entre elas. Sobre as mudanças necessárias, precisaríamos mudar 
 * a sintaxe da classe Usuário e dos métodos dessa nova interface.
 * 
 */

public class Main {

	public static void main(String[] args) {
		//criando perfis
		UsuarioComum user1 = new UsuarioComum(1, "Login user1", new Perfil(Sexo.FEMININO, Calendar.getInstance(), "Cidade user1", Estado.Amapa, "telefone user1", "user1", "foto user1"), "email user1", "senha user1", Calendar.getInstance(), true);
		System.out.println(user1.getLogin());
		
		UsuarioComum user2 = new UsuarioComum(1, "Login user2", new Perfil(Sexo.FEMININO, Calendar.getInstance(), "Cidade user2", Estado.Amapa, "telefone user2", "user2", "foto user2"), "email user2", "senha user2", Calendar.getInstance(), true);
		System.out.println(user2.getLogin());
		
		UsuarioComum user3 = new UsuarioComum(1, "Login user3", new Perfil(Sexo.FEMININO, Calendar.getInstance(), "Cidade user3", Estado.Amapa, "telefone user3", "user3", "foto user3"), "email user3", "senha user3", Calendar.getInstance(), true);
		System.out.println(user3.getLogin());
		
		UsuarioConvidado userConv1 = new UsuarioConvidado(4, "Login userConv1", new Perfil(Sexo.MASCULINO, Calendar.getInstance(), "Cidade userConv1", Estado.Acre, "telefone userConv1", "userConv1", "foto userConv1"), "email userConv1", "senha userConv1", Calendar.getInstance(), true, Calendar.getInstance());
		System.out.println(userConv1.getLogin());
		
		UsuarioConvidado userConv2 = new UsuarioConvidado(4, "Login userConv2", new Perfil(Sexo.MASCULINO, Calendar.getInstance(), "Cidade userConv2", Estado.Acre, "telefone userConv2", "userConv2", "foto userConv2"), "email userConv2", "senha userConv2", Calendar.getInstance(), true, Calendar.getInstance());
		System.out.println(userConv2.getLogin());
		
		UsuarioConvidado userConv3 = new UsuarioConvidado(4, "Login userConv3", new Perfil(Sexo.MASCULINO, Calendar.getInstance(), "Cidade userConv3", Estado.Acre, "telefone userConv3", "userConv3", "foto userConv3"), "email userConv3", "senha userConv3", Calendar.getInstance(), true, Calendar.getInstance());
		System.out.println(userConv3.getLogin());
		
		Admin admin1 = new Admin(7, "Login admin1", new Perfil(Sexo.FEMININO, Calendar.getInstance() , "Cidade admin1", Estado.Distrito_Federal, "telefone admin1", "admin1", "foto admin1"), "email admin1", "senha admin1", Calendar.getInstance(), true);
		System.out.println(admin1.getLogin()); 
		
		Admin admin2 = new Admin(7, "Login admin2", new Perfil(Sexo.FEMININO, Calendar.getInstance(), "Cidade admin2", Estado.Distrito_Federal, "telefone admin2", "admin2", "foto admin2"), "email admin2", "senha admin2", Calendar.getInstance(), true);
		System.out.println(admin2.getLogin());
		
		Admin admin3 = new Admin(7, "Login admin3", new Perfil(Sexo.FEMININO, Calendar.getInstance(), "Cidade admin3", Estado.Distrito_Federal, "telefone admin3", "admin3", "foto admin3"), "email admin3", "senha admin3", Calendar.getInstance(), true);
		System.out.println(admin3.getLogin());
		
		System.out.println();
		
		System.out.println("Crie N grupos, privados e públicos:");

		boolean hasCreatedPublicGroup1 = admin1.criarGrupo("publicGroup1", "first public group", false); 
		if (hasCreatedPublicGroup1 == true) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();
		
		boolean hasCreatedPrivateGroup1 = admin1.criarGrupo("privateGroup1", "first private group", true); 
		if (hasCreatedPrivateGroup1 == true) System.out.println(" Grupo criado!");
		else System.out.println(" Não foi possível criar o grupo!");
		System.out.println();

		ArrayList<Permissao> permissions = new ArrayList<Permissao>();
		permissions.add(Permissao.ADICIONAR_USUARIO);

		// public group
		System.out.println("Adicione ao menos 3 usuários ao grupo, um usuário de cada tipo.");
		System.out.println();
		
		if (admin1.grupos.get(0).adicionaMembro(user1, admin1, permissions) == false) {
			System.out.println( "Nao foi possivel adicionar o membro no grupo!");
		} else System.out.println( "Membro adicionado no grupo!");
		
		if (admin1.grupos.get(0).adicionaMembro(userConv1, admin1, permissions) == false) {
			System.out.println( "Nao foi possivel adicionar o membro no grupo!");
		} else System.out.println( "Membro adicionado no grupo!");
		
		if (admin1.grupos.get(0).adicionaMembro(admin1, admin2, permissions) == false) {
			System.out.println( "Nao foi possivel adicionar o membro no grupo!");
		} else System.out.println( "Membro adicionado no grupo!");
		
		System.out.println();

		System.out.println("Utilize um usuário do grupo para criar 6 cartões com diferentes níveis de prioridade e atribuia como o responsável algum outro usuário do grupo.");
		if (admin1.criarCartao(0, 1, 1, "primeiro cartão", user1, "assunto cartão 1", true) == false) {
			System.out.println( "Nao foi possivel criar cartao!");
		} else System.out.println( "Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 2, "cartão 2", user1, "assunto cartão 2", true) == false) {
			System.out.println( " Nao foi possivel criar cartao!");
		} else System.out.println( "Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 3, "cartão 3", user1, "assunto cartão 3", true) == false) {
			System.out.println( "Nao foi possivel criar cartao!");
		} else System.out.println( "Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 4, "cartão 4", user1, "assunto cartão 4", true) == false) {
			System.out.println( "Nao foi possivel criar cartao!");
		} else System.out.println( "Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 5, "cartão 5", user1, "assunto cartão 5", true) == false) {
			System.out.println( "Nao foi possivel criar cartao!");
		} else System.out.println( "Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 6, "cartão 6", user1, "assunto cartão 6", true) == false) {
			System.out.println( "Nao foi possivel criar cartao!");
		} else System.out.println( "Cartao criado!");
		
		System.out.println();

		System.out.println("Imprima os cartoes criados:");
		
		System.out.println(admin1.getGrupos().get(0).getCartoesAFazer());
		System.out.println(); 

		System.out.println("Execute todos os cartões criados de acordo com suas prioridades.:");
		
		if (user1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(0).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
			
		if (user1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(0).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (user1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(0).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (user1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(0).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (user1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(0).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (user1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(0).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		// private group
		System.out.println("Adicione ao menos 3 usuários ao grupo, um usuário de cada tipo.");
		System.out.println();
		
		if (admin1.getGrupos().get(1).adicionaMembro(user1, admin1, permissions) == false) {
			System.out.println("Nao foi possivel adicionar o membro no grupo!");
		} else System.out.println("Membro adicionado no grupo!");
		
		if (admin1.getGrupos().get(1).adicionaMembro(userConv2, admin1, permissions) == false) {
			System.out.println("Nao foi possivel adicionar o membro no grupo!");
		} else System.out.println("Membro adicionado no grupo!");
		
		if (admin1.getGrupos().get(1).adicionaMembro(admin1, admin2, permissions) == false) {
			System.out.println("Nao foi possivel adicionar o membro no grupo!");
		} else System.out.println("Membro adicionado no grupo!");
		
		System.out.println();

		System.out.println("Utilize um usuário do grupo para criar 6 cartões com diferentes níveis de prioridade e atribuia como o responsável algum outro usuário do grupo.");
		if (admin1.criarCartao(0, 1, 1, "primeiro cartão", userConv1, "assunto cartão 1", true) == false) {
			System.out.println("Nao foi possivel criar cartao!");
		} else System.out.println("Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 2, "cartão 2", userConv1, "assunto cartão 2", true) == false) {
			System.out.println("Nao foi possivel criar cartao!");
		} else System.out.println("Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 3, "cartão 3", userConv1, "assunto cartão 3", true) == false) {
			System.out.println("Nao foi possivel criar cartao!");
		} else System.out.println("Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 4, "cartão 4", userConv1, "assunto cartão 4", true) == false) {
			System.out.println("Nao foi possivel criar cartao!");
		} else System.out.println("Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 5, "cartão 5", userConv1, "assunto cartão 5", true) == false) {
			System.out.println("Nao foi possivel criar cartao!");
		} else System.out.println("Cartao criado!");
		
		if (admin1.criarCartao(0, 1, 6, "cartão 6", userConv1, "assunto cartão 6", true) == false) {
			System.out.println("Nao foi possivel criar cartao!");
		} else System.out.println("Cartao criado!");
		
		System.out.println();

		System.out.println("Imprima os cartoes criados:");
		System.out.println(admin1.getGrupos().get(1).getCartoesAFazer());
		System.out.println();

		System.out.println("Execute todos os cartões criados de acordo com suas prioridades.:");
		if (userConv1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(1).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
			
		if (userConv1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(1).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (userConv1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(1).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (userConv1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(1).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (userConv1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(1).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
		
		if (userConv1.executarTarefaDeMaiorPrioridade() == false) {
			System.out.println("Nao foi possivel executar tarefa!");
		} else System.out.println("Tarefa de maior prioridade executada");
		
		for (Cartao cartao: admin1.getGrupos().get(1).getCartoesAFazer()) {
			System.out.println("id= " + cartao.getId());
			System.out.println("cartao = " + cartao.getNome());
			System.out.println("labels = " + cartao.getLabels());
			System.out.println("prioridade: "+ cartao.getPrioridade() + "\n");
		}
	}
}
