package lab2;

import java.util.GregorianCalendar;
import java.util.Scanner;

/*
 * Perguntas:
 * 
 * 1-) É possível escrever uma classe sem escrever nenhum construtor? Por quê?
 * R: Sim, isso é possível, pois ao compilar o código em Java, o compilador fornece, automaticamente, um
 * construtor público e sem argumentos, para todas as classes que não possuírem um construtor. Esse construtor
 * é chamado de construtor padrão.
 * 
 * 2-) Um método estático pode acessar uma variável (atributo) não estático da classe? Por quê?
 * R: Isso não é possível, pois dentro do método estático, não teremos acesso à referência "this", visto que
 * um método estático é chamado através da classe e não de um objeto da classe. Assim, o mesmo não possui
 * acesso aos atributos não estáticos, somente aos estáticos.
 * 
 * 3-) Um método não estático pode acessar uma variável (atributo) estático da classe? Por quê?
 * R: Sim, ele pode. Isso se deve, pois esses métodos podem ser chamados através do objeto de uma 
 * determinada classe. O que faz com que ele tenha acesso a todos os atributos da classe que aquele 
 * objeto pertence, sendo estáticos ou não. 
 * 
 */

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		Usuario user1 = new Usuario(1, "user1", "user1@email.com", "senha1", new GregorianCalendar(), true);
		Usuario user2 = new Usuario(2, "user2", "user2@email.com", "senha2", new GregorianCalendar(), false);
		
		Perfil perfil1 = new Perfil('M', new GregorianCalendar(), "cidade1", "estado1", "11911111111", "primeiro perfil", new String[] {"str1", "str2"});
		Perfil perfil2 = new Perfil('F', new GregorianCalendar(), "cidade2", "estado2", "11922222222", "segundo perfil", new String[] {"str1", "str2"});
	
		System.out.println("Usuario 1:\n" + user1);
		System.out.println("Usuario 2:\n" + user2);
		System.out.println("Perfil 1:\n" + perfil1);
		System.out.println("Perfil 2:\n" + perfil2);
		
		Sala sala1 = new Sala();
		System.out.println("Sala 1 - Sem parâmetros:\n" + sala1);
		
		int numeroSalas = 1;
		
		System.out.println("Insira a capacidade máxima da sala 1:");
		int capacidadeMaxima = scan.nextInt();
		
		System.out.println("Insira o número de usuários da sala 1:");
		int numeroUsuarios = scan.nextInt();
		
		System.out.println("Insira a descricao da sala 1:");
		String descricao = scan.next();
	
		int auxForSubscription = 0;
		
		boolean ingressoAutomatico;
		if (auxForSubscription == 0) {
			ingressoAutomatico = true;
		} else {
			ingressoAutomatico = false;
		}
		
		GregorianCalendar dataCriacao = new GregorianCalendar();
		
		sala1.setNumeroSalas(numeroSalas);
		sala1.setNumeroUsuarios(numeroUsuarios);
		sala1.setCapacidadeMaxima(capacidadeMaxima);
		sala1.setDescricao(descricao);
		sala1.setDono(user1);
		sala1.setIngressoAutomatico(ingressoAutomatico);
		sala1.setDataCriacao(dataCriacao);
		
		System.out.println("Sala 1 - Pós set de parâmetros:\n" + sala1);
		
		boolean addedNewUser = false;
		
		sala1.setNumeroUsuarios(9);
		sala1.setCapacidadeMaxima(10);
		addedNewUser = sala1.adicionaUsuario();
		if (addedNewUser) {
			System.out.println("Sala 1 - Pós adicionar usuário:\n" + sala1);
		}
		
		
		sala1.setNumeroUsuarios(10);
		sala1.setCapacidadeMaxima(10);
		addedNewUser = sala1.adicionaUsuario();
		
		if (!addedNewUser) {
			System.out.println("Sala 1 - Falha no adição de usuário:\n" + sala1);
		}
		
		boolean removedUser = false;
		removedUser = sala1.removeUsuario();
		
		if (removedUser) {
			System.out.println("Sala 1 - Pós remoção de usuário:\n" + sala1);
		}
		
		sala1.setNumeroUsuarios(0);
		removedUser = sala1.removeUsuario();
		
		if (!removedUser) {
			System.out.println("Sala 1 - Falha na remoção de usuário:\n" + sala1);
		}
		
		Sala sala2 = new Sala();
		
		numeroSalas = 2;
		
		System.out.println("Insira a capacidade máxima da sala 2:");
		capacidadeMaxima = scan.nextInt();
		
		System.out.println("Insira o número de usuários da sala 2:");
		numeroUsuarios = scan.nextInt();
		
		System.out.println("Insira a descricao da sala 2:");
		descricao = scan.next();
		
		System.out.println("A sala contará com ingresso automático? Se sim, digite 0. Se não, digite 1:");
		auxForSubscription = scan.nextInt();
		
		ingressoAutomatico = false;
		if (auxForSubscription == 0) {
			ingressoAutomatico = true;
		} else {
			ingressoAutomatico = false;
		}
		
		dataCriacao = new GregorianCalendar();
		
		sala2.setNumeroSalas(numeroSalas);
		sala2.setNumeroUsuarios(numeroUsuarios);
		sala2.setCapacidadeMaxima(capacidadeMaxima);
		sala2.setDescricao(descricao);
		sala2.setDono(user2);
		sala2.setIngressoAutomatico(ingressoAutomatico);
		sala2.setDataCriacao(dataCriacao);
		
		System.out.println("Sala 2 - Pós set de parâmetros:\n" + sala2);
		
		addedNewUser = false;
		
		sala2.setNumeroUsuarios(9);
		sala2.setCapacidadeMaxima(10);
		addedNewUser = sala1.adicionaUsuario();
		if (addedNewUser) {
			System.out.println("Sala 2 - Pós adicionar usuário:\n" + sala2);
		}
		
		
		sala2.setNumeroUsuarios(10);
		sala2.setCapacidadeMaxima(10);
		addedNewUser = sala2.adicionaUsuario();
		
		if (!addedNewUser) {
			System.out.println("Sala 2 - Falha no adição de usuário:\n" + sala2);
		}
		
		removedUser = false;
		removedUser = sala2.removeUsuario();
		
		if (removedUser) {
			System.out.println("Sala 2 - Pós remoção de usuário:\n" + sala2);
		}
		
		sala2.setNumeroUsuarios(0);
		removedUser = sala2.removeUsuario();
		
		if (!removedUser) {
			System.out.println("Sala 2 - Falha na remoção de usuário:\n" + sala2);
		}
		
		Cartao cartao1 = new Cartao();
		System.out.println("Cartao 1 - Sem parâmetros:\n" + cartao1);
		
		int numeroCartoes = 1;
		
		System.out.println("Insira a visibilidade do cartão 1:");
		int visibilidade = scan.nextInt();
		
		System.out.println("Insira o nome do cartao 1:");
		String nome = scan.next();
		
		System.out.println("O cartão será visto só por quem tiver convite? Se sim, digite 0. Se não, digite 1:");
		int auxForVisibility = scan.nextInt();
		
		boolean invitationOnly;
		if (auxForVisibility == 0) {
			invitationOnly = true;
		} else {
			invitationOnly = false;
		}
		
		GregorianCalendar dataCriacaoCartao = new GregorianCalendar();
		
		cartao1.setNumeroCartoes(numeroCartoes);
		cartao1.setVisibilidade(visibilidade);
		cartao1.setNome(nome);
		cartao1.setDono(user1);
		cartao1.setInvitationOnly(invitationOnly);
		cartao1.setDataCriacao(dataCriacaoCartao);
		
		System.out.println("Cartão 1 - Pós set de parâmetros:\n" + cartao1);
		
		numeroCartoes = cartao1.getNumeroCartoes();
		System.out.println("Número do cartão:\n" + numeroCartoes);
		
		Cartao cartao2 = new Cartao();
		System.out.println("Cartao 2 - Sem parâmetros:\n" + cartao1);
		
		numeroCartoes = 2;
		
		System.out.println("Insira a visibilidade do cartão 2:");
		visibilidade = scan.nextInt();
		
		System.out.println("Insira o nome do cartao 2:");
		nome = scan.next();
		
		System.out.println("O cartão será visto só por quem tiver convite? Se sim, digite 0. Se não, digite 1:");
		auxForVisibility = scan.nextInt();
		
		invitationOnly = false;
		if (auxForVisibility == 0) {
			invitationOnly = true;
		} else {
			invitationOnly = false;
		}
		
		dataCriacaoCartao = new GregorianCalendar();
		
		cartao2.setNumeroCartoes(numeroCartoes);
		cartao2.setVisibilidade(visibilidade);
		cartao2.setNome(nome);
		cartao2.setDono(user2);
		cartao2.setInvitationOnly(invitationOnly);
		cartao2.setDataCriacao(dataCriacaoCartao);
		
		System.out.println("Cartão 2 - Pós set de parâmetros:\n" + cartao2);
		
		numeroCartoes = cartao2.getNumeroCartoes();
		System.out.println("Número do cartão:\n" + numeroCartoes);
		
		scan.close();
	}
}
