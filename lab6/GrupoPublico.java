package lab6;

import java.util.ArrayList;
import java.util.Calendar;

public class GrupoPublico extends Grupo {
	public GrupoPublico(String nome, String descricao, Usuario dono, Calendar dataCriacao) {
		super(nome, descricao, dono, dataCriacao);
		super.permissaoAdicionar.add(dono);
		super.permissaoRemover.add(dono);
		super.permissaoAlterar.add(dono);
		super.permissaoVisualizar.add(dono);
	}

	public GrupoPublico(int id, String nome, String descricao, Usuario dono, boolean status,
			Calendar dataCriacao) {
		super(id, nome, descricao, dono, status, dataCriacao);
		super.permissaoAdicionar.add(dono);
		super.permissaoRemover.add(dono);
		super.permissaoAlterar.add(dono);
		super.permissaoVisualizar.add(dono);
	}
	
	@Override
	public String toString() {
		StringBuilder out = new StringBuilder(); 
		
		out.append("GrupoPublico [getId=" + getId());

		out.append(", getNome()=" + getNome());
		out.append(", getDescricao()=" + getDescricao());
		out.append(", isStatus()=" + isStatus());
		out.append(", getDono()=" + getDono());
		if (getMembros() != null && !getMembros().isEmpty()) {
			out.append("\nMembros:\n");
			for (int i=0; i < getMembros().size(); i++) {
				Usuario membro = getMembros().get(i);
				out.append(" * " + membro + "\n");
			}
		}
		if (getUsuariosPermissaoAdicionar() != null && !getUsuariosPermissaoAdicionar().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoAdicionar().size(); i++) {
				out.append("\nUsuário Permissão Adicionar:\n");
				Usuario usuario = getUsuariosPermissaoAdicionar().get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (getUsuariosPermissaoRemover() != null && !getUsuariosPermissaoRemover().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoRemover().size(); i++) {
				out.append("\nUsuário Permissão Remover:\n");
				Usuario usuario = getUsuariosPermissaoRemover().get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (getUsuariosPermissaoAlterar() != null && !getUsuariosPermissaoAlterar().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoAlterar().size(); i++) {
				out.append("\nUsuário Permissão Alterar:\n");
				Usuario usuario = getUsuariosPermissaoAlterar().get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (getUsuariosPermissaoVisualizar() != null && !getUsuariosPermissaoVisualizar().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoVisualizar().size(); i++) {
				out.append("\nUsuário Permissão Visualizar:\n");
				Usuario usuario = getUsuariosPermissaoVisualizar().get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		if (getUsuariosPermissaoCriarCartao() != null && !getUsuariosPermissaoCriarCartao().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoCriarCartao().size(); i++) {
				out.append("\nUsuário Permissão Criar Cartão:\n");
				Usuario usuario = getUsuariosPermissaoCriarCartao().get(i);
				out.append(" * " + usuario + "\n");
			}
		}
		out.append("\n" + "Cartões do grupo a fazer: ");
		for (int i = 0; i < this.cartoesAFazer.size(); i++) {
			out.append(this.cartoesAFazer.get(i).getNome() + "; ");
		}
		out.append("\n" + "Cartões do grupo feitos: ");
		for (int i = 0; i < this.cartoesFeitos.size(); i++) {
			out.append(this.cartoesFeitos.get(i).getNome() + "; ");
		}
		out.append("];");

		return out.toString();
}

	public boolean adicionaMembro(Usuario usuario, Usuario actionUser, ArrayList<Permissao> permissoes) {
		boolean status = this.isStatus();
		
		if (status) {
			membros.add(usuario);
			usuario.getGrupos().add(this);
			if (permissoes != null && !permissoes.isEmpty()) {
				if (getUsuariosPermissaoAdicionar().contains(actionUser) || actionUser.getClass() == Admin.class) {
					if (permissoes.contains(Permissao.ADICIONAR_USUARIO) && !this.getUsuariosPermissaoAdicionar().contains(usuario)) {
						this.permissaoAdicionar.add(usuario);
					} else if (permissoes.contains(Permissao.ALTERAR_PERMISSAO) && !this.getUsuariosPermissaoAlterar().contains(usuario)) {
						this.permissaoAlterar.add(usuario);
					} else if (permissoes.contains(Permissao.REMOVER_USUARIO) && !this.getUsuariosPermissaoRemover().contains(usuario)) {
						this.permissaoRemover.add(usuario);
					} else if (permissoes.contains(Permissao.VISUALIZAR_INFO) && !this.getUsuariosPermissaoVisualizar().contains(usuario)) {
						this.permissaoVisualizar.add(usuario);
					} else if (permissoes.contains(Permissao.CRIAR_CARTAO) && !this.getUsuariosPermissaoCriarCartao().contains(usuario)) {
						this.permissaoCriarCartao.add(usuario);
					}
					
					return true;
				} else {
					return false;
				}
			}
		}
		
		return false;
	}
	
	public boolean removeMembro(Usuario usuario, Usuario actionUser) {
		boolean status = this.isStatus();
		
		if (status) {
			if (this.getMembros().contains(usuario)) {
				if (getUsuariosPermissaoRemover().contains(actionUser)) {
					membros.remove(usuario);
					usuario.removerGrupo(this);
					permissaoAdicionar.remove(usuario);
					permissaoRemover.remove(usuario);
					permissaoAlterar.remove(usuario);
					permissaoVisualizar.remove(usuario);
					permissaoCriarCartao.remove(usuario);
					
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean adicionarPermissao(Usuario usuario, Usuario actionUser, ArrayList<Permissao> permissoes) {	
		if (permissoes != null && !permissoes.isEmpty()) {
			if (getUsuariosPermissaoAlterar().contains(actionUser)) {
				if (permissoes.contains(Permissao.ADICIONAR_USUARIO) && !this.getUsuariosPermissaoAdicionar().contains(usuario)) {
					this.permissaoAdicionar.add(usuario);
				} else if (permissoes.contains(Permissao.ALTERAR_PERMISSAO) && !this.getUsuariosPermissaoAlterar().contains(usuario)) {
					this.permissaoAlterar.add(usuario);
				} else if (permissoes.contains(Permissao.REMOVER_USUARIO) && !this.getUsuariosPermissaoRemover().contains(usuario)) {
					this.permissaoRemover.add(usuario);
				} else if (permissoes.contains(Permissao.VISUALIZAR_INFO) && !this.getUsuariosPermissaoVisualizar().contains(usuario)) {
					this.permissaoVisualizar.add(usuario);
				} else if (permissoes.contains(Permissao.CRIAR_CARTAO) && !this.getUsuariosPermissaoCriarCartao().contains(usuario)) {
					this.permissaoCriarCartao.add(usuario);
				}

				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean removerPermissao(Usuario usuario, Usuario actionUser, ArrayList<Permissao> permissoes) {
		if (permissoes != null && !permissoes.isEmpty()) {
			if (getUsuariosPermissaoRemover().contains(actionUser)) {
				if (permissoes.contains(Permissao.ADICIONAR_USUARIO) && this.getUsuariosPermissaoAdicionar().contains(usuario)) {
					permissaoAdicionar.remove(usuario);
					} else if (permissoes.contains(Permissao.ALTERAR_PERMISSAO) && this.getUsuariosPermissaoAlterar().contains(usuario)) {
						permissaoAlterar.remove(usuario);
						} else if (permissoes.contains(Permissao.REMOVER_USUARIO) && this.getUsuariosPermissaoRemover().contains(usuario)) {
							permissaoRemover.remove(usuario);
							} else if (permissoes.contains(Permissao.VISUALIZAR_INFO) && this.getUsuariosPermissaoVisualizar().contains(usuario)) {
								permissaoVisualizar.remove(usuario);
								} else if (permissoes.contains(Permissao.CRIAR_CARTAO) && this.getUsuariosPermissaoCriarCartao().contains(usuario)) {
					this.permissaoCriarCartao.remove(usuario);
				}

				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean adicionarCartao(Cartao newCard) {
		this.cartoesAFazer.add(newCard);
		
		return true;
	}
}
