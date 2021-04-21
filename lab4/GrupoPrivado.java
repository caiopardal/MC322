package lab4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;

public class GrupoPrivado extends Grupo {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public GrupoPrivado (String nome, String descricao, Usuario dono) {
		super(nome, descricao, dono);
		super.permissaoAdicionar.add(dono);
		super.permissaoRemover.add(dono);
		super.permissaoAlterar.add(dono);
		super.permissaoVisualizar.add(dono);
	}

	public GrupoPrivado(int id, String nome, String descricao, Usuario dono, boolean status,
			GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, status, dataCriacao);
		super.permissaoAdicionar.add(dono);
		super.permissaoRemover.add(dono);
		super.permissaoAlterar.add(dono);
		super.permissaoVisualizar.add(dono);
	}	
	
	@Override
	public String toString() {
		String out = "";
		out += "GrupoPrivado [getId=" + getId();
		out += ", getNome()=" + getNome();
		out += ", getDescricao()=" + getDescricao();
		out += ", isStatus()=" + isStatus();
		out += ", getDataCriacao()=" + (getDataCriacao() != null ? formatter.format(getDataCriacao().getTime()) : null);
		out += ", getDono()=" + getDono();
		if (getMembros() != null && !getMembros().isEmpty()) {
			out += "\nMembros:\n";
			for (int i=0; i < getMembros().size(); i++) {
				Usuario membro = getMembros().get(i);
				out += " * " + membro + "\n";
			}
		}
		if (getUsuariosPermissaoAdicionar() != null && !getUsuariosPermissaoAdicionar().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoAdicionar().size(); i++) {
				out += "\nUsuário Permissão Adicionar:\n";
				Usuario usuario = getUsuariosPermissaoAdicionar().get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (getUsuariosPermissaoRemover() != null && !getUsuariosPermissaoRemover().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoRemover().size(); i++) {
				out += "\nUsuário Permissão Remover:\n";
				Usuario usuario = getUsuariosPermissaoRemover().get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (getUsuariosPermissaoAlterar() != null && !getUsuariosPermissaoAlterar().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoAlterar().size(); i++) {
				out += "\nUsuário Permissão Alterar:\n";
				Usuario usuario = getUsuariosPermissaoAlterar().get(i);
				out += " * " + usuario + "\n";
			}
		}
		if (getUsuariosPermissaoVisualizar() != null && !getUsuariosPermissaoVisualizar().isEmpty()) {
			for (int i=0; i < getUsuariosPermissaoVisualizar().size(); i++) {
				out += "\nUsuário Permissão Visualizar:\n";
				Usuario usuario = getUsuariosPermissaoVisualizar().get(i);
				out += " * " + usuario + "\n";
			}
		}
		out += "];";
		
		return out;
	}
	
	public boolean adicionaMembro(Usuario usuario, Usuario actionUser, ArrayList<Permissao> permissoes) {
		boolean status = super.isStatus();
		Usuario dono = super.getDono();
		
		if (status && dono == actionUser) {
			membros.add(usuario);
			if (permissoes != null && !permissoes.isEmpty()) {
				if (permissoes.contains(Permissao.ALTERAR_PERMISSAO)) {
					permissaoAlterar.add(usuario);
				} else if (permissoes.contains(Permissao.REMOVER_USUARIO)) {
					permissaoRemover.add(usuario);
				} else if (permissoes.contains(Permissao.VISUALIZAR_INFO)) {
					permissaoVisualizar.add(usuario);
				}

				permissaoAdicionar.add(usuario);
			}
			
			return true;
		}
		
		return false;
	}
	
	public boolean removeMembro(Usuario usuario, Usuario actionUser) {
		boolean status = super.isStatus();
		Usuario dono = super.getDono();
		
		if (status && dono == actionUser) {
			membros.remove(usuario);

			if (getUsuariosPermissaoAdicionar().contains(usuario)) {
				getUsuariosPermissaoAdicionar().remove(usuario);
			} else if (getUsuariosPermissaoRemover().contains(usuario)) {
				getUsuariosPermissaoRemover().remove(usuario);
			} else if (getUsuariosPermissaoAlterar().contains(usuario)) {
				getUsuariosPermissaoAlterar().remove(usuario);
			} else if (getUsuariosPermissaoVisualizar().contains(usuario)) {
				getUsuariosPermissaoVisualizar().remove(usuario);
			}
			
			return true;
		}
		
		return false;
	}
	
	public boolean adicionarPermissao(Usuario usuario, Usuario actionUser, ArrayList<Permissao> permissoes) {
		Usuario dono = super.getDono();
		
		if (dono == actionUser && permissoes != null && !permissoes.isEmpty()) {
			if (getUsuariosPermissaoAdicionar().contains(actionUser)) {
				if (permissoes.contains(Permissao.ADICIONAR_USUARIO)) {
					permissaoAdicionar.add(usuario);
				} else if (permissoes.contains(Permissao.ALTERAR_PERMISSAO)) {
					permissaoAlterar.add(usuario);
				} else if (permissoes.contains(Permissao.REMOVER_USUARIO)) {
					permissaoRemover.add(usuario);
				} else if (permissoes.contains(Permissao.VISUALIZAR_INFO)) {
					permissaoVisualizar.add(usuario);
				}

				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
	
	public boolean removerPermissao(Usuario usuario, Usuario actionUser, ArrayList<Permissao> permissoes) {
		Usuario dono = super.getDono();
		
		if (dono == actionUser && permissoes != null && !permissoes.isEmpty()) {
			if (getUsuariosPermissaoAdicionar().contains(actionUser)) {
				if (permissoes.contains(Permissao.ADICIONAR_USUARIO)) {
					permissaoAdicionar.remove(usuario);
				} else if (permissoes.contains(Permissao.ALTERAR_PERMISSAO)) {
					permissaoAlterar.remove(usuario);
				} else if (permissoes.contains(Permissao.REMOVER_USUARIO)) {
					permissaoRemover.remove(usuario);
				} else if (permissoes.contains(Permissao.VISUALIZAR_INFO)) {
					permissaoVisualizar.remove(usuario);
				}
			
				return true;
			} else {
				return false;
			}
		}
		
		return false;
	}
}
