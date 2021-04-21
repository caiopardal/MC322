package lab1;

import java.util.Date;

/*
 * Perguntas:
 * 
 * 1-) Qual o impacto de se tentar mudar diretamente o valor do atributo login de um dos Objetos Usuario no método main? Por quê?
 * R: O atributo "login" é um atributo privado, ou seja, o seu acesso é restrito à classe Usuario e não devemos chamá-lo diretamente. 
 * Somente através dos métodos de acesso criados para o mesmo. Portanto, caso seja feita uma tentativa de alterar esse valor diretamente,
 * o compilador apontará um erro e o acesso e alteração não será feito. Isso se deve, pois cada classe é responsável por garantir a integridade
 * e validação dos valores que deverão existir em cada um de seus atributos. Além de centralizar a responsabilidade da validação dos dados pra cada
 * classe, isso ainda facilita mudanças futuras no sistema.
 * 
 * 2-) Como você trataria o problema levantado na questão anterior? Qual seriam os prós e contras desta nova abordagem? Que conceito de 
 * orientação a objetos estaria sendo "quebrado" neste caso?
 * R: Caso você queira acessar diretamente pela main o valor desse atributo, você precisaria torná-lo público para todas as classes. Fazendo isso,
 * você quebraria o conceito de "encapsulamento" de Orientação a objetos, o que faria com que você precisasse fazer mudanças em diversos lugares, caso
 * quisesse oferecer uma manutenção à uma classe ou atributo, aumentando a complexidade do programa e tornando-o suscetível à erros. 
 */

public class Main {

	public static void main(String[] args) {
		Usuario user1 = new Usuario(1, "user1", "user1@email.com", "senha1", new Date(), true);
		Usuario user2 = new Usuario(2, "user2", "user2@email.com", "senha2", new Date(), false);
		
		Perfil perfil1 = new Perfil('M', new Date(), "cidade1", "estado1", "11911111111", "primeiro perfil", new String[] {"str1", "str2"});
		Perfil perfil2 = new Perfil('F', new Date(), "cidade2", "estado2", "11922222222", "segundo perfil", new String[] {"str1", "str2"});
	
		System.out.println("Usuario 1:\n" + user1);
		System.out.println("Usuario 2:\n" + user2);
		System.out.println("Perfil 1:\n" + perfil1);
		System.out.println("Perfil 2:\n" + perfil2);
	}
}
