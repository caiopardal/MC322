package lab3;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.GregorianCalendar;

public class GrupoPublico extends Grupo {
	DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	
	public GrupoPublico(String nome, String descricao, Usuario dono) {
		super(nome, descricao, dono);
	}

	public GrupoPublico(int id, String nome, String descricao, Usuario dono, boolean status,
			GregorianCalendar dataCriacao) {
		super(id, nome, descricao, dono, status, dataCriacao);
	}
	
	@Override
	public String toString() {
		String out = "";
		out += "GrupoPublico [getId=" + getId();
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
		out += "];";
		
		return out;
	}
	
	public boolean adicionaMembro(Usuario usuario) {
		boolean status = super.isStatus();
		
		if (status) {
			membros.add(usuario);
			
			return true;
		}
		
		return false;
	}
	
	public boolean removeMembro(Usuario usuario) {
		boolean status = super.isStatus();
		
		if (status) {
			membros.remove(usuario);
			
			return true;
		}
		
		return false;
	}
}
