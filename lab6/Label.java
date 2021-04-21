package lab6;

public enum Label {
	TO_DO ("Para fazer", "Vermelho"), 
	DOING ("Fazendo", "Amarelo"), 
	DONE ("Feito", "Verde");
	
	private final String rotulo;
	private final String cor;
	
	Label(String rotulo, String cor) {
		this.rotulo = rotulo;
		this.cor = cor;
	}
	
	public String getRotulo() {
		return rotulo;
	}
	
	public String getCor() {
		return cor;
	}
	
	public String getAtributos() {
		String out = "Rótulo do label: " + getRotulo() + "\n";
		out += "Cor do label: " + getCor() + "\n";
		return out;
	}
}
