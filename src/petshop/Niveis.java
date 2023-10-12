package petshop;

public class Niveis {
	private String [] nivel1 = {"liquidificador", "esmeralda", "espumante", "encaçapar", "lambari", "esmero", "esgrima", "eufemismo", "escorregador", "aspirina"};
	private String [] dicas1 = {"Eletrodoméstico", "Minério", "Bebida alcoólica", "Termo uilizado na sinuca (verbo)", "Espécie de peixe", "Sinônimo de apreço/cuidado", "Esporte", "Figura de linguagem", "Brinquedo infantil", "Remédio"};
	private String [] nivel2 = {"leucemia", "eucarionte", "extintor", "onomatopeia", "epifania", "peculiar", "presepada", "patela", "laringe", "autenticidade"};
	private String [] dicas2 = {"Tipo de câncer", "Célula", "Usado em certos tipos de emergência", "Palavra que emite o som de algo", "Sensação de súbito entendimento de algo", "Sinônimo de único", "Sinônimo de confusão", "Osso do corpo humano", "Parte do corpo humano", "Sinônimo de originalidade"};
	
	public String[] getNivel1() {
		return nivel1;
	}
	public void setNivel1(String[] nivel1) {
		this.nivel1 = nivel1;
	}
	public String[] getDicas1() {
		return dicas1;
	}
	public void setDicas1(String[] dicas1) {
		this.dicas1 = dicas1;
	}
	public String[] getNivel2() {
		return nivel2;
	}
	public void setNivel2(String[] nivel2) {
		this.nivel2 = nivel2;
	}
	public String[] getDicas2() {
		return dicas2;
	}
	public void setDicas2(String[] dicas2) {
		this.dicas2 = dicas2;
	}
	
}
