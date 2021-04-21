package lab3;

import java.util.GregorianCalendar;

/*
 * Perguntas:
 *
 * 1-) Tente modificar o valor da dono de um grupo (que é um atributo final). Crie um setter 
 * se necessário. Foi possível fazer a modificação? Explique.
 * R: Não foi possível fazer essa modificação, justamente por esse atributo possuir um modificador
 * do tipo final. Ao declarar um atributo com o modificador final, estamos assumindo que ao atribuir
 * um valor ao atributo, este não poderá ser modificado mais.
 * 
 * 2-) Agora, no método main, crie uma variável final do tipo Grupo, e instancie ela com os valores 
 * que preferir. Tente modificar algum atributo do objeto através de um setter, como o atributo referente
 * ao id. Foi possível modificar esse atributo, mesmo com o objeto sendo final? Por quê?
 * R: Sim, é possível. Isso acontece, pois o modificador final mantém uma referência fixa para o mesmo objeto 
 * de Grupo, ou seja, o objeto criado não poderá ser modificado. Porém, os seus atributos, não são definidos como
 * final, permitindo que os seus valores sejam sim alterados. 
 * 
 * 3-) Se ao invés de usar ArrayList para definir a lista de membros da classe Grupo tivéssemos usado 
 * um array, o que mudaria na implementação? Poderíamos continuar adicionado membros como fizemos? 
 * Haveria alguma limitação? Discuta as desvantagens dessa solução.
 * R: Caso um array fosse escolhido, teríamos que mudar toda a lógica ao redor da lista de membros
 * de um grupo. Isso se deve, pois arrays possuem tamanhos fixos, uma vez que instanciados. Dessa maneira, 
 * teríamos que modificar a implementação de forma que mesmo tendo um array de tamanho fixo, conseguíssemos 
 * adicionar membros aos grupos e de forma transparente para o usuário. Por exemplo, poderíamos definir um 
 * número máximo de membros que um grupo pode ter e notificar isso ao usuário e sempre checar tal propriedade,
 * antes de fazer uma adição no grupo. O que é uma limitação grande, visto que podemos usar um ArrayList, de tamanho
 * variável e abstrair esse tipo de implementação e dificuldade no código.
 * 
 * 4-) Qual o principal benefício da herança?
 * R: O principal benefício da herança é o reaproveitamento de código e compreensão/entendimento do mesmo. 
 * Isso é dito, pois ao utilizarmos a herança durante a construção de classes, temos a capacidade de reaproveitar
 * métodos e atributos que já foram feitos anteriormente, mas mesmo assim, adicionar novos métodos para contemplar
 * novas funcionalidades que venham a surgir. Evitando reescrita de código e facilitando na manutenção geral do
 * sistema.
 * 
 * 5-) Adicione final na classe Grupo. O que aconteceu com o código? Por que isso aconteceu? Em vez de 
 * Grupo ser final e se definirmos GrupoPublico como final?
 * R: O código recebeu vários problemas de compilação relacionados às subclasses da classe Grupo. Isso 
 * aconteceu, pois ao definir grupo como final, não podemos criar subclasses a partir dela. Caso, fizéssemos o
 * mesmo para GrupoPublico, o código compilaria normalmente, porém sempre que instanciássemos um objeto do tipo
 * GrupoPublico, este objeto não poderia sofrer alterações, somente seus atributos.
 * 
 * 6-) Por que definimos os métodos adicionaMembro e removeMembro nas classes filhas e não na classe 
 * mãe (Grupo)?
 * R: Adicionamos nas classes filhas, pois cada uma das classes filhas possui suas especificidades, ou seja,
 * cada uma delas realiza operações diferentes dentro de cada um dos métodos definidos, mesmo que no final
 * acabem tendo um mesmo propósito, que é o de adicionar ou remover membros do grupo. Caso fizéssemos na classe mãe,
 * precisaríamos sobrescrever esses métodos para contemplar as especificações de cada um, o que seria uma má decisão
 * de projeto e prática de programação, visto que não utilizaríamos a implementação feita na classe mãe e não 
 * utilizaríamos das vantagens da Herança.
 */

public class Main {

	public static void main(String[] args) {
		Usuario user1 = new Usuario(1, "user1", "user1@email.com", "senha1", "descricao1", new GregorianCalendar(), true);
		Usuario user2 = new Usuario(2, "user2", "user2@email.com", "senha2", "descricao2", new GregorianCalendar(), false);
		Usuario user3 = new Usuario(3, "user3", "user3@email.com", "senha3", "descricao3", new GregorianCalendar(), true);
		Usuario user4 = new Usuario(4, "user4", "user4@email.com", "senha4", "descricao4", new GregorianCalendar(), false);
		
		Admin admin = new Admin();
		System.out.println("Admin:\n" + admin + "\n");
		
		GrupoPrivado grupoPrivado = new GrupoPrivado("grupoPrivado", "descricao - grupo privado", user1);
		System.out.println(grupoPrivado + "\n");

		GrupoPublico grupoPublico = new GrupoPublico("grupoPublico", "descricao - grupo publico", user2);
		grupoPublico.adicionaMembro(user3);
		grupoPublico.adicionaMembro(user4);
		System.out.println(grupoPublico + "\n");
		
		// Test if a group owner can be modified
		Usuario groupOwner = grupoPublico.getDono();
		groupOwner = user1;
		System.out.println("Grupo Publico com dono não sendo alterado mesmo com alguma atribuição:\n" + grupoPublico.getDono());	
		System.out.println("O dono ainda é o user2!");
		
		// Test if a group status can be modified by any user
		boolean hasChangedGroupStatus = grupoPublico.setStatus(false, user2);
		System.out.println("\nMudou status do grupo? " + hasChangedGroupStatus);
		
		hasChangedGroupStatus = admin.desabilitarGrupo(grupoPublico);
		System.out.println("\nMudou status do grupo? " + hasChangedGroupStatus);
		System.out.println("Só nesse caso ficou true!");
		
		// Test if only a group owner can add members to a group
		grupoPrivado.adicionaMembro(user2, user2);
		System.out.println("\nGrupo pós modificação por usuário não dono:\n" + grupoPrivado);
		System.out.println("Grupo ainda não possui nenhum membro, mesmo após tentativa de adição!");
		
		grupoPrivado.adicionaMembro(user4, user1);
		grupoPrivado.adicionaMembro(user2, user1);
		System.out.println("\nGrupo pós modificação por usuário que é dono:\n" + grupoPrivado);
		System.out.println("Grupo agora possui os dois membros adicionados, como previsto");
	}
}
